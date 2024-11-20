package br.com.cotiinformatica.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.models.dtos.EnderecoRequestDto;
import br.com.cotiinformatica.domain.models.dtos.EnderecoResponseDto;
import br.com.cotiinformatica.domain.services.interfaces.EnderecoDomainService;

@Service
public class EnderecoDomainServiceImpl implements EnderecoDomainService {

	@Override
	public EnderecoResponseDto cadastrar(EnderecoRequestDto request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnderecoResponseDto atualizar(UUID id, EnderecoRequestDto request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnderecoResponseDto excluir(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnderecoResponseDto obterPorId(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnderecoResponseDto> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
