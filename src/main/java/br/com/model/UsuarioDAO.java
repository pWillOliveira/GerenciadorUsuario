package br.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	public void Cadastrar(Usuario usuario) {

		Connection conn = Conexao.Conecta();
		String query = "insert into usuario(nome,login,senha) values(?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getLogin());
			pstm.setString(3, usuario.getSenha());
			pstm.execute();
			pstm.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Usuario> mostrarTodos() {
		String query = "SELECT * FROM usuario";
		List<Usuario> usuarios = new ArrayList<>();

		try (Connection conn = Conexao.Conecta()) {
			try (PreparedStatement pstm = conn.prepareStatement(query)) {
				try (ResultSet rs = pstm.executeQuery()) {
					while (rs.next()) {
						Usuario usuario = new Usuario();
						usuario.setId(rs.getInt("idusuario"));
						usuario.setNome(rs.getString("nome"));
						usuario.setLogin(rs.getString("login"));
						usuario.setSenha(rs.getString("senha"));
						usuarios.add(usuario);
					}
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return usuarios;
	}

	public Usuario buscarPorId(int idusuario) {

		String query = "SELECT * FROM usuario WHERE idusuario = ?";
		Usuario usuario = null;

		try (Connection conn = Conexao.Conecta()) {

			try (PreparedStatement pstm = conn.prepareStatement(query)) {
				pstm.setInt(1, idusuario);

				try (ResultSet rs = pstm.executeQuery()) {
					if (rs.next()) {
						usuario = new Usuario();
						usuario.setId(rs.getInt("idusuario"));
						usuario.setNome(rs.getString("nome"));
						usuario.setLogin(rs.getString("login"));
						usuario.setSenha(rs.getString("senha"));

					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public void Alterar(Usuario usuario) {
		String query = "UPDATE usuario SET nome = ?, login = ?, senha = ? WHERE idusuario = ?";

		try (Connection conn = Conexao.Conecta()) {
			try (PreparedStatement pstm = conn.prepareStatement(query)) {
				pstm.setString(1, usuario.getNome());
				pstm.setString(2, usuario.getLogin());
				pstm.setString(3, usuario.getSenha());
				pstm.setInt(4, usuario.getId());

				pstm.execute();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void Remover(int idusuario) {

		String query = "DELETE FROM usuario WHERE idusuario = ?";

		try (Connection conn = Conexao.Conecta()) {
			try (PreparedStatement pstm = conn.prepareStatement(query)) {
				pstm.setInt(1, idusuario);
				pstm.execute();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario verificarLogin (String login, String senha) {
		
		String query = "SELECT * FROM usuario WHERE login=? AND senha=?";
		Usuario usuario = null;
		
		try(Connection conn = Conexao.Conecta()){
			try(PreparedStatement pstm = conn.prepareStatement(query)){
				pstm.setString(1, login);
				pstm.setString(2, senha);
				
				ResultSet rs = pstm.executeQuery();
				
				if(rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getInt("idusuario"));
					usuario.setNome(rs.getString("nome"));
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
}
