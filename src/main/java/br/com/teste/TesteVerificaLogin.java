package br.com.teste;

import br.com.model.Usuario;
import br.com.model.UsuarioDAO;

public class TesteVerificaLogin {

	public static void main(String[] args) {
		String login = "admin";
		String senha = "admin";
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		Usuario usuario = usuariodao.verificarLogin(login, senha);
		
		System.out.println(usuario.getId());
		System.out.println(usuario.getNome());
		System.out.println(usuario.getLogin());
		System.out.println(usuario.getSenha());

	}

}
