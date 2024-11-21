package br.com.cotiinformatica.infrastructure.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
	Queue queue() {
		return new Queue("mensagens-usuarios", true);
	}
}
