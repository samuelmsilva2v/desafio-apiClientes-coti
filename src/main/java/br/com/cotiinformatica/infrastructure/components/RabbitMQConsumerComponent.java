package br.com.cotiinformatica.infrastructure.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumerComponent {

	@RabbitListener(queues = {"mensagens-usuarios"})
	public void proccess(@Payload String message) throws Exception {
		System.out.println("\nMENSAGEM PROCESSADA COM SUCESSO!");
		System.out.println(message);
	}
}
