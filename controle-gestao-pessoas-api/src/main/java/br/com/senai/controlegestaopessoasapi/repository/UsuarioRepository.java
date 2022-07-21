package br.com.senai.controlegestaopessoasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senai.controlegestaopessoasapi.entity.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value = 
			"SELECT u "
			+ "FROM Usuario u "
			+ "WHERE Upper(u.nomeCompleto) LIKE Upper(:nome)")
	List<Usuario> listarPor(@Param("nome") String nome);
	
	
	@Query(value = "SELECT u "
					+ "FROM Usuario u "
					+ "WHERE u.login = :login "
					+ "AND u.senha = :senha")
	Usuario buscarPor(@Param("login") String login, @Param("senha") String senha);
}