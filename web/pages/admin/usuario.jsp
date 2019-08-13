<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administraci�n de usuarios</title>
</head>
<body>
<%-- Tag Declaraci�n --%>
<%! Date fechaActual = new Date(); %>
	<form action="">
		<fieldset>
			<legend>DatosGenerales</legend>
			<table>
				<tr>
					<td>Nombre:</td>
					<td><input name="nombre" type="text"></td>
				</tr>
				<tr>
					<td>Usuario:</td>
					<td><input name="usuario" type="text"></td>
				</tr>
				<tr>
					<td>Contrase�a:</td>
					<td><input name="pass" type="password"></td>
				</tr>
			</table>
		</fieldset>
		<br>
		<fieldset>
			<legend>Lista de Usuarios</legend>
			<table>
				<thead>
					<tr>
						<td>ID</td>
						<td>Nombre</td>
						<td>Usuario</td>
						<td>Contrase�a</td>
					</tr>
				</thead>
				<%-- Scriptlets - Bloques de c�digo --%>
				<% for(int i=0;i<10;i++) {%>
				<tr>
					<%-- Expresi�n - Unir c�digo Java con HTML --%>
					<td><%=i %></td>
					<td>Cesar<%=i %></td>
					<td>cesar<%=i %></td>
					<td>cesar<%=i %></td>
				</tr>
				<%} %>
			</table>
		</fieldset>
		<br>
		<h4>Fecha: <%=fechaActual %></h4>
	</form>
</body>
</html>