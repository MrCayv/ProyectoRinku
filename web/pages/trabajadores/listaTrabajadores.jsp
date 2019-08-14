<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista de Trabajadores</title>
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
	
	<h1 align="center">Administración de Trabajadores</h1>
    <hr>
    
    <div class="container" >
		<div class="form-group">
	    	<div class="row">  
	    		<form action="ServletTrabajador?opcion=new" method="post"><button type="submit" class="btn btn-primary">Nuevo</button></form>
	    	</div>
	    	<div class="mt-3"></div>
	    	<div class="row">  
		        <table class="table table-sm">
		        	<thead>
			            <tr>
			                <th scope="col">#</th>
			                <th scope="col">Nombre</th>
			                <th scope="col">Rol</th>
			                <th scope="col">Tipo</th>
			                <th class="text-center" scope="col">Opciones</th>
			            </tr>
		            </thead>
		            <tbody>
			            <c:forEach var="trabajador" items="${listaTrabajadores}">
			                <tr>
			                    <th scope="row"><c:out value="${trabajador.id}" /></td>
			                    <td><c:out value="${trabajador.nombre}" /></td>
			                    <td><c:out value="${trabajador.rolString}" /></td>
			                    <td><c:out value="${trabajador.tipoString}" /></td>
			                    <td>
			                    	<div class="row float-right">
			                    		<form action="ServletTrabajador?opcion=show" method="post">
			                    			<input type="hidden" name="id" value="<c:out value='${trabajador.id}' />" />
				                    		<button type="submit" class="btn btn-primary">Ver</button>
				                    	</form> 
			                    		<form action="ServletMovimiento?opcion=new" method="post">
			                    			<input type="hidden" name="id" value="<c:out value='${trabajador.id}' />" />
				                    		<button type="submit" class="btn btn-success">Movimiento</button>
				                    	</form> 
				                    	<form action="ServletTrabajador?opcion=edit" method="post">
				                    		<input type="hidden" name="id" value="<c:out value='${trabajador.id}' />" />
				                    		<button type="submit" class="btn btn-warning">Editar</button>
				                    	</form>
				                    	<form action="ServletTrabajador?opcion=delete" method="post">
				                    		<input type="hidden" name="id" value="<c:out value='${trabajador.id}' />" />
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