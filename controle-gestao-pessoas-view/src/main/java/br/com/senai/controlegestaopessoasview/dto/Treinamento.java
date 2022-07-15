package br.com.senai.controlegestaopessoasview.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Treinamento {

	@EqualsAndHashCode.Include
	private Integer id;

	private String descricaoLonga;

	private LocalDate dataLocalizacao;

	private Facilitador facilitador;

}
