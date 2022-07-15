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
import javax.validation.constraints.Size;

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
<<<<<<< HEAD
=======
	@Size(max = 20, min = 2, message = "O login deve ter pelo menos 2 e no máximo 20 caracteres")
>>>>>>> 7bfdb64b8c592db6968965134e73237911193dab
	@NotEmpty(message = "O login é obrigatório")
	private  String login;
	
	@Column(name="nome_completo")
<<<<<<< HEAD
=======
	@Size(max = 50, min = 2, message = "O nome completo deve ter pelo menos 2 e no máximo 50 caracteres")
>>>>>>> 7bfdb64b8c592db6968965134e73237911193dab
	@NotEmpty(message = "O nome completo é obrigatório")
	private String nomeCompleto;
	
	@Column(name="senha")
<<<<<<< HEAD
=======
	@Size(max = 10, min = 2, message = "O login deve ter pelo menos 2 e no máximo 10 caracteres")
>>>>>>> 7bfdb64b8c592db6968965134e73237911193dab
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
