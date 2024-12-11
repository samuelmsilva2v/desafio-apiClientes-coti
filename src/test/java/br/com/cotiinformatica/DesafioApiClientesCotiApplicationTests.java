package br.com.cotiinformatica;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DesafioApiClientesCotiApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Order(1)
	void cadastrarClienteTest() throws Exception {
		fail("Não implementado.");
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
