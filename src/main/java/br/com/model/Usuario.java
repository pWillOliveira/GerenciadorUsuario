package br.com.model;

public class Usuario {
	
	int idusuario;
	String nome;
	String login;
	String senha;
	
	public Usuario() {
	}
	public int getId() {
		return idusuario;
	}
	public void setId(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
