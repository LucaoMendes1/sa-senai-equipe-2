package br.com.senai.controlegestaopessoasview.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Facilitador {

	@EqualsAndHashCode.Include
	private Integer id;

	private String nomeCompleto;

	private String cpf;

	private String rg;

	private String formacao;

	private String login;

	private String senha;

	@Override
	public String toString() {
		return id + " - " + nomeCompleto;
	}
}
