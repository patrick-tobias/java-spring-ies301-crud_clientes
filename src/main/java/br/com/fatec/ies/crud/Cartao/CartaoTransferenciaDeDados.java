package br.com.fatec.ies.crud.Cartao;

public class CartaoTransferenciaDeDados {
	private String cli_id;
	
	private String id;
	private String nome;
	private String numero;
	private String validade;
	private String cvc;
	
	public CartaoTransferenciaDeDados(String cli_id, String id, String numero, String nome, String validade, String cvc) {
		setCli_id(cli_id);
		setId(id);
		setNumero(numero);
		setNome(nome);
		setValidade(validade);
		setCvc(cvc);
	}
	
	
	public String getCli_id() {
		return cli_id;
	}

	public void setCli_id(String cli_id) {
		this.cli_id = cli_id;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	
	public String toString(){
		return(
				"Id do Cliente: " + getCli_id() + "\n" +
				"Id: " + getId() + "\n" +
				"Nome: " + getNome() + "\n" +
				"Numero: " + getNumero() + "\n" +
				"Validade: " + getValidade() + "\n" +
				"CVC: " + getCvc()
		);
	}
}
