package com.tcc.helpdesk.domain.enums;

public enum StatusUsuario {
	ACTIVE(1,"Ativo"),
	BLOCKED(2,"Bloqueado"),
	CANCELED(3,"Cancelado");
	
	private int cod;
	private String descricao;
	private StatusUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static StatusUsuario toEnum(Integer cod) 
	{
		if(cod ==null) 
		{
			return null;
		}
		for (StatusUsuario x : StatusUsuario.values()) 
		{
			if(cod.equals(x.getCod())) 
			{
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
