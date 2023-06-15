package usuario.entidade;

import java.io.Serializable;

import geral.entidade.Endereco;

public class Usuario implements Serializable{
	private String nome;
	private String senha;
	private String cpf;
	private String email;
	private Endereco endereco;
	private String cidadeCadastro;
	
	public Usuario(String nome, String senha, String cpf, String email, Endereco endereco){
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		
	}
	
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	/*@Override
	public String obterChave() {
		return numero+"";
	}*/
	

}
