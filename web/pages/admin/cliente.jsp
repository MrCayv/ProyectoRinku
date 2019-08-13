<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administración de clientes</title>
</head>
<body>
	<jsp:useBean id="cliBea" class="bean.Cliente"></jsp:useBean>
	<h3>Bienvenido: <jsp:getProperty property="nombre" name="cliBea"/> <jsp:getProperty property="apellido" name="cliBea"/></h3>
	<jsp:setProperty property="nombre" name="cliBea" value="Antonio"/>
	<h3>Bienvenido: <jsp:getProperty property="nombre" name="cliBea"/> <jsp:getProperty property="apellido" name="cliBea"/></h3>
</body>
</html>