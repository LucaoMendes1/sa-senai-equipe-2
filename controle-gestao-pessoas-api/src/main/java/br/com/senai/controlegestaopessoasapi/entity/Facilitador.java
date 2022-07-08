package br.com.senai.controlegestaopessoasapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	@Max(value = 50, message = "O nome completo deve ter no máxio 50 caracteres")
	@Min(value = 2, message = "O nome completo deve ter pelo menos 2 caracteres")
	@NotEmpty(message = "O nome completo é obrigatório")
	private String nomeCompleto;
	
	@Column(name="cpf")
	@Max(value = 14, message = "O cpf deve ter 14 caracteres")
	@Min(value = 14, message = "O cpf deve ter 14 caracteres")
	@NotEmpty(message = "O cpf é obrigatório")
	private String cpf;
	
	@Column(name="rg")
	@Max(value = 10, message = "O rg deve ter 10 caracteres")
	@Min(value = 10, message = "O rg deve ter 10 caracteres")
	@NotEmpty(message = "O cpf é obrigatório")
	private String rg;
	
	@Column(name="formacao")
	@Max(value = 1000, message = "A formação deve ter no máximo 1000 caracteres")
	@Min(value = 2, message = "A formação deve ter no mínimo 2 caracteres")
	@NotEmpty(message = "O cpf é obrigatório")
	private String formacao;
	
	@Column(name="login")
	@Max(value = 20, message = "O login deve ter no máxio 20 caracteres")
	@Min(value = 2, message = "O login deve ter pelo menos 2 caracteres")
	@NotEmpty(message = "O login é obrigatório")
	private String login;
	
	@Column(name="senha")
	@Max(value = 10, message = "A senha deve ter no máxio 10 caracteres")
	@Min(value = 2, message = "A senha deve ter pelo menos 2 caracteres")
	@NotEmpty(message = "A senha é obrigatória")
	private String senha;
}
