package br.com.fatec.ies.crud.ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBDFactory {
	private static final String url = "jdbc:mysql://localhost:3306/ies_crud_clientes";
	private static final String usuario = "root";
	private static final String senha = "root1234";

	public static Connection recuperarConexao(){	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			return conexao;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
