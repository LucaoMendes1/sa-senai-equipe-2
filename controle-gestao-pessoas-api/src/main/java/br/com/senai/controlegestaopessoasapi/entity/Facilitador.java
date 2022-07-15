package br.com.senai.controlegestaopessoasapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

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
	@NotEmpty(message = "O nome completo é obrigatório")
	private String nomeCompleto;
	
	@Column(name="cpf")
	@NotEmpty(message = "O cpf é obrigatório")
	private String cpf;
	
	@Column(name="rg")
	@NotEmpty(message = "O cpf é obrigatório")
	private String rg;
	
	@Column(name="formacao")
	@NotEmpty(message = "O cpf é obrigatório")
	private String formacao;
	
	@Column(name="login")
	@NotEmpty(message = "O login é obrigatório")
	private String login;
	
	@Column(name="senha")
	@NotEmpty(message = "A senha é obrigatória")
	private String senha;
	
	@Transient
	public boolean isNovo() {
		return getId() == null || getId() == 0;
	}
}
