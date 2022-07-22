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

import br.com.senai.controlegestaopessoasview.dto.Facilitador;
import br.com.senai.controlegestaopessoasview.dto.Usuario;

@Component
public class FacilitadorClient {
	
	@Value("${endpoint}")
	private String urlEndpoint;
	
	@Autowired
	private ObjectMapper mapper;
	
	private final String resource = "/facilitadores";
	
	
	@Autowired
	private RestTemplateBuilder builder;
	
	public Facilitador inserir( Facilitador novoFacilitador) {
		
		RestTemplate httpClient = builder.build();
		
		URI uri = httpClient.postForLocation(
				urlEndpoint + resource, novoFacilitador);
		
		Facilitador facilitadorSalvo = httpClient
				.getForObject(urlEndpoint + uri.getPath(), 
						Facilitador.class);
		
		return facilitadorSalvo;
		
	}
	
	public void alterar(Facilitador facilitadorSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.put(urlEndpoint + resource, 
				facilitadorSalvo);
	}
	
	public void excluir(Facilitador facilitadorSalvo) {
		RestTemplate httpClient = builder.build();
		httpClient.delete(urlEndpoint + resource 
				+ "/id/" + facilitadorSalvo.getId());
	}
	
	
	public Facilitador buscarPeloId(Usuario usuario) {

		RestTemplate httpClient = builder.build();
		
	    Facilitador facilitadorLogado = httpClient.postForObject(
	    		urlEndpoint + resource, usuario, Facilitador.class);
	    
	    return facilitadorLogado;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Facilitador> listarPor(String nomeCompleto){
		
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource + "/listar/" + nomeCompleto, List.class);
		
		List<Facilitador> facilitadores = new ArrayList<Facilitador>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Facilitador facilitador = mapper.convertValue(item, Facilitador.class);
			facilitadores.add(facilitador);
		}
		
		return facilitadores;
	}

	@SuppressWarnings("unchecked")
	public List<Facilitador> buscarTodos(){
		
		RestTemplate httpClient = builder.build();
		
		List<LinkedHashMap<String, Object>> response = httpClient.getForObject(
				urlEndpoint + resource, List.class);
		
		List<Facilitador> facilitadores = new ArrayList<Facilitador>();
		
		for (LinkedHashMap<String, Object> item : response) {
			Facilitador facilitador = mapper.convertValue(item, Facilitador.class);
			facilitadores.add(facilitador);
		}
		
		return facilitadores;
	}
	
	

}
