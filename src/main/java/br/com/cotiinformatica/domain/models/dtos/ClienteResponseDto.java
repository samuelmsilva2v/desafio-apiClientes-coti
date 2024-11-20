package br.com.cotiinformatica.domain.models.dtos;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class ClienteResponseDto {

	private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private Date dataNascimento;
    private List<EnderecoResponseDto> enderecos;
}
