package br.com.senai.controlegestaopessoasapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.controlegestaopessoasapi.repository.UsuarioRepository;
import br.com.senai.controlegestaopessoasapi.service.UsuarioService;

@SpringBootApplication
public class ControleGestaoPessoasApiApplication {

	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ControleGestaoPessoasApiApplication.class, args);
	}
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			service.remover(repository.buscarPor("Kevin", "123456"));
		};
	}

}
