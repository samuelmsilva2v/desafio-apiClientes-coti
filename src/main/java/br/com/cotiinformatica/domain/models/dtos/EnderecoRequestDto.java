package br.com.cotiinformatica.domain.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoRequestDto {

	@NotBlank(message = "O logradouro é obrigatório.")
	@Size(min = 3, max = 150, message = "O logradouro deve ter entre 3 e 150 caracteres.")	
	private String logradouro;
	
	@Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres.")
	private String complemento;
	
	@NotBlank(message = "O número é obrigatório.")
	@Size(max = 10, message = "O número deve ter no máximo 10 caracteres.")
	private String numero;
	
	@NotBlank(message = "O bairro é obrigatório.")
	@Size(min = 3, max = 100, message = "O bairro deve ter entre 3 e 100 caracteres.")
	private String bairro;
	
	@NotBlank(message = "A cidade é obrigatória.")
	@Size(min = 3, max = 100, message = "A cidade deve ter entre 3 e 100 caracteres.")
	private String cidade;
	
	@NotBlank(message = "O estado (UF) é obrigatório.")
	@Size(min = 2, max = 2, message = "O estado (UF) deve conter exatamente 2 caracteres.")
	private String uf;
	
	@NotBlank(message = "O CEP é obrigatório.")
	@Pattern(regexp = "\\d{8}", message = "O CEP deve conter exatamente 8 dígitos numéricos.")
	private String cep;
}
