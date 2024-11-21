package br.com.cotiinformatica.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cotiinformatica.domain.models.collections.LogMensageria;

public interface LogMensageriaRepository extends MongoRepository<LogMensageria, UUID>{

}
