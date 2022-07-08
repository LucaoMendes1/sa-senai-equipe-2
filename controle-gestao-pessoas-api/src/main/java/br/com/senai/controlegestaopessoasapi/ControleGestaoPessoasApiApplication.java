package br.com.senai.controlegestaopessoasapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ControleGestaoPessoasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleGestaoPessoasApiApplication.class, args);
	}
	
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			
		};
	}

}
