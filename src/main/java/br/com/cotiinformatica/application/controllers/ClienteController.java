package br.com.cotiinformatica.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.models.dtos.ClienteRequestDto;
import br.com.cotiinformatica.domain.models.dtos.ClienteResponseDto;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@PostMapping
	public ClienteResponseDto insert(@RequestBody ClienteRequestDto request) {
		// TODO
		return null;
	}

	@PutMapping
	public ClienteResponseDto update(@PathVariable UUID id, @RequestBody ClienteRequestDto request) {
		// TODO
		return null;
	}

	@DeleteMapping("{id}")
	public ClienteResponseDto delete(@PathVariable UUID id) {
		// TODO
		return null;
	}

	@GetMapping("{id}")
	public ClienteResponseDto getById(@PathVariable UUID id) {
		// TODO
		return null;
	}

	@GetMapping
	public List<ClienteResponseDto> getAll() {
		// TODO
		return null;
	}
}
