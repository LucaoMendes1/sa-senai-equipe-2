package br.com.senai.controlegestaopessoasapi.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.senai.controlegestaopessoasapi.entity.Facilitador;
import br.com.senai.controlegestaopessoasapi.service.FacilitadorService;

@RestController
@RequestMapping("/facilitadores")
public class FacilitadorController {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private MapConverter mapConverter;

	@Autowired
	private FacilitadorService service;

	@PostMapping
	public ResponseEntity<?> inserir (@RequestBody Facilitador novoFacilitador) {
		Facilitador facilitadorSalvo = 
				service.inserir(novoFacilitador);
		return ResponseEntity.created(URI.create("/facilitadores/id/" + facilitadorSalvo.getId())).build();
	}

	@PutMapping
	public ResponseEntity<?> alterar (@RequestBody Map<String, Object> facilitadorMap) {
		Facilitador facilitadorSalvo =
				mapper.convertValue(facilitadorMap, Facilitador.class);
		Facilitador facilitadorAtualizado = 
				service.alterar(facilitadorSalvo);
		return ResponseEntity.ok(mapConverter.toJsonMap(facilitadorAtualizado));
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> buscarPor (@PathVariable(name = "id") Integer id) {
		return ResponseEntity.ok(mapConverter.toJsonMap(service.buscarPor(id)));
	}
	
	@GetMapping(value = "/nomeCompleto/{nomeCompleto}")
	public ResponseEntity<?> listarPor(
			@PathVariable(name = "nomeCompleto")
			String nomeCompleto){
		return ResponseEntity.ok(mapConverter
				.toJsonList(service.listarPor(nomeCompleto)));
	}
	
	

	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> excluirPor(@PathVariable(name = "id") Integer id) {
		this.service.removerPor(id);
		return ResponseEntity.noContent().build();
	}

}
