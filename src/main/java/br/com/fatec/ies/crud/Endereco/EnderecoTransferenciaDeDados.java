package br.com.fatec.ies.crud.Endereco;

public class EnderecoTransferenciaDeDados {
	private String cli_id;
	
	private String id;
	private String tipoResidencia;
	private String tipoLogradouro;
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	
	private String complemento;
	
	public EnderecoTransferenciaDeDados(String cli_id, String id, String tipoResidencia, String tipoLogradouro, String cep, String logradouro, String numero, String bairro, String cidade, String estado, String pais, String complemento) {
		setCli_id(cli_id);
		
		setId(id);
		setTipoResidencia(tipoResidencia);
		setTipoLogradouro(tipoLogradouro);
		setCep(cep);
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setPais(pais);

		setComplemento(complemento);
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

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}


	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}


	public String getTipoResidencia() {
		return tipoResidencia;
	}


	public void setTipoResidencia(String tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return (
				"Cli ID: " + getCli_id() +  "\n" +
				"ID: " + getId() + "\n" +
				"Tipo de Residencia: " + getTipoResidencia() + "\n" +
				"Tipo de Logradouro: " + getTipoLogradouro() + "\n" +
				"CEP: " + getCep() + "\n" +
				"Logradouro: " + getLogradouro() + "\n" +
				"Número: " + getNumero() + "\n" +
				"Complemento: " + getComplemento() + "\n" +
				"Bairro: " + getBairro() + "\n" +
				"Cidade: " + getCidade() + "\n" +
				"Estado: " + getEstado() + "\n" +
				"País: " + getPais()
				);
	}
	
}
