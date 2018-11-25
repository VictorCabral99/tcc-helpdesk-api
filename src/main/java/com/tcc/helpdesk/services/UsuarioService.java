package com.tcc.helpdesk.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.helpdesk.domain.Usuario;
import com.tcc.helpdesk.domain.enums.PerfilUsuario;
import com.tcc.helpdesk.domain.enums.StatusUsuario;
import com.tcc.helpdesk.dto.NewUsuarioDTO;
import com.tcc.helpdesk.dto.UsuarioDTO;
import com.tcc.helpdesk.repositories.UsuarioRepository;
import com.tcc.helpdesk.services.exceptions.DataIntegrityException;
import com.tcc.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repo;
		
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	public Usuario findByEmail(String email) {
		Usuario obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado!E-mail: " + email + ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}
	
	public Usuario fromDTO(NewUsuarioDTO objDto) {
		StatusUsuario status = StatusUsuario.toEnum(objDto.getStatus());
		PerfilUsuario perfil = PerfilUsuario.toEnum(objDto.getPerfil());
		return new Usuario(objDto.getId(),objDto.getEmail(),objDto.getSenha(),new Date(),status,perfil);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		StatusUsuario status = StatusUsuario.toEnum(objDto.getStatus());
		PerfilUsuario perfil = PerfilUsuario.toEnum(objDto.getPerfil());
		Usuario obj = find(objDto.getId());
		obj.setEmail(objDto.getEmail());
		obj.setPerfil(perfil);
		obj.setStatus(status);
		return obj;
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setPerfil(obj.getPerfil());
		newObj.setStatus(obj.getStatus());
	}
	
}
