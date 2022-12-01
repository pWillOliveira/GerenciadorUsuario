package br.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.model.Usuario;
import br.com.model.UsuarioDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		Usuario usuario = usuariodao.verificarLogin(login, senha);
		
		boolean usuarioExiste = usuario != null;
		
		if(usuarioExiste) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("portal?acao=mostrar");
			rd.forward(request, response);
			
		}else {
			response.sendRedirect("formlogin.jsp");
			
		}
	}
}
