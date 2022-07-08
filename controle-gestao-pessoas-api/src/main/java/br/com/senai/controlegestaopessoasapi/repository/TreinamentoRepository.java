package br.com.senai.controlegestaopessoasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senai.controlegestaopessoasapi.entity.Treinamento;


@Repository
public interface TreinamentoRepository extends JpaRepository<Treinamento, Integer> {
	
	
	@Query(value = 
			"SELECT t "
			+ "FROM Treinamento t "
			+ "WHERE Upper(t.titulo) LIKE Upper(:titulo)")
	List<Treinamento> listarPor(@Param("titulo") String titulo);

}
