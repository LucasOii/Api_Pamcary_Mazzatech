package br.com.pamcary.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pamcary.avaliacao.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findByNomeContainingIgnoreCase(String nome);
	/* select * from tb_usuario where usuario like "%usuario"; */
}
