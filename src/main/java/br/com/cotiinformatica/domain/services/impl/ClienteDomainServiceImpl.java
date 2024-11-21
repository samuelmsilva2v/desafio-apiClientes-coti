package br.com.cotiinformatica.domain.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.models.dtos.ClienteRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteResponseDto;
import br.com.cotiinformatica.domain.models.dtos.MensagemClienteResponse;
import br.com.cotiinformatica.domain.models.entities.Cliente;
import br.com.cotiinformatica.domain.models.entities.Endereco;
import br.com.cotiinformatica.domain.services.interfaces.ClienteDomainService;
import br.com.cotiinformatica.infrastructure.components.RabbitMQProducerComponent;
import br.com.cotiinformatica.infrastructure.repositories.ClienteRepository;
import br.com.cotiinformatica.infrastructure.repositories.EnderecoRepository;

@Service
public class ClienteDomainServiceImpl implements ClienteDomainService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RabbitMQProducerComponent rabbitMQProducerComponent;
	
	@Override
	public ClienteResponseDto cadastrar(ClienteRequestDto request) throws Exception {

		var cliente = modelMapper.map(request, Cliente.class);
		cliente.setId(UUID.randomUUID());

		List<Endereco> enderecos = request.getEnderecos().stream().map(enderecoDto -> {
			var endereco = modelMapper.map(enderecoDto, Endereco.class);
			endereco.setId(UUID.randomUUID());
			endereco.setCliente(cliente);
			return endereco;
		}).collect(Collectors.toList());

		cliente.setEnderecos(enderecos);

		clienteRepository.save(cliente);

		var endereco = cliente.getEnderecos().get(0);
		enderecoRepository.save(endereco);
		
		var mensagem = new MensagemClienteResponse();
		mensagem.setEmailDestinatario(cliente.getEmail());
		mensagem.setAssunto("Confirmação de cadastro");
		mensagem.setTexto("Olá, " + cliente.getNome() + ". Parabéns, seu cadastro foi realizado com sucesso!");
		
		rabbitMQProducerComponent.send(mensagem);

		return modelMapper.map(cliente, ClienteResponseDto.class);
	}

	@Override
	public ClienteResponseDto atualizar(UUID id, ClienteRequestDto request) throws Exception {

		var cliente = clienteRepository.findById(id).get();

		modelMapper.map(request, cliente);

		List<Endereco> enderecosAtualizados = request.getEnderecos().stream().map(enderecoDto -> {

			var enderecoExistente = cliente.getEnderecos().stream()
					.filter(endereco -> endereco.getLogradouro().equals(enderecoDto.getLogradouro())
							&& endereco.getComplemento().equals(enderecoDto.getComplemento())
							&& endereco.getNumero().equals(enderecoDto.getNumero())
							&& endereco.getBairro().equals(enderecoDto.getBairro())
							&& endereco.getCidade().equals(enderecoDto.getCidade())
							&& endereco.getUf().equals(enderecoDto.getUf())
							&& endereco.getCep().equals(enderecoDto.getCep()))
					.findFirst().orElse(null);

			if (enderecoExistente != null) {
				modelMapper.map(enderecoDto, enderecoExistente);
			} else {
				var novoEndereco = modelMapper.map(enderecoDto, Endereco.class);
				novoEndereco.setId(UUID.randomUUID());
				novoEndereco.setCliente(cliente);
				enderecoExistente = novoEndereco;
			}

			return enderecoExistente;
		}).collect(Collectors.toList());

		cliente.setEnderecos(enderecosAtualizados);

		clienteRepository.save(cliente);

		enderecoRepository.saveAll(enderecosAtualizados);

		return modelMapper.map(cliente, ClienteResponseDto.class);
	}

	@Override
	public ClienteResponseDto excluir(UUID id) throws Exception {

		var cliente = clienteRepository.findById(id).get();

		if (cliente.getEnderecos() != null && !cliente.getEnderecos().isEmpty())
			enderecoRepository.deleteAll(cliente.getEnderecos());

		clienteRepository.delete(cliente);

		return modelMapper.map(cliente, ClienteResponseDto.class);
	}

	@Override
	public ClienteResponseDto obterPorId(UUID id) throws Exception {

		var cliente = clienteRepository.findById(id).get();

		return modelMapper.map(cliente, ClienteResponseDto.class);
	}

	@Override
	public List<ClienteResponseDto> consultar() throws Exception {

		return clienteRepository.findAll().stream().map(cliente -> modelMapper.map(cliente, ClienteResponseDto.class))
				.collect(Collectors.toList());
	}

}
