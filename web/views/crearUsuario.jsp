<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Usuario</title>
</head>
<body>
	<h1>Nuevo Usuario</h1>
	
	<form action="UsuarioController" method="post">
	<input type="hidden" name="opcion" value="guardar">
		<table border="1">
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="usuario" size="50"></td>
			</tr>
			<tr>
				<td>Contrase�a:</td>
				<td><input type="password" name="pass" size="50"></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50"></td>
			</tr>
		</table>
		<input type="submit" value="Guardar">
	</form>
</body>
</html>