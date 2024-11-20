package br.com.cotiinformatica.domain.models.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="tb_endereco")
@Data
public class Endereco {

	@Id
	private UUID id;
	
	@Column(nullable = false)
	private String logradouro;
	private String complemento;
	
	@Column(nullable = false)
	private String numero;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false, length = 2)
	private String uf;
	
	@Column(nullable = false, length = 8)
	private String cep;
	
	@ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
}
