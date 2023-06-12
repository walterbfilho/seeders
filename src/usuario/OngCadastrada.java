package usuario;

import java.io.Serializable;

public class OngCadastrada implements Serializable {
	private String nome;
	private String[] tags;
	private String descricao;
	private String pix;
	private InfoContato infoContato;
	private Endereco endereco;
	
	public OngCadastrada(String nome, String[] tags, String descricao, String pix, InfoContato infoContato,
			Endereco endereco) {
		this.nome = nome;
		this.tags = tags;
		this.descricao = descricao;
		this.pix = pix;
		this.infoContato = infoContato;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPix() {
		return pix;
	}
	public void setPix(String pix) {
		this.pix = pix;
	}
	public InfoContato getInfoContato() {
		return infoContato;
	}
	public void setInfoContato(InfoContato infoContato) {
		this.infoContato = infoContato;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
