package com.tcc.helpdesk.domain.enums;

public enum PerfilUsuario {
	ADMIN(1,"Administrador"),
	GERENTE(2,"Gerente"),
	ANALIST1(3,"Analista1"),
	ANALIST2(4,"Analista2");
	
	private int cod;
	private String descricao;
	private PerfilUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static PerfilUsuario toEnum(Integer cod) 
	{
		if(cod ==null) 
		{
			return null;
		}
		for (PerfilUsuario x : PerfilUsuario.values()) 
		{
			if(cod.equals(x.getCod())) 
			{
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
