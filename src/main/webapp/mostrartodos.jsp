<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Todos</title>
</head>
<body>


	<h1>Mostrar Usuários</h1>

	<a href="formcadastro.jsp"><button>Cadastrar Usuário</button></a>
	<br>
	<br>
	<c:if test="${not empty lista }">
		<table border="1" style="width: 80%">
			<thead>
				<tr style="background-color: black; color: white">
					<th>ID</th>
					<th>Nome</th>
					<th>Login</th>
					<th>Senha</th>
					<th colspan="2">Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${lista}">
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.login}</td>
						<td>${usuario.senha}</td>
						<td><a href="?acao=alterar&id=${usuario.id}">Alterar</a></td>
						<td><a href="?acao=excluir&id=${usuario.id}">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty lista}">
		<h3>Nenhum usuário cadastrado.</h3>
	</c:if>
</body>
</html>