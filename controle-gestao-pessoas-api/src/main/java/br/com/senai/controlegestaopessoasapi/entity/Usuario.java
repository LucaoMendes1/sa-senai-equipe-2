package br.com.senai.controlegestaopessoasapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import br.com.senai.controlegestaopessoasapi.entity.enums.Tipo;
import lombok.Data;

@Entity(name="Usuario")
@Table(name="usuarios")
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="login")
	@NotEmpty(message = "O login é obrigatório")
	private  String login;
	
	@Column(name="nome_completo")
	@NotEmpty(message = "O nome completo é obrigatório")
	private String nomeCompleto;
	
	@Column(name="senha")
	@NotEmpty(message = "A senha é obrigatória")
	private String senha;
	
	@Column(name="tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Transient
	public boolean isNovo() {
		return getId() == null || getId() == 0;
	}
}
