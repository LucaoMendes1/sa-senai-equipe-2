package br.com.senai.controlegestaopessoasapi.controller;

import java.net.URI;
import java.util.Map;

import org.json.JSONObject;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.senai.controlegestaopessoasapi.entity.Treinamento;
import br.com.senai.controlegestaopessoasapi.service.TreinamentoService;

@RestController
@RequestMapping("/treinamentos")
public class TreinamentoController {

	@Autowired
	private TreinamentoService service;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private MapConverter mapConverter;

	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Treinamento novoTreinamento) {
		Treinamento treinamentoSalvo = service.inserir(novoTreinamento);
		return ResponseEntity.created(URI.create("/treinamentos/id/" + treinamentoSalvo.getId())).build();
	}

	@PutMapping
	public ResponseEntity<?> alterar(@RequestBody Map<String, Object> treinamentoMap) {
		Treinamento treinamentoSalvo = mapper.convertValue(treinamentoMap, Treinamento.class);
		Treinamento treinamentoAtualizado = service.alterar(treinamentoSalvo);
		return ResponseEntity.ok(mapConverter.toJsonMap(treinamentoAtualizado));
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> buscarPor(@PathVariable("id") Integer id) throws JsonProcessingException {
		Treinamento treinamentoEncontrado = service.buscarPor(id);
		String json = mapper.writeValueAsString(treinamentoEncontrado);
		JSONObject jsonObj = new JSONObject(json);
		return ResponseEntity.ok(jsonObj.toMap());
	}

	@GetMapping(value = "/titulo/{titulo}")
	public ResponseEntity<?> listarPor(@PathVariable(name = "titulo") String titulo) {
		return ResponseEntity.ok(mapConverter.toJsonList(service.listarPor(titulo)));
	}

	@DeleteMapping(value = "/id/{id}")
	public ResponseEntity<?> removerPor(@PathVariable(name = "id") Integer id) {
		this.service.removerPor(id);
		return ResponseEntity.noContent().build();
	}

}
