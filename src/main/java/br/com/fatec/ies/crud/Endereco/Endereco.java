package br.com.fatec.ies.crud.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Endereco {
	@NotNull(message = "Tipo de Logradouro é obrigatório")
	private TiposLogradouroEnum tipoLogradouro;
	
	@NotNull(message = "Tipo de Residencia é obrigatório")
	private TiposResidenciaEnum tipoResidencia;
	
	@NotBlank(message = "CEP é obrigatório")
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}", message = "CEP inválido")
	private String cep;
	
	@NotBlank(message = "Logradouro é obrigatório")
	private String logradouro;
	
	@NotBlank(message = "Numero é obrigatório")
	private String numero;
	
	private String complemento;
	
	@NotBlank(message = "Bairro é obrigatório")
	private String bairro;
	
	@NotBlank(message = "Cidade é obrigatório")
	private String cidade;
	
	@NotBlank(message = "Estado é obrigatório")
	private String estado;
	
	@NotBlank(message = "Pais é obrigatório")
	private String pais;
	
	
	public Endereco(TiposLogradouroEnum tipoLogradouro, TiposResidenciaEnum tipoResidencia, String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String pais) {
		setTipoLogradouro(tipoLogradouro);
		setTipoResidencia(tipoResidencia);
		setCep(cep);
		setLogradouro(logradouro);
		setNumero(numero);
		setComplemento(complemento);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setPais(pais);
	}

	public TiposLogradouroEnum getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TiposLogradouroEnum tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public TiposResidenciaEnum getTipoResidencia() {
		return tipoResidencia;
	}

	public void setTipoResidencia(TiposResidenciaEnum tipoResidencia) {
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
