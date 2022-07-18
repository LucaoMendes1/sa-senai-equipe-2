package br.com.senai.controlegestaopessoasapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	@Size(max = 50, min = 2, message = "O login deve ter pelo menos 2 e no máximo 50 caracteres")
	@NotEmpty(message = "O nome completo é obrigatório")
	private String nomeCompleto;
	
	@Column(name="cpf")
	@Size(max = 14, min = 14, message = "O login deve ter pelo menos 14 e no máximo 14 caracteres")
	@NotEmpty(message = "O cpf é obrigatório")
	private String cpf;
	
	@Column(name="rg")
	@Size(max = 10, min = 10, message = "O login deve ter pelo menos 10 e no máximo 10 caracteres")
	@NotEmpty(message = "O cpf é obrigatório")
	private String rg;
	
	@Column(name="formacao")
	@Size(max = 1000, min = 2, message = "O login deve ter pelo menos 2 e no máximo 1000 caracteres")
	@NotEmpty(message = "O cpf é obrigatório")
	private String formacao;
	
	@Column(name="login")
	@Size(max = 20, min = 2, message = "O login deve ter pelo menos 2 e no máximo 20 caracteres")
	@NotEmpty(message = "O login é obrigatório")
	private String login;
	
	@Column(name="senha")
	@Size(max = 10, min = 2, message = "O login deve ter pelo menos 2 e no máximo 10 caracteres")
	@NotEmpty(message = "A senha é obrigatória")
	private String senha;
	
	@Transient
	public boolean isNovo() {
		return getId() == null || getId() == 0;
	}
}
