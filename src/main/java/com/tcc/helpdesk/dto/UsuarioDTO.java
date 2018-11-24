package com.tcc.helpdesk.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.tcc.helpdesk.domain.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	private Date dataCriacao;
	private Integer status;
	private Integer perfil;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		email = obj.getEmail();
		dataCriacao = obj.getDataCriacao();
		status = obj.getStatus().getCod();
		perfil = obj.getPerfil().getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}
}
