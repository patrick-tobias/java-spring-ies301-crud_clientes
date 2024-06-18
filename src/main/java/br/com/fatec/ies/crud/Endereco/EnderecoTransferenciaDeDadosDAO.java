package br.com.fatec.ies.crud.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fatec.ies.crud.ConexaoBD.ConexaoBDFactory;

public class EnderecoTransferenciaDeDadosDAO extends ConexaoBDFactory {
	public void adicionarEndereco(int cli_id, EnderecoTransferenciaDeDados endereco) throws SQLException{
		Connection conexao = ConexaoBDFactory.recuperarConexao();
		
		String sql = "INSERT INTO enderecos (cli_id, end_id, end_tipo_residencia, end_tipo_logradouro, end_cep, end_logradouro, end_numero, end_bairro, end_cidade, end_estado, end_pais, end_observacao) "
				+	 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		ps.setInt(1, cli_id);
		ps.setInt(2, 0);
		ps.setString(3, endereco.getTipoResidencia());
		ps.setString(4, endereco.getTipoLogradouro());
		ps.setString(5, endereco.getCep());
		ps.setString(6, endereco.getLogradouro());
		ps.setString(7, endereco.getNumero());
		ps.setString(8, endereco.getBairro());
		ps.setString(9, endereco.getCidade());
		ps.setString(10, endereco.getEstado());
		ps.setString(11, endereco.getPais());
		ps.setString(12, endereco.getComplemento());
		
		
		ps.execute();
		
		ps.close();
		conexao.close();
	}
	
	public ArrayList<EnderecoTransferenciaDeDados> listarEnderecos(int cli_id) throws SQLException{
		ArrayList<EnderecoTransferenciaDeDados> enderecos = new ArrayList<EnderecoTransferenciaDeDados>();
		
		Connection conexao = ConexaoBDFactory.recuperarConexao();
		
		String sql = "SELECT end_id, end_tipo_residencia, end_tipo_logradouro, end_cep, end_logradouro, end_numero, end_bairro, end_cidade, end_estado, end_pais, end_observacao FROM enderecos WHERE enderecos.cli_id = ?;";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, cli_id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			String id = String.valueOf(rs.getInt(1));
			String tipoResidencia = rs.getString(2);
			String tipoLogradouro = rs.getString(3);
			String cep = rs.getString(4);
			String logradouro = rs.getString(5);
			String numero = rs.getString(6);
			String complemento = rs.getString(7);
			String bairro = rs.getString(8);
			String cidade = rs.getString(9);
			String estado = rs.getString(10);
			String pais = rs.getString(11);
			
			EnderecoTransferenciaDeDados endereco = new EnderecoTransferenciaDeDados(String.valueOf(cli_id), id, tipoResidencia, tipoLogradouro, cep, logradouro, numero, complemento, bairro, cidade, estado, pais);
			enderecos.add(endereco);
		}
		
		ps.close();
		rs.close();
		conexao.close();
		
		return enderecos;
	}

	public void removerEndereco(int end_id) throws SQLException{
		Connection conexao = ConexaoBDFactory.recuperarConexao();
		
		String sql = "DELETE FROM enderecos WHERE enderecos.end_id = ?;";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, end_id);
		
		ps.execute();
		
		ps.close();
		conexao.close();
	}
}
