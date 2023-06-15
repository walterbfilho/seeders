package geral.entidade;

import java.io.Serializable;

public class Endereco implements Serializable {
	private String rua;
	private String cidade;
	private String estado;
	private String cep;
	private Integer numero;
	private String pais;
	private String geolocalizacao;
	private double latitude;
	private double longitude;
	
	public Endereco(String rua, String cidade, String estado, String cep, Integer numero, String pais) {
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.numero = numero;
		this.pais = pais;
		
		Geolocalizacao calculator = new Geolocalizacao();
		
		calculator.LatitudeLongitudeCalculator(this);
		
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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "" + rua + ", " + cidade
				+ ", " + estado + ", " + pais;
	}
	
	

}