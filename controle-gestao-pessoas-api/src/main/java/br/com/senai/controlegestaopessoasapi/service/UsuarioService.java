package br.com.senai.controlegestaopessoasapi.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.controlegestaopessoasapi.entity.Usuario;
import br.com.senai.controlegestaopessoasapi.repository.UsuarioRepository;

@Service
@Valid
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario autenticar(Usuario usuario) {
		return repository.buscarPor(usuario.getLogin(), usuario.getSenha());
	}
}
