package br.com.senai.controlegestaopessoasview.dto;

import lombok.Data;

@Data
public class Usuario {
	private String login;
	private String senha;
	private Tipo tipo;
	private String nomeCompleto;
	private int id;
}
