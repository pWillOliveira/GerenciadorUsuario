package br.com.teste;

import br.com.model.Usuario;
import br.com.model.UsuarioDAO;

public class TesteBuscarPorId {

	public static void main(String[] args) {

		UsuarioDAO usuariodao = new UsuarioDAO();
		Usuario usuario = usuariodao.buscarPorId(2);

		System.out.println(usuario.getId());
		System.out.println(usuario.getNome());
		System.out.println(usuario.getLogin());
		System.out.println(usuario.getSenha());

	}

}
