package br.com.senai.controlegestaopessoasview.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Facilitador {

	@EqualsAndHashCode.Include
	private Integer id;

	private String cpf;

	private String rg;

	private String formacao;

	private Usuario usuario;
	
	@Override
	public String toString() {
		return id + " - " + usuario.getNomeCompleto();
	}
}
