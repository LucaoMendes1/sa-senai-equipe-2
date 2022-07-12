package br.com.senai.controlegestaopessoasapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.controlegestaopessoasapi.entity.Usuario;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@GetMapping(value = "/buscar/{id}")
	public Usuario buscarPor(@PathVariable("id") String id) {
		
		Usuario usuario = new Usuario();
		usuario.setLogin("");
		
		return usuario;
	}

}
