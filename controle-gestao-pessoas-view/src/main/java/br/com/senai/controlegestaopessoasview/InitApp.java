package br.com.senai.controlegestaopessoasview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.controlegestaopessoasview.tela.TelaDeLogin;
import br.com.senai.controlegestaopessoasview.tela.TelaInsercaoEdicaoTreinamento;


@SpringBootApplication
public class InitApp {

	@Autowired
	private TelaDeLogin telaDeLogin;
	public static void main(String[] args) {
		SpringApplicationBuilder builder = 
				new SpringApplicationBuilder(InitApp.class);
		builder.headless(false);
		builder.run(args);
	}
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			telaDeLogin.setVisible(true);
		};
	}

}
