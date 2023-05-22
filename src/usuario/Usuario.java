package usuario;


public class Usuario {
	private String nome;
	private String senha;
	private String cpf;
	private String email;
	private LocalizacaoAtual localizacao;
	private String cidadeCadastro;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalizacaoAtual getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(LocalizacaoAtual localizacao) {
		this.localizacao = localizacao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCidadeCadastro() {
		return cidadeCadastro;
	}
	public void setCidadeCadastro(String cidadeCadastro) {
		this.cidadeCadastro = cidadeCadastro;
	}
	
	

}
