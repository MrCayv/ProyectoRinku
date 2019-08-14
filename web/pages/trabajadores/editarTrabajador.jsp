<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar Trabajador</title>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
</head>
<body>
	<ul class="nav nav-tabs">
	  <li class="nav-item">
	    <a class="nav-link active" href="ServletMovimiento">Home</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="ServletUsuario">Usuarios</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="ServletTrabajador">Trabajadores</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="ServletLogin">Salir</a>
	  </li>
	</ul>
	
	<h1 align="center">Editar trabajador '<c:out value='${trabajador.nombre}' />'</h1>
    <hr>
    
    <div class="container">
    	<form action="ServletTrabajador?opcion=update" method="post">
    		<input type="hidden" name="id" value="<c:out value='${trabajador.id}' />" />
		  	<div class="form-group">
			    <label>Nombre</label>
			    <input type="text" class="form-control" name="nombre" value="<c:out value='${trabajador.nombre}'/>" placeholder="Introducir nombre">
		  	</div>
		  	<div class="form-group">
			    <label>Rol</label>
			    <select class="form-control" name="rol">
				  	<option value="1" <c:if test="${trabajador.rol==1}">selected</c:if>>Chofer</option>
				  	<option value="2" <c:if test="${trabajador.rol==2}">selected</c:if>>Cargador</option>
				  	<option value="3" <c:if test="${trabajador.rol==3}">selected</c:if>>Auxiliar</option>
				</select>
		  	</div>
		  	<div class="form-group">
			    <label>Tipo</label>
			    <select class="form-control" name="tipo">
				  	<option value="1" <c:if test="${trabajador.tipo==1}">selected</c:if>>Interno</option>
				  	<option value="2" <c:if test="${trabajador.tipo==2}">selected</c:if>>Externo</option>
				</select>
		  	</div>
		  	
		  	<button type="submit" class="btn btn-primary">Editar</button>
		</form>
    </div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="./resources/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>