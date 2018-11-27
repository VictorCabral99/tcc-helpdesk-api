package com.tcc.helpdesk.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tcc.helpdesk.domain.enums.PerfilUsuario;
import com.tcc.helpdesk.domain.enums.StatusUsuario;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String senha;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataCriacao;
	private Integer status;
	private Integer perfil;
	
	public Usuario() {
		//Construtor sem parâmetros
	}
	
	public Usuario(Integer id, String email, String senha, Date dataCriacao, StatusUsuario status, PerfilUsuario perfil) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.dataCriacao = dataCriacao;
		this.status = status.getCod();
		this.perfil = perfil.getCod();
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public StatusUsuario getStatus() {
		return StatusUsuario.toEnum(status);
	}

	public void setStatus(StatusUsuario status) {
		this.status = status.getCod();
	}

	public PerfilUsuario getPerfil() {
		return PerfilUsuario.toEnum(perfil);
	}

	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil.getCod();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
