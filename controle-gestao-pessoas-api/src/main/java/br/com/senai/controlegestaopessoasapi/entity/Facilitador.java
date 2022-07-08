package br.com.senai.controlegestaopessoasapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="Facilitador")
@Table(name="facilitadores")
@Data
public class Facilitador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome_completo")
	private String nomeCompleto;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="rg")
	private String rg;
	
	@Column(name="formacao")
	private String formacao;
	
	@Column(name="login")
	private String login;
	
	@Column(name="senha")	
	private String senha;
}
