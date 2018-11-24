package com.tcc.helpdesk.domain.enums;

public enum TipoChamado {
	DUVIDA(1,"Dúvida"),
	MELHORIA(2,"Melhoria"),
	PROBLEMA(3,"Problema");
	
	private int cod;
	private String descricao;
	private TipoChamado(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoChamado toEnum(Integer cod) 
	{
		if(cod ==null) 
		{
			return null;
		}
		for (TipoChamado x : TipoChamado.values()) 
		{
			if(cod.equals(x.getCod())) 
			{
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
