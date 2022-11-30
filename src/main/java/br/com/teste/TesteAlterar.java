package br.com.teste;

import br.com.model.Usuario;
import br.com.model.UsuarioDAO;

public class TesteAlterar {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Administrador");
		usuario.setLogin("admin");
		usuario.setSenha("admin");

		UsuarioDAO usuariodao = new UsuarioDAO();
		usuariodao.Alterar(usuario);

	}

}
