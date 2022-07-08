package br.com.senai.controlegestaopessoasapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.controlegestaopessoasapi.entity.Usuario;
import br.com.senai.controlegestaopessoasapi.service.UsuarioService;

@SpringBootApplication
public class ControleGestaoPessoasApiApplication {

	
	@Autowired
	private UsuarioService service;
	
	public static void main(String[] args) {
		SpringApplication.run(ControleGestaoPessoasApiApplication.class, args);
	}
	
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			Usuario usuario = new Usuario();
			usuario.setLogin("Kevin");
			usuario.setSenha("123456");
			System.out.println("+++++++++++=======>" +service.autenticar(usuario));
		};
	}

}
