<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista de Movimientos</title>
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
	
	<h1 align="center">Administración de Movimientos</h1>
    <hr>
    
    <div class="container" >
    	<div class="row">  
    		<form action="ServletTrabajador" method="post"><button type="submit" class="btn btn-primary">Nuevo</button></form>
    	</div>
    	<div class="mt-3"></div>
		<div class="form-group">
	    	<div class="row">  
		        <table class="table table-sm">
		        	<thead>
			            <tr>
			                <th scope="col">#</th>
			                <th scope="col">Fecha</th>
			                <th scope="col">Trabajador</th>
			                <th scope="col">Entregas</th>
			                <th scope="col">Opciones</th>
			            </tr>
		            </thead>
		            <tbody>
			            <c:forEach var="movimiento" items="${listaMovimientos}">
			                <tr>
			                    <th scope="row"><c:out value="${movimiento.id}" /></td>
			                    <td><c:out value="${movimiento.fecha}" /></td>
			                    <td><c:out value="${movimiento.trabajador}" /></td>
			                    <td align="center"><c:out value="${movimiento.cant_entregas}" /></td>
			                    <td>
			                    	<div class="row" align="center">
				                    	<form action="ServletMovimiento?opcion=show&id=<c:out value='${movimiento.id}'/>" method="post">
				                    		<button type="submit" class="btn btn-primary">Ver</button>
				                    	</form>
				                    	<form action="ServletMovimiento?opcion=delete&id=<c:out value='${movimiento.id}'/>" method="post">
				                    		<button type="submit" class="btn btn-danger">Eliminar</button>
				                    	</form> 
			                    	</div>
			                    </td>
			                </tr>
			            </c:forEach>
		            </tbody>
		        </table>
	        </div>
        </div>
    </div>   
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="./resources/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>