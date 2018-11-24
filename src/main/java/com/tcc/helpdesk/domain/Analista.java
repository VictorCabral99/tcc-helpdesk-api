package com.tcc.helpdesk.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.tcc.helpdesk.domain.enums.NivelAnalista;

@Entity
public class Analista implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Usuario usuario;

	private Integer nivel;
	private String nome;
	private String sobrenome;
	
	public Analista() {
		//Construtor Sem Parâmetros
	}
	
	public Analista(Integer id, Usuario usuario, NivelAnalista nivel, String nome, String sobrenome) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nivel = nivel.getCod();
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public NivelAnalista getNivel() {
		return NivelAnalista.toEnum(nivel);
	}

	public void setPerfil(NivelAnalista nivel) {
		this.nivel = nivel.getCod();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
