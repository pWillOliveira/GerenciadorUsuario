package br.com.teste;

import br.com.model.UsuarioDAO;

public class TesteDeletar {

	public static void main(String[] args) {

		UsuarioDAO usuariodao = new UsuarioDAO();
		usuariodao.Remover(3);

	}

}
