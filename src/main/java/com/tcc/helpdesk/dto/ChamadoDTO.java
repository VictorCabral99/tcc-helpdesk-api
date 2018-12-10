package com.tcc.helpdesk.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Null;

import com.tcc.helpdesk.domain.Chamado;
import com.tcc.helpdesk.domain.Cliente;
import com.tcc.helpdesk.domain.Usuario;

public class ChamadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Cliente cliente;
	private Integer tipo;
	private Integer status;
	private Usuario usuarioCriador;
	private Usuario usuarioResponsavel;
	private String titulo;
	private String descricao;
	private Date dataCriacao;
	private Date dataFinalizacao;
	
	public ChamadoDTO() {
		
	}
	
	public ChamadoDTO(Chamado obj) {
		super();
		this.id = obj.getId();
		this.cliente = obj.getCliente();
		this.tipo = obj.getTipo().getCod();
		this.status = obj.getStatus().getCod();
		this.usuarioCriador = obj.getUsuarioCriador();
		this.usuarioResponsavel = obj.getUsuarioResponsavel();
		this.titulo = obj.getTitulo();
		this.descricao = obj.getDescricao();
		this.dataCriacao = obj.getDataCriacao();
		this.dataFinalizacao = obj.getDataFinalizacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Usuario usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}

	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
}
