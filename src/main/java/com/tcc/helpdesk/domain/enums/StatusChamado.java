package com.tcc.helpdesk.domain.enums;

public enum StatusChamado {
	SUCESS(1,"Sucesso"),
	INREVIEW(2,"Em Análise"),
	WAITINGDATA(3,"Aguardando Retorno"),
	PENDING(4,"Pendente");
	
	private int cod;
	private String descricao;
	
	private StatusChamado(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() 
	{
		return cod;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
	
	public static StatusChamado toEnum(Integer cod) 
	{
		if(cod ==null) 
		{
			return null;
		}
		for (StatusChamado x : StatusChamado.values()) 
		{
			if(cod.equals(x.getCod())) 
			{
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
