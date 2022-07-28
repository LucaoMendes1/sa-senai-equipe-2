package br.com.senai.controlegestaopessoasview.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.senai.controlegestaopessoasview.dto.Treinamento;

@Component
public class TreinamentoClient {
	
	@Value("${endpoint}")
	private String urlEndpoint;
	
	@Autowired
	private ObjectMapper mapper;
	
	private final String resource = "/treinamentos";
	
	@Autowired
	private RestTemplateBuilder builder;
	
	public Treinamento inserir(
			Treinamento novoTreinamento) {
		RestTemplate httpClient = builder.build();
		
		URI uri = httpClient.postForLocation(
				urlEndpoint + resource, novoTreinamento);
		
		Treinamento treinamentoSalvo = httpClient
				.getForObject(urlEndpoint + uri.getPath(), 
						Treinamento.class);
		
		return treinamentoSalvo;
		
	}
	
	public void alterar(Treinamento treinamentoSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.put(urlEndpoint + resource, 
				treinamentoSalvo);
	}
	
	public void excluir(Treinamento treinamentoSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.delete(urlEndpoint + resource 
				+ "/id/" + treinamentoSalvo.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Treinamento> listarPor(String descricaoLonga){
		
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource + "/descricao/" + descricaoLonga, List.class);
		
		List<Treinamento> treinamentos = new ArrayList<Treinamento>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Treinamento treinamento = mapper.convertValue(item, Treinamento.class);
			treinamentos.add(treinamento);
		}
		
		return treinamentos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Treinamento> buscarTodos(){
		
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource, List.class);
		
		List<Treinamento> treinamentos = new ArrayList<Treinamento>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Treinamento treinamento = mapper.convertValue(item, Treinamento.class);
			treinamentos.add(treinamento);
		}
		
		return treinamentos;
	}
}
