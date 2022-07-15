package br.com.senai.controlegestaopessoasapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity(name="Treinamento")
@Table(name="treinamentos")
@Data
public class Treinamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="titulo")
	@NotEmpty(message = "O título é obrigatório")
	private String titulo;
	
	@Column(name="descricao_longa")
	private String descricaoLonga;
	
	@Column(name="dt_localizacao")
	@NotNull(message = "A data de localização é obrigatória")
	private LocalDate dataLocalizacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull(message = "O facilitador é obrigatório")
	private Facilitador facilitador;
	
	@Transient
	public boolean isNovo() {
		return getId() == null || getId() == 0;
	}

	
}
