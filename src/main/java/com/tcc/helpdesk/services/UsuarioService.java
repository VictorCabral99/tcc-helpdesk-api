package com.tcc.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.helpdesk.domain.Usuario;
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
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
	}
	
}
