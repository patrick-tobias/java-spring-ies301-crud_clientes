package br.com.fatec.ies.crud.Cliente;

import java.util.ArrayList;

public enum GenerosEnum {
	MASCULINO("masculino"),
	FEMININO("feminino"),
	OUTRO("outro"),
	PREFIRO_NAO_RESPONDER("prefiro não responder");
	
	private final String genero;
	
	GenerosEnum(String genero){
		this.genero = genero;
	}
	
	public String getGenero(){
		return this.genero;
	}
	
	public static GenerosEnum validarGenero(String factory_genero) throws Exception {
		for(GenerosEnum genero : GenerosEnum.values()) {
			if(factory_genero.equalsIgnoreCase(genero.genero)) {
				return genero;
			}
		}
		throw new RuntimeException("Genero invalido");
	}
	
	public static ArrayList<String> listarGeneros(){
		ArrayList<String> itensGenero = new ArrayList<String>();
		for(GenerosEnum genero : GenerosEnum.values()) {
			itensGenero.add(genero.getGenero());
		}
		return itensGenero;
	}
	
}
