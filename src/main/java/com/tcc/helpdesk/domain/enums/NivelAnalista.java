package com.tcc.helpdesk.domain.enums;

public enum NivelAnalista {
	JUNIOR(1,"Júnior"),
	PLENO(2,"Pleno"),
	SENIOR(3,"Senior"),
	MASTER(4,"Master");
	
	private int cod;
	private String descricao;
	private NivelAnalista(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static NivelAnalista toEnum(Integer cod) 
	{
		if(cod ==null) 
		{
			return null;
		}
		for (NivelAnalista x : NivelAnalista.values()) 
		{
			if(cod.equals(x.getCod())) 
			{
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
