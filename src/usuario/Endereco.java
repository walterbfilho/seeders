package usuario;

import java.io.Serializable;

public class Endereco implements Serializable {
	private String rua;
	private String cidade;
	private String estado;
	private String cep;
	private Integer numero;
	private String pais;
	private String geolocalizacao;
	
	public Endereco(String rua, String cidade, String estado, String cep, Integer numero, String pais,
			String geolocalizacao) {
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.numero = numero;
		this.pais = pais;
		this.geolocalizacao = geolocalizacao;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
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
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getGeolocalizacao() {
		return geolocalizacao;
	}
	public void setGeolocalizacao(String geolocalizacao) {
		this.geolocalizacao = geolocalizacao;
	}

}
