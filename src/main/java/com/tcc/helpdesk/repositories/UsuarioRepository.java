package com.tcc.helpdesk.repositories;

import org.springframework.stereotype.Repository;

import com.tcc.helpdesk.domain.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "SELECT * " +
            "FROM tb_user " +
            "WHERE ds_email = :mail AND ds_password=:pass  ", nativeQuery = true)
	Optional<Usuario> autenticarUsuario(@Param("mail") String email,@Param("pass") String senha);
	
	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
}
