package com.tcc.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.helpdesk.domain.Chamado;
import com.tcc.helpdesk.domain.enums.StatusChamado;
import com.tcc.helpdesk.domain.enums.TipoChamado;
import com.tcc.helpdesk.dto.ChamadoDTO;
import com.tcc.helpdesk.repositories.ChamadoRepository;
import com.tcc.helpdesk.services.exceptions.DataIntegrityException;
import com.tcc.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repo;
	
	public Chamado find(Integer id) {
		Optional<Chamado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Chamado.class.getName()));
	}
	
	@Transactional
	public Chamado insert(Chamado obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Chamado update(Chamado obj) {
		Chamado newObj = find(obj.getId());
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
	
	public List<Chamado> findAll(){
		return repo.findAll();
	}
	
	public Chamado fromDTO(ChamadoDTO objDto) {
		Chamado obj = find(objDto.getId());
		obj.setCliente(objDto.getCliente());
		obj.setTipo(TipoChamado.toEnum(objDto.getTipo()));
		obj.setStatus(StatusChamado.toEnum(objDto.getStatus()));
		obj.setUsuarioResponsavel(objDto.getUsuarioResponsavel());
		obj.setTitulo(objDto.getTitulo());
		obj.setDescricao(objDto.getDescricao());
		obj.setDataFinalizacao(objDto.getDataFinalizacao());
		return obj;
	}
	
	private void updateData(Chamado newObj, Chamado obj) {
		newObj.setCliente(obj.getCliente());
		newObj.setTipo(obj.getTipo());
		newObj.setStatus(obj.getStatus());
		newObj.setUsuarioResponsavel(obj.getUsuarioResponsavel());
		newObj.setTitulo(obj.getTitulo());
		newObj.setDescricao(obj.getDescricao());
		newObj.setDataFinalizacao(obj.getDataFinalizacao());
	}
}
