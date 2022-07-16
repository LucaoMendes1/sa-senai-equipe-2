package br.com.senai.controlegestaopessoasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senai.controlegestaopessoasapi.entity.Facilitador;

@Repository
public interface FacilitadorRepository extends JpaRepository<Facilitador, Integer> {

	@Query(value = 
			"SELECT f " 
					+ "FROM Facilitador f " 
					+ "WHERE Upper(f.nomeCompleto) LIKE Upper(:nome)")
	List<Facilitador> listarPor(@Param("nome") String nome);

	@Query(value = 
			"SELECT f "
			+ "FROM Facilitador f "
			+ "WHERE f.id = :id")
	Facilitador buscarPor(@Param("id") Integer id);

	

}
