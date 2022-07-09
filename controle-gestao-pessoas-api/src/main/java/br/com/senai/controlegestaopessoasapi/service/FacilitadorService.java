package br.com.senai.controlegestaopessoasapi.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;

import br.com.senai.controlegestaopessoasapi.entity.Facilitador;
import br.com.senai.controlegestaopessoasapi.repository.FacilitadorRepository;


@Service
@Valid
public class FacilitadorService {
	
	@Autowired
	private FacilitadorRepository repository;
	
	public Facilitador inserir(
			@Valid
			@NotNull(message = "O facilitador não pode ser nulo")
			Facilitador novoFacilitador) {
		Preconditions.checkArgument(novoFacilitador.isNovo(),
				"O facilitador já foi salvo");
		Facilitador facilitadorSalvo = repository.save(novoFacilitador);
		return facilitadorSalvo;
	}
	
	public Facilitador alterar(
			@Valid 
			@NotNull(message = "O facilitador não pode ser nulo")
			Facilitador facilitadorSalvo) {
		Preconditions.checkArgument(!facilitadorSalvo.isNovo(), 
				"O facilitador ainda não foi inserido");
		Facilitador facilitadorAtualizado = repository.save(facilitadorSalvo);
		return facilitadorAtualizado;
	}
	
	public void removerPor(
			@NotNull(message = "O id do facilitador para remoção não pode ser nulo")
			@Min(value = 1, message = "O id do facilitador deve ser maior que zero")
			Integer id) {
		this.repository.deleteById(id);
	}
	
	public List<Facilitador> listarPor(
			@NotEmpty(message = "A descrição da busca é obrigatória")
			@NotBlank(message = "A descrição não pode conter espaço em branco")
			String descricao){
		return repository.listarPor("%" + descricao + "%"); //conferir se é por descricao
	}
	
	
	

}
