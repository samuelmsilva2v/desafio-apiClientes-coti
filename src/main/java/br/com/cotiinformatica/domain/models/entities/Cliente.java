package br.com.cotiinformatica.domain.models.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="tb_cliente")
@Data
public class Cliente {

	@Id
	private UUID id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false, unique = true, length = 11)
	private String cpf;
	
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;
}
