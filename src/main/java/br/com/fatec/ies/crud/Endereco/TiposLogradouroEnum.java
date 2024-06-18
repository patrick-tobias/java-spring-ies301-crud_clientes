package br.com.fatec.ies.crud.Endereco;

import java.util.ArrayList;

public enum TiposLogradouroEnum {
	ALAMEDA("alameda"),
	AVENIDA("avenida"),
	ESTRADA("estrada"),
	LADEIRA("ladeira"),
	PRACA("praça"),
	RUA("rua"),
	TRAVESSA("travessa"),
	VIELA("viela"),
	OUTRO("outro");
	
	private final String logradouro;
	
	TiposLogradouroEnum(String logradouro){
		this.logradouro = logradouro;
	}
	
	public String getLogradouro() {
		return this.logradouro;
	}
	
	public static TiposLogradouroEnum validarTipoLogradouro(String factory_tipoLogradouro) {
		for(TiposLogradouroEnum logradouro : TiposLogradouroEnum.values()) {
			if(factory_tipoLogradouro.toLowerCase() == logradouro.getLogradouro()) {
				return logradouro;
			}
		}
		throw new RuntimeException("Tipo de Logradouro invalido");
	}
	
	public static ArrayList<String> listarTiposLogradouro(){
		ArrayList<String> itensTipoLogradouro = new ArrayList<String>();
		for(TiposLogradouroEnum tipoLogradouro : TiposLogradouroEnum.values()) {
			itensTipoLogradouro.add(tipoLogradouro.getLogradouro());
		}
		return itensTipoLogradouro;
	}
}
