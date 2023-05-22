package usuario;

public class OngCadastrada {
	private String nome;
	private String[] tags;
	private String descricao;
	private String pix;
	private InfoContato infoContato;
	private EnderecoOng enderecoOng;
	
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
	public EnderecoOng getEnderecoOng() {
		return enderecoOng;
	}
	public void setEnderecoOng(EnderecoOng enderecoOng) {
		this.enderecoOng = enderecoOng;
	}
	

}
