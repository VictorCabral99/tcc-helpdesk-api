package com.tcc.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcc.helpdesk.domain.Chamado;
import com.tcc.helpdesk.domain.enums.StatusChamado;
import com.tcc.helpdesk.dto.ChamadoDTO;
import com.tcc.helpdesk.dto.ResponsavelChamadoDTO;
import com.tcc.helpdesk.dto.StatusChamadoDTO;
import com.tcc.helpdesk.services.ChamadoService;

@RestController
@RequestMapping(value="/chamados")
public class ChamadoResource {

	@Autowired
	private ChamadoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Chamado obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(value="/finalize/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> finalize(@PathVariable Integer id){
		Chamado obj = service.find(id);
		obj.setStatus(StatusChamado.SUCESS);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ChamadoDTO objDto) {
		Chamado obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ChamadoDTO objDto, @PathVariable Integer id){
		Chamado obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value="/status", method=RequestMethod.PUT)
	public ResponseEntity<Void> status(@Valid @RequestBody StatusChamadoDTO objDto){
		Chamado obj = service.fromDTO(objDto);
		obj.setId(objDto.getId());
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value="/responsavel", method=RequestMethod.PUT)
	public ResponseEntity<Void> status(@Valid @RequestBody ResponsavelChamadoDTO objDto){
		Chamado obj = service.fromDTO(objDto);
		obj.setId(objDto.getId());
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ChamadoDTO>> findAll (){
		List<Chamado> list = service.findAll();
		List<ChamadoDTO> listDto = list.stream().map(obj -> new ChamadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
