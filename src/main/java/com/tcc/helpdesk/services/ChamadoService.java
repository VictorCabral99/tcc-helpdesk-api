package com.tcc.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.helpdesk.domain.Chamado;
import com.tcc.helpdesk.repositories.ChamadoRepository;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repo;
	
	public Chamado buscar(Integer id) {
		
		Optional<Chamado> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
