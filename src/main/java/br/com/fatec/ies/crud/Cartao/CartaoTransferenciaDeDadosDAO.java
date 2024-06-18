package br.com.fatec.ies.crud.Cartao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fatec.ies.crud.ConexaoBD.ConexaoBDFactory;

public class CartaoTransferenciaDeDadosDAO extends ConexaoBDFactory{
	
	public void adicionarCartao(CartaoTransferenciaDeDados cartao) throws SQLException{
		Connection conexao = ConexaoBDFactory.recuperarConexao();
		
		String sql = "INSERT INTO cartoes (cli_id, car_id, car_numero, car_nome, car_validade, car_cvc) VALUES (?, ?, ?, ?, ?, ?);";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, Integer.valueOf(cartao.getCli_id()));
		ps.setInt(2, 0);
		ps.setNString(3, cartao.getNumero());
		ps.setNString(4, cartao.getNome());
		ps.setNString(5, cartao.getValidade());
		ps.setNString(6, cartao.getCvc());
		
		ps.execute();
		ps.close();
		conexao.close();
	}
	
	public ArrayList<CartaoTransferenciaDeDados> listarCartoes(int cli_id) throws SQLException {
		ArrayList<CartaoTransferenciaDeDados> cartoes = new ArrayList<CartaoTransferenciaDeDados>();
		
		Connection conexao = ConexaoBDFactory.recuperarConexao();
		
		String sql = "SELECT car_id, car_numero, car_nome, car_validade, car_cvc FROM cartoes WHERE cartoes.cli_id = ?;";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, cli_id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			String id = String.valueOf(rs.getInt(1));
			String numero = rs.getString(2);
			String nome = rs.getString(3);
			String validade = rs.getString(4);
			String cvc = rs.getString(5);
			
			CartaoTransferenciaDeDados cartao = new CartaoTransferenciaDeDados(String.valueOf(cli_id), id, numero, nome, validade, cvc);
			cartoes.add(cartao);
		}
		ps.close();
		rs.close();
		conexao.close();
		
		return cartoes;
	}
	
	public void removerCartao(int id) throws SQLException {
		Connection conexao = ConexaoBDFactory.recuperarConexao();
		
		String sql = "DELETE FROM cartoes WHERE car_id = ?;";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, Integer.valueOf(id));
		
		ps.execute();
		
		ps.close();
		conexao.close();
	}
	
	public ArrayList<CartaoTransferenciaDeDados> buscarCartao(int id) throws SQLException {
		ArrayList<CartaoTransferenciaDeDados> cartoes = new ArrayList<CartaoTransferenciaDeDados>();
		Connection conexao = ConexaoBDFactory.recuperarConexao();
		
		String sql = "SELECT cli_id, car_id, car_numero, car_nome, car_validade, car_cvc FROM cartoes WHERE cartoes.car_id = ?;";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			String cli_id = String.valueOf(rs.getInt(1));
			String car_id = String.valueOf(rs.getInt(2));
			String numero = rs.getString(3);
			String nome = rs.getString(4);
			String validade = rs.getString(5);
			String cvc = rs.getString(6);
			
			CartaoTransferenciaDeDados cartao = new CartaoTransferenciaDeDados(String.valueOf(cli_id), car_id, numero, nome, validade, cvc);
			cartoes.add(cartao);
		}
		ps.close();
		rs.close();
		conexao.close();
		
		return cartoes;
	}
}
