package com.tcc.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.helpdesk.domain.Cliente;
import com.tcc.helpdesk.dto.ClienteDTO;
import com.tcc.helpdesk.repositories.ClienteRepository;
import com.tcc.helpdesk.services.exceptions.DataIntegrityException;
import com.tcc.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente findByDocument(String document) {
		Optional<Cliente> obj = repo.findByDocument(document);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Documento: " + document + ", Tipo: " + Cliente.class.getName()));
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
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
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		//StatusUsuario status = StatusUsuario.toEnum(objDto.getStatus());
		Cliente obj = find(objDto.getId());
		obj.setNome(objDto.getNome());
		obj.setSobrenome(objDto.getSobrenome());
		obj.setDocumento(objDto.getDocumento());
		obj.setSexo(objDto.getSexo());
		obj.setDataNascimento(objDto.getDataNascimento());
		obj.setCep(objDto.getCep());
		obj.setLogradouro(objDto.getLogradouro());
		obj.setNumero(objDto.getNumero());
		obj.setComplemento(objDto.getComplemento());
		obj.setBairro(objDto.getBairro());
		obj.setCidade(objDto.getCidade());
		obj.setEstado(objDto.getEstado());
		return obj;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setSobrenome(obj.getSobrenome());
		newObj.setDocumento(obj.getDocumento());
		newObj.setSexo(obj.getSexo());
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setCep(obj.getCep());
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNumero(obj.getNumero());
		newObj.setComplemento(obj.getComplemento());
		newObj.setBairro(obj.getBairro());
		newObj.setCidade(obj.getCidade());
		newObj.setEstado(obj.getEstado());
	}
}
