package br.com.teste;

import java.util.List;

import br.com.model.Usuario;
import br.com.model.UsuarioDAO;

public class TesteMostrarTodos {

	public static void main(String[] args) {
		UsuarioDAO usuariodao = new UsuarioDAO();
		List<Usuario> usuarios = usuariodao.mostrarTodos();

		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getId());
			System.out.println(usuario.getNome());
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getSenha());
			System.out.println();
		}
	}

}
