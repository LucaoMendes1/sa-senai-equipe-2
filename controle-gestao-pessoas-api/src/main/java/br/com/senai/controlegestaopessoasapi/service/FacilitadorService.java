package br.com.senai.controlegestaopessoasapi.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.controlegestaopessoasapi.controller.RegistroNaoEncontradoException;
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
	
	public Facilitador buscarPor(
			@NotNull(message = "O id para busca não pode ser nulo")
			Integer id) {
		Facilitador facilitadorEncontrado = repository.buscarPor(id);
		if (facilitadorEncontrado == null) {
			throw new RegistroNaoEncontradoException(
				"Não foi encontrado o facilitador");
		}
		return facilitadorEncontrado;
	}
	
	public List<Facilitador> listarPor(
			@NotEmpty(message = "O nome da busca é obrigatória")
			@NotBlank(message = "O nome não pode conter espaço em branco")
			String nome){
		return repository.listarPor("%" + nome + "%"); 
	}
	
	public Facilitador listar(
			@NotEmpty(message = "O nome da busca é obrigatório")
			@NotBlank(message = "O nome não pode conter espaço em branco")
			String login) 
	{
		return repository.buscarPor(login);
		
	}



	
	
	

}
