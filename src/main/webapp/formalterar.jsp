<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Usuário</title>
</head>
<body>

	Olá ${usuarioLogado.nome}
	<a href="logout"><button>Sair do Sistema</button></a><br>
	
	<h1>Alterar Usuário</h1>

	<form action="portal" method="post">
		Id: <input type="text" name="txtid" value="${usuario.id}" readonly><br>
		<br> Nome: <input type="text" name="txtnome"
			value="${usuario.nome}"><br>
		<br> Login: <input type="text" name="txtlogin"
			value="${usuario.login}"><br>
		<br> Senha: <input type="password" name="txtsenha"
			value="${usuario.senha }"><br>
		<br> <input type="hidden" name="acao" value="alterar"> <input
			type="submit" value="Salvar">


	</form>

</body>
</html>