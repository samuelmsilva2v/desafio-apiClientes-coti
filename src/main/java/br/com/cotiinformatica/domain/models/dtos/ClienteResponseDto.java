package br.com.cotiinformatica.domain.models.dtos;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class ClienteResponseDto {

	private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Date dataNascimento;
    private List<EnderecoResponseDto> enderecos;
}
