package br.com.senai.controlegestaopessoasapi.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.controlegestaopessoasapi.entity.Usuario;
import br.com.senai.controlegestaopessoasapi.repository.UsuarioRepository;

@Service
@Validated
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario autenticar(@NotNull(message = "O usuário não pode estar nulo") Usuario usuario) {
		return repository.buscarPor(usuario.getLogin(), usuario.getSenha());
	}
	
	public Usuario buscarPor(@NotNull(message = "O login não pode estar nulo") String login,
				@NotNull(message = "A senha não pode estar nula") String senha) {
		return repository.buscarPor(login, senha);
	};
	
}
