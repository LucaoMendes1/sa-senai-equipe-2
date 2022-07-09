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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	@Max(value = 100, message = "O título deve ter no máximo 100 caracteres")
	@Min(value = 2, message = "O nome completo deve ter pelo menos 2 caracteres")
	@NotEmpty(message = "O título é obrigatório")
	private String titulo;
	
	@Column(name="descricao_longa")
	@Max(value = 1500, message = "A descrição longa deve ter no máximo 1500 caracteres")
	@Min(value = 10, message = "A descrição longa deve ter pelo menos 10 caracteres")
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
