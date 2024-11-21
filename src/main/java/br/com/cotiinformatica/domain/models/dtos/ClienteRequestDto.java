package br.com.cotiinformatica.domain.models.dtos;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteRequestDto {
	
	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 8, max = 100, message = "O nome deve ter entre 8 e 100 caracteres.")
	private String nome;
	
	@NotBlank(message = "O email é obrigatório.")
	@Email(message = "Formato de email inválido.")
	private String email;
	
	@NotBlank(message = "O CPF é obrigatório.")
	@Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos numéricos.")
	private String cpf;
	
	@NotNull(message = "A data de nascimento é obrigatória.")
	@Past(message = "A data de nascimento deve estar no passado.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataNascimento;
	
	@NotNull(message = "A lista de endereços é obrigatória.")
	@Size(min = 1, message = "Deve haver pelo menos um endereço.")
	private List<EnderecoRequestDto> enderecos;
}
