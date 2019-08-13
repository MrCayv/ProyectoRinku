<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
</head>
<body>
	<div align="center">
        <h1>Administración de usuarios</h1>
        <h2>
            <a href="./ServletUsuario/new">Nuevo Usuario</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">Lista de Usuarios</a>
             
        </h2>
    </div>
    <div align="center">
        <c:if test="${usuario != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${usuario == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${usuario != null}">
                        Editar
                    </c:if>
                    <c:if test="${usuario == null}">
                        Nuevo
                    </c:if>
                </h2>
            </caption>
                <c:if test="${usuario != null}">
                    <input type="hidden" name="id" value="<c:out value='${usuario.id}' />" />
                </c:if>           
            <tr>
                <th>Nombre: </th>
                <td>
                    <input type="text" name="nombre" size="45"
                            value="<c:out value='${usuario.nombre}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Usuario: </th>
                <td>
                    <input type="text" name="usuario" size="45"
                            value="<c:out value='${usuario.usuario}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Contraseña: </th>
                <td>
                    <input type="password" name="password" size="45"
                            value="<c:out value='${usuario.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Guardar" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>