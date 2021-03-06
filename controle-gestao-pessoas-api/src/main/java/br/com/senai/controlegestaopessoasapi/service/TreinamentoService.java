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
import br.com.senai.controlegestaopessoasapi.entity.Treinamento;
import br.com.senai.controlegestaopessoasapi.repository.TreinamentoRepository;



@Service
@Valid
public class TreinamentoService {
	
	
	@Autowired
	private TreinamentoRepository repository;
	
	
	public Treinamento inserir(
			@Valid
			@NotNull(message = "O treinamento não pode ser nulo")
			Treinamento novoTreinamento) {
		Preconditions.checkArgument(novoTreinamento.isNovo(),
				"O treinamento já foi salvo");
		
		Treinamento treinamentoSalvo = repository.save(novoTreinamento);
		return treinamentoSalvo;
	}
	
	public Treinamento alterar(
			@Valid 
			@NotNull(message = "O treinamento não pode ser nulo")
			Treinamento treinamentoSalvo) {
		Preconditions.checkArgument(!treinamentoSalvo.isNovo(), 
				"O treinamento ainda não foi inserido");
		Treinamento treinamentoAtualizado = repository.save(treinamentoSalvo);
		return treinamentoAtualizado;
	}
	
	public Treinamento buscarPor(
			@NotNull(message = "O id para busca não pode ser nulo")
			Integer id) {
		Treinamento TreinamentoEncontrado = repository.buscarPor(id);
		if (TreinamentoEncontrado == null) {
			throw new RegistroNaoEncontradoException(
				"O treinamento não foi encontrado");
		}
		return TreinamentoEncontrado;
	}
	
	
	public void removerPor(
			@NotNull(message = "O id do treinamento para remoção não pode ser nulo")
			@Min(value = 1, message = "O id do treinamento deve ser maior que zero")
			Integer id) {
		this.repository.deleteById(id);
	}
	
	public List<Treinamento> listarPor(
			@NotEmpty(message = "O título da busca é obrigatória")
			@NotBlank(message = "O título não pode conter espaço em branco")
			String titulo){
		return repository.listarPor("%" + titulo + "%"); 
	}

	
	
}
	
	
	

