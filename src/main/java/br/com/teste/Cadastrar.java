package br.com.teste;

import br.com.model.Usuario;
import br.com.model.UsuarioDAO;

public class Cadastrar {

	public static void main(String[] args) {

		Usuario user = new Usuario();
		user.setLogin("scampos");
		user.setNome("Sibele Campos");
		user.setSenha("12345");

		UsuarioDAO usuariodao = new UsuarioDAO();
		usuariodao.Cadastrar(user);

	}

}
