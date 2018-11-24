package com.tcc.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.helpdesk.domain.Chamado;
import com.tcc.helpdesk.services.ChamadoService;

@RestController
@RequestMapping(value="/chamados")
public class ChamadoResource {

	@Autowired
	private ChamadoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Chamado obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
