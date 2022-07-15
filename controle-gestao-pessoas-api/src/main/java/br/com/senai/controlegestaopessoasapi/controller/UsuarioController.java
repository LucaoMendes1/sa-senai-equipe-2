package br.com.senai.controlegestaopessoasapi.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.controlegestaopessoasapi.entity.Usuario;
import br.com.senai.controlegestaopessoasapi.service.UsuarioService;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public ResponseEntity<?> logar(@RequestBody Usuario usuario) {

		return ResponseEntity.ok(service.autenticar(usuario));
	}

}
