package br.com.fatec.ies.crud.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fatec.ies.crud.ConexaoBD.ConexaoBDFactory;
import br.com.fatec.ies.crud.Endereco.EnderecoTransferenciaDeDados;
import br.com.fatec.ies.crud.Endereco.EnderecoTransferenciaDeDadosDAO;

public class ClienteTransferenciaDeDadosDAO extends ConexaoBDFactory{
	
	//revisar método para classe Cliente com validações
	public void cadastrarNovoCliente(ClienteTransferenciaDeDados cliente) throws SQLException{
		Connection conexao = ConexaoBDFactory.recuperarConexao();
		
		String sql = "INSERT INTO clientes (cli_id, cli_nome, cli_genero, cli_data_nascimento, cli_cpf, cli_telefone, cli_email, cli_senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, 0);
		ps.setString(2, cliente.getNome());
		ps.setString(3, cliente.getGenero());
		ps.setString(4, cliente.getDataNascimento());
		ps.setString(5, cliente.getCpf());
		ps.setString(6, cliente.getTelefone());
		ps.setString(7, cliente.getEmail());
		ps.setString(8, cliente.getSenha());
		
		ps.execute();
		ps.close();
		
		sql = "SELECT LAST_INSERT_ID();";
		PreparedStatement ps2 = conexao.prepareStatement(sql);
		
		ResultSet rs = ps2.executeQuery();

		Integer last_cli_id = null;
		while(rs.next()){
			last_cli_id = rs.getInt(1);
		}
		
		EnderecoTransferenciaDeDadosDAO enderecoTransferenciaDeDadosDAO = new EnderecoTransferenciaDeDadosDAO();
		for(EnderecoTransferenciaDeDados endereco : cliente.getEndereco()){
			enderecoTransferenciaDeDadosDAO.adicionarEndereco(last_cli_id, endereco);
		}
		
		ps2.close();
		rs.close();
		
		conexao.close();
		
	}
	
	public ArrayList<ClienteTransferenciaDeDados> listarClientes() throws SQLException{
		ArrayList<ClienteTransferenciaDeDados> clientes = new ArrayList<ClienteTransferenciaDeDados>();
			
		Connection conexao = ConexaoBDFactory.recuperarConexao();
		
		String sql = "SELECT cli_id, cli_nome, cli_genero, cli_data_nascimento, cli_cpf, cli_telefone, cli_email, cli_senha FROM clientes";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			String id = String.valueOf(rs.getInt(1));
			String nome = rs.getString(2);
			String genero = rs.getString(3);
			String dataNascimento = rs.getString(4);
			String cpf = rs.getString(5);
			String telefone = rs.getString(6);
			String email = rs.getString(7);
			String senha = rs.getString(8);
			
			ClienteTransferenciaDeDados cliente = new ClienteTransferenciaDeDados(id, nome, genero, dataNascimento, cpf, telefone, email, senha);
			clientes.add(cliente);
		}
		
		ps.close();
		rs.close();
		conexao.close();
		
		return clientes;
	}
	
	public void removerCliente(int cli_id) throws SQLException{
		Connection conexao = ConexaoBDFactory.recuperarConexao();
		
		String sql = "DELETE FROM clientes WHERE clientes.cli_id = ?;";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, cli_id);
		
		ps.execute();
		
		ps.close();
		conexao.close();
	}
}
