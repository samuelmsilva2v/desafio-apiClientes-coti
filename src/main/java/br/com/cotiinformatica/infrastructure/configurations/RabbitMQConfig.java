package br.com.cotiinformatica.infrastructure.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {

	@Bean
	Queue queue() {
		// configurando o nome da fila
		//que será criada / acessada
		// no servidor de mensageria do rabbitmq
		return new Queue("mensagens-usuarios", true);
	}
}
