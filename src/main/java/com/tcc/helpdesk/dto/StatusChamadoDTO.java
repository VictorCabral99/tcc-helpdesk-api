package com.tcc.helpdesk.dto;

import com.tcc.helpdesk.domain.Chamado;

public class StatusChamadoDTO {

	private Integer id;
	private Integer status;
	
	public StatusChamadoDTO() {
		
	}
	
	public StatusChamadoDTO(Chamado obj) {
		super();
		this.id = obj.getId();
		this.status = obj.getStatus().getCod();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
