package br.com.fatec.ies.crud.Cliente;

import java.util.List;

import br.com.fatec.ies.crud.Endereco.EnderecoTransferenciaDeDados;

public class ClienteTransferenciaDeDados {
	private String id;
	private String nome;
	private String genero;
	private String dataNascimento;
	private String cpf;
	private String telefone;
	private String email;
	private String senha;
	
	private List<EnderecoTransferenciaDeDados> endereco;
	
	public ClienteTransferenciaDeDados(String id, String nome, String genero, String dataNascimento, String cpf, String telefone, String email, String senha) {
		setId(id);
		setNome(nome);
		setGenero(genero);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
		setSenha(senha);
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<EnderecoTransferenciaDeDados> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoTransferenciaDeDados> endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return (
				"Nome: " + getNome() + "\n" +
				"Genero: " + getGenero() + "\n" +
				"Data de Nascimento: " + getDataNascimento() + "\n" +
				"CPF: " + getCpf() + "\n" +
				"Telefone: " + getTelefone() + "\n" +
				"Email: " + getEmail() + "\n" +
				"Senha: " + getSenha() + "\n" +
				"Endereços: " + getEndereco().toString()
		);
	}
}

