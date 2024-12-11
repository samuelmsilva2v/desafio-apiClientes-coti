package br.com.cotiinformatica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.cotiinformatica.domain.models.dtos.ClienteRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteResponseDto;
import br.com.cotiinformatica.domain.models.dtos.EnderecoRequestDto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DesafioApiClientesCotiApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private static UUID id;

	@Test
	@Order(1)
	void cadastrarClienteTest() throws Exception {
		
		// Instanciando a biblioteca JavaFaker
		var faker = new Faker(Locale.forLanguageTag("pt-BR"));
		
		/*
		 * Preenchendo os dados para cadastrar o cliente
		 */
		var request = new ClienteRequestDto();
		request.setNome(faker.name().fullName());
		request.setEmail(faker.internet().emailAddress());
		request.setCpf(faker.number().digits(11));
		request.setDataNascimento(faker.date().birthday());
		
		var endereco = new EnderecoRequestDto();
		endereco.setLogradouro(faker.address().streetName());
		endereco.setNumero(faker.address().buildingNumber());
		endereco.setBairro(faker.address().city());
		endereco.setCidade(faker.address().cityName());
		endereco.setUf("RJ");
		endereco.setCep(faker.number().digits(8));
		
		request.setEnderecos(List.of(endereco));
		
		// Fazendo a requisição para o serviço do API
		var result = mockMvc.perform(post("/api/clientes")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andReturn();
		
		/*
		 * Capturando a mensagem devolvida pela API
		 * após a realização do cadastro
		 */
		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		// Ler os dados obtidos da API 
		var response = objectMapper.readValue(content, ClienteResponseDto.class);
		
		/*
		 * Verificando se os dados da resposta
		 * coincidem com os da requisição
		 */
		assertNotNull(response);
		assertNotNull(response.getId());
		assertEquals(request.getNome(), response.getNome());
		assertEquals(request.getEmail(), response.getEmail());
		
		id = response.getId();
	}

	@Test
	@Order(2)
	void atualizarClienteTest() throws Exception {
		fail("Não implementado.");
	}

	@Test
	@Order(3)
	void consultarClientesTest() throws Exception {
		fail("Não implementado.");
	}

	@Test
	@Order(4)
	void obterPorIdTest() throws Exception {
		fail("Não implementado.");
	}

	@Test
	@Order(5)
	void excluirClienteTest() throws Exception {
		fail("Não implementado.");
	}

}
