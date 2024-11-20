package br.com.cotiinformatica.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.models.dtos.EnderecoRequestDto;
import br.com.cotiinformatica.domain.models.dtos.EnderecoResponseDto;

public interface EnderecoDomainService {

	public EnderecoResponseDto cadastrar(EnderecoRequestDto request) throws Exception;

	public EnderecoResponseDto atualizar(UUID id, EnderecoRequestDto request) throws Exception;

	public EnderecoResponseDto excluir(UUID id) throws Exception;

	public EnderecoResponseDto obterPorId(UUID id) throws Exception;

	public List<EnderecoResponseDto> consultar() throws Exception;
}
