package br.com.fatec.ies.crud.Cliente;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import br.com.fatec.ies.crud.Endereco.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class Cliente {
	@NotBlank(message="nome deve ser válido")
	private String nome;
	
	@NotNull(message = "Gênero é obrigatório")
	private GenerosEnum genero;
	
	@NotNull(message = "Data de nascimento é obrigatória")
	@Past (message = "Data inválida")
	private Date dataNascimento;
	
	@NotBlank(message = "CPF é obrigatório")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	@NotBlank(message = "Telefone é obrigatório")
	private String telefone;
	
	private ArrayList<Endereco> endereco;
	
	@NotBlank (message = "Email é obrigatório")
	@Email (message = "E-mail inválido")
	private String email;
	
	@NotBlank (message = "senha é obrigatória")
	private String senha;
	
	public Cliente(){};
	
	public Cliente(String nome, GenerosEnum genero, Date dataNascimento, String cpf, String telefone, String email, String senha){
		setNome(nome);
		setGenero(genero);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
		setSenha(senha);
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public GenerosEnum getGenero() {
		return genero;
	}


	public void setGenero(GenerosEnum genero) {
		this.genero = genero;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
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


	public ArrayList<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(ArrayList<Endereco> endereco) {
		this.endereco = endereco;
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
	
	@Override
	public String toString() {
		return (
				"Nome: " + getNome() + "/n" +
				"Genero: " + getGenero().getGenero() + "/n" +
				"Data de Nascimento: " + getDataNascimento() + "/n" +
				"CPF: " + getCpf() + "/n" +
				"Telefone: " + getTelefone() + "/n" +
				"Email: " + getEmail() + "/n" +
				"Senha: " + getSenha()
		);
	}
}
