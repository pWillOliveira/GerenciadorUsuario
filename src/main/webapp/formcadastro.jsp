<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>
	
	Olá ${usuarioLogado.nome}
	<a href="logout"><button>Sair do Sistema</button></a><br>
	
	<h1>Cadastro de Usuário</h1>

	<form action="portal" method="post">
		Nome: <input type="text" name="txtnome" autocomplete="off" required><br>
		<br> Login: <input type="text" name="txtlogin" autocomplete="off"
			required><br> <br> Senha: <input type="password"
			name="txtsenha" autocomplete="off" required><br> <br>
		<input type="hidden" name="acao" value="cadastrar"> <input
			type="submit" value="Salvar">
	</form>

</body>
</html>