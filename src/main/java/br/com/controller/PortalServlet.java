package br.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Usuario;
import br.com.model.UsuarioDAO;

@WebServlet("/portal")
public class PortalServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idStr = request.getParameter("txtid");
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		String acao = request.getParameter("acao");

		if (acao.equals("cadastrar")) {
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setLogin(login);
			usuario.setSenha(senha);

			UsuarioDAO usuariodao = new UsuarioDAO();
			usuariodao.Cadastrar(usuario);

		} else if (acao.equals("alterar")) {
			int id = Integer.valueOf(idStr);
			Usuario usuario = new Usuario();
			usuario.setId(id);
			usuario.setNome(nome);
			usuario.setLogin(login);
			usuario.setSenha(senha);

			UsuarioDAO usuariodao = new UsuarioDAO();
			usuariodao.Alterar(usuario);
		}

		response.sendRedirect("portal?acao=mostrar");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		if (acao.equals("mostrar")) {
			UsuarioDAO usuariodao = new UsuarioDAO();
			List<Usuario> usuarios = usuariodao.mostrarTodos();

			request.setAttribute("lista", usuarios);
			RequestDispatcher rd = request.getRequestDispatcher("mostrartodos.jsp");
			rd.forward(request, response);

		}

		if (acao.equals("excluir")) {
			int id = Integer.valueOf(request.getParameter("id"));

			UsuarioDAO usuariodao = new UsuarioDAO();
			usuariodao.Remover(id);

			response.sendRedirect("portal?acao=mostrar");
		}

		if (acao.equals("alterar")) {
			int id = Integer.valueOf(request.getParameter("id"));

			UsuarioDAO usuariodao = new UsuarioDAO();
			Usuario usuario = usuariodao.buscarPorId(id);

			request.setAttribute("usuario", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("formalterar.jsp");
			rd.forward(request, response);

		}

	}
}
