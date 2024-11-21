package br.com.cotiinformatica.infrastructure.components;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cotiinformatica.domain.models.collections.LogMensageria;
import br.com.cotiinformatica.domain.models.dtos.MensagemClienteResponse;
import br.com.cotiinformatica.infrastructure.repositories.LogMensageriaRepository;

@Component
public class RabbitMQProducerComponent {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue queue;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private LogMensageriaRepository logMensageriaRepository;

	public void send(MensagemClienteResponse mensagem) throws Exception {

		var logMensageria = new LogMensageria();
		logMensageria.setId(UUID.randomUUID());
		logMensageria.setDataHora(new Date());
		logMensageria.setOperacao("ENVIO DE MENSAGEM PARA A FILA");

		try {
			
			String json = objectMapper.writeValueAsString(mensagem);

			rabbitTemplate.convertAndSend(queue.getName(), json);

			logMensageria.setStatus("SUCESSO");
			logMensageria.setDescricao(json);
		} 
		catch (Exception e) {

			logMensageria.setStatus("ERRO");
			logMensageria.setDescricao(e.getMessage());
		} 
		finally {
			logMensageriaRepository.save(logMensageria);
		}
	}
}
