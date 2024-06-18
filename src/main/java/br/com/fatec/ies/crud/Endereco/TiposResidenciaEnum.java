package br.com.fatec.ies.crud.Endereco;

import java.util.ArrayList;

public enum TiposResidenciaEnum {
	APARTAMENTO("apartamento"),
	CASA("casa"),
	COMERCIO("comércio"),
	FLAT("flat"),
	KITNET("kitnet"),
	LOFT("loft"),
	OUTRO("outro");
	
	private String residencia;
	
	TiposResidenciaEnum(String residencia){
		this.residencia = residencia;
	}
	
	public String getResidencia(){
		return this.residencia;
	}
	
	public static TiposResidenciaEnum validarTipoResidencia(String factory_tipoResidencia) {
		for(TiposResidenciaEnum residencia : TiposResidenciaEnum.values()) {
			if(factory_tipoResidencia.toLowerCase() == residencia.getResidencia()) {
				return residencia;
			}
		}
		throw new RuntimeException("Tipo de Residencia invalida");
	}
	
	public static ArrayList<String> listarTiposResidencia(){
		ArrayList<String> itensTipoResidencia = new ArrayList<String>();
		for(TiposResidenciaEnum tipoResidencia : TiposResidenciaEnum.values()) {
			itensTipoResidencia.add(tipoResidencia.getResidencia());
		}
		return itensTipoResidencia;
	}
}
