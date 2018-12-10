package com.tcc.helpdesk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcc.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query(value = "SELECT * " +
            "FROM CLIENTE " +
            "WHERE DOCUMENTO = :document", nativeQuery = true)
	Optional<Cliente> findByDocument(@Param("document") String document);
}
