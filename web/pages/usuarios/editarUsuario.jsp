<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar Usuario</title>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
</head>
<body>
	<ul class="nav nav-tabs">
	  <li class="nav-item">
	    <a class="nav-link" href="ServletMovimiento">Home</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link avtive" href="ServletUsuario">Usuarios</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="ServletTrabajador">Trabajadores</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="#">Reportes</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="ServletLogin">Salir</a>
	  </li>
	</ul>
	
	<h1 align="center">Editar usuario '<c:out value='${usuario.nombre}' />'</h1>
    <hr>
    
    <div class="container">
    	<form action="ServletUsuario?opcion=update" method="post">
    		<input type="hidden" name="id" value="<c:out value='${usuario.id}' />" />
		  	<div class="form-group">
			    <label>Nombre</label>
			    <input type="text" class="form-control" name="nombre" value="<c:out value='${usuario.nombre}'/>" placeholder="Introducir nombre">
		  	</div>
		  	<div class="form-group">
			    <label>Usuario</label>
			    <input type="text" class="form-control" name="usuario" value="<c:out value='${usuario.usuario}'/>" placeholder="Introducir usuario">
		  	</div>
		  	
		  	<button type="submit" class="btn btn-primary">Editar</button>
		</form>
    </div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="./resources/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>