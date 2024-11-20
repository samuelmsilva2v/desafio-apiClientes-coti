package br.com.cotiinformatica.domain.models.dtos;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ClienteRequestDto {
	
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
	private List<EnderecoRequestDto> enderecos;
}
