package com.tcc.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.helpdesk.domain.Usuario;
import com.tcc.helpdesk.dto.AutenticarDTO;
import com.tcc.helpdesk.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResouce {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/email/{email}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@RequestParam(value="value") String email){
		Usuario obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/autenticar", method=RequestMethod.POST)
	public ResponseEntity<String> autenticar(@RequestBody AutenticarDTO autenticar){
		Usuario obj = service.findByEmail(autenticar.getEmail());
		if(obj.getSenha().equals(autenticar.getSenha())){
			return ResponseEntity.accepted().body("Autenticado," + autenticar.getEmail() + "," + autenticar.getSenha() + ","+obj.getPerfil());
		}else {
			return ResponseEntity.badRequest().body("Login inválido");
		}
	}
}
