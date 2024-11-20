package br.com.cotiinformatica.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.domain.models.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

}
