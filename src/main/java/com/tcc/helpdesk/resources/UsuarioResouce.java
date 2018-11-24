package com.tcc.helpdesk.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.helpdesk.domain.Usuario;
import com.tcc.helpdesk.dto.AutenticarDTO;
import com.tcc.helpdesk.dto.UsuarioDTO;
import com.tcc.helpdesk.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResouce {
	
	@Autowired
	private UsuarioService service;
	
	@CrossOrigin
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(value="/email/{email}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@RequestParam(value="value") String email){
		Usuario obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(value="/autenticar", method=RequestMethod.POST)
	public ResponseEntity<String> autenticar(@RequestBody AutenticarDTO autenticar){
		Usuario obj = service.findByEmail(autenticar.getEmail());
		if(obj.getSenha().equals(autenticar.getSenha())){
			return ResponseEntity.accepted().body("Autenticado," + autenticar.getEmail() + "," + autenticar.getSenha() + ","+obj.getPerfil());
		}else {
			return ResponseEntity.badRequest().body("Login inválido");
		}
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll (){
		List<Usuario> list = service.findAll();
		List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
