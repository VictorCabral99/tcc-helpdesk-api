package com.tcc.helpdesk.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tcc.helpdesk.domain.enums.StatusChamado;
import com.tcc.helpdesk.domain.enums.TipoChamado;

@Entity
public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	private Integer tipo;
	private Integer status;
	@ManyToOne
	@JoinColumn(name="id_create_usuario")
	private Usuario usuarioCriador;
	@ManyToOne
	@JoinColumn(name="id_usuario_responsavel")
	private Usuario usuarioResponsavel;
	private String titulo;
	private String descricao;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataCriacao;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFinalizacao;
	
	public Chamado() {
		
	}

	
	public Chamado(Integer id, Cliente cliente, Integer tipo, Integer status, Usuario usuarioCriador,
			Usuario usuarioResponsavel, String titulo, String descricao, Date dataCriacao, Date dataFinalizacao) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.tipo = tipo;
		this.status = status;
		this.usuarioCriador = usuarioCriador;
		this.usuarioResponsavel = usuarioResponsavel;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataFinalizacao = dataFinalizacao;
	
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

	public TipoChamado getTipo() {
		return TipoChamado.toEnum(tipo);
	}

	public void setTipo(TipoChamado tipo) {
		this.tipo = tipo.getCod();
	}
	
	public StatusChamado getStatus() {
		return StatusChamado.toEnum(status);
	}

	public void setStatus(StatusChamado status) {
		this.status = status.getCod();
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
		Chamado other = (Chamado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
