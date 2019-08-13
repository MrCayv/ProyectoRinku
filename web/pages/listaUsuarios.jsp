<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de usuarios</title>
</head>
<body>
    <h1>Administración de usuarios</h1>
    <h2>
        <a href="/new">Nuevo Usuario</a>
         &nbsp;&nbsp;&nbsp;
    	<a href="/list">Ver Usuarios</a>
          
   	</h2>
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Usuarios</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Usuario</th>
                <th>Contraseña</th>
                <th>Opciones</th>
            </tr>
            <c:forEach var="user" items="${listaUsuarios}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.nombre}" /></td>
                    <td><c:out value="${user.usuario}" /></td>
                    <td><c:out value="${user.password}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${user.id}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${user.id}' />">Eliminar</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>