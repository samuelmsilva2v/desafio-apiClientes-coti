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

import br.com.cotiinformatica.domain.models.dtos.EnderecoRequestDto;
import br.com.cotiinformatica.domain.models.dtos.EnderecoResponseDto;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

	@PostMapping
	public EnderecoResponseDto insert(@RequestBody EnderecoRequestDto request) {
		// TODO
		return null;
	}

	@PutMapping
	public EnderecoResponseDto update(@PathVariable UUID id, @RequestBody EnderecoRequestDto request) {
		// TODO
		return null;
	}

	@DeleteMapping("{id}")
	public EnderecoResponseDto delete(@PathVariable UUID id) {
		// TODO
		return null;
	}

	@GetMapping("{id}")
	public EnderecoResponseDto getById(@PathVariable UUID id) {
		// TODO
		return null;
	}

	@GetMapping
	public List<EnderecoResponseDto> getAll() {
		// TODO
		return null;
	}
}
