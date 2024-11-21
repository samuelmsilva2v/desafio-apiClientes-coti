package br.com.cotiinformatica.domain.models.dtos;

import lombok.Data;

@Data
public class MensagemClienteResponse {

	private String emailDestinatario;
	private String assunto;
	private String texto;
}
