package br.com.cotiinformatica.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.models.dtos.ClienteRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteResponseDto;
import br.com.cotiinformatica.domain.services.impl.ClienteDomainServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteDomainServiceImpl clienteDomainServiceImpl;

	@PostMapping
	public ClienteResponseDto insert(@RequestBody @Valid ClienteRequestDto request) throws Exception {
		return clienteDomainServiceImpl.cadastrar(request);
	}

	@PutMapping("{id}")
	public ClienteResponseDto update(@PathVariable UUID id, @RequestBody @Valid ClienteRequestDto request) throws Exception {
		return clienteDomainServiceImpl.atualizar(id, request);
	}

	@DeleteMapping("{id}")
	public ClienteResponseDto delete(@PathVariable UUID id) throws Exception {
		return clienteDomainServiceImpl.excluir(id);
	}

	@GetMapping("{id}")
	public ClienteResponseDto getById(@PathVariable UUID id) throws Exception {
		return clienteDomainServiceImpl.obterPorId(id);
	}

	@GetMapping
	public List<ClienteResponseDto> getAll() throws Exception {
		return clienteDomainServiceImpl.consultar();
	}
}
