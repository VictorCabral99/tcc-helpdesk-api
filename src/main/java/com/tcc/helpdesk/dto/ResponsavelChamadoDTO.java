package com.tcc.helpdesk.dto;

import com.tcc.helpdesk.domain.Chamado;
import com.tcc.helpdesk.domain.Usuario;

public class ResponsavelChamadoDTO {

	private Integer id;
	private Usuario usuarioResponsavel;
	
	public ResponsavelChamadoDTO() {
		
	}
	
	public ResponsavelChamadoDTO(Chamado obj) {
		super();
		this.id = obj.getId();
		this.usuarioResponsavel = obj.getUsuarioResponsavel();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}

	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}
}
