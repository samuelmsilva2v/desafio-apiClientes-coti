package br.com.cotiinformatica.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.models.dtos.ClienteRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteResponseDto;

public interface ClienteDomainService {

	public ClienteResponseDto cadastrar(ClienteRequestDto request) throws Exception;
	
	public ClienteResponseDto atualizar(UUID id, ClienteRequestDto request) throws Exception;
	
	public ClienteResponseDto excluir(UUID id) throws Exception;
	
	public ClienteResponseDto obterPorId(UUID id) throws Exception;
	
	public List<ClienteResponseDto> consultar() throws Exception;
}
