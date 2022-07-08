package br.com.senai.controlegestaopessoasapi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String titulo;
	
	@Column(name="descricao_longa")
	private String descricaoLonga;
	
	@Column(name="dt_localizacao")
	private LocalDate dataLocalizacao;
	
	@Column(name="id")
	private List<Facilitador> facilitadores;
}
