package br.com.senai.controlegestaopessoasapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
	
	@Column(name="cpf")
	@Size(max = 14, min = 14, message = "O cpf deve ter pelo menos 14 e no máximo 14 caracteres")
	@NotEmpty(message = "O cpf é obrigatório")
	private String cpf;
	
	@Column(name="rg")
	@Size(max = 10, min = 10, message = "O cpf deve ter pelo menos 10 e no máximo 10 caracteres")
	@NotEmpty(message = "O rg é obrigatório")
	private String rg;
	
	@Column(name="formacao")
	@Size(max = 1000, min = 2, message = "A formação deve ter pelo menos 2 e no máximo 1000 caracteres")
	@NotEmpty(message = "A formação é obrigatória")
	private String formacao;
	
	@NotNull(message = "O usuário não pode estar vazio")
	@OneToOne
	private Usuario usuario;
	
	@Transient
	public boolean isNovo() {
		return getId() == null || getId() == 0;
	}
}
