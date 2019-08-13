<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto Rinku</title>
</head>
<body>
	<h3>Iniciar sesión</h3>
	
	<form action="ServletLogin" method="post">
	<input type="hidden" name="opcion" value="guardar">
		<table border="1">
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="usuario" size="50"></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type="password" name="pass" size="50"></td>
			</tr>
		</table>
		<input type="submit" value="Guardar">
	</form>
</body>
</html>