<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ver Movimiento</title>
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
	    <a class="nav-link" href="ServletReporte">Reportes</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="ServletLogin">Salir</a>
	  </li>
	</ul>
	
	<h1 align="center">Ver movimiento #<c:out value="${movimiento.id}" /></h1>
    <hr>
    
    <div class="container" style="background-color:lightblue">
    	<h3 align="center">Empleado</h3>
    	<table class="table table-sm">
        	<thead>
	                <th scope="col">#</th>
	                <th scope="col">Nombre</th>
	                <th scope="col">Rol</th>
	                <th scope="col">Tipo</th>
	            </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row"><c:out value="${trabajador.id}" /></td>
                    <td><c:out value="${trabajador.nombre}" /></td>
                    <td><c:out value="${trabajador.rolString}" /></td>
                    <td><c:out value="${trabajador.tipoString}" /></td>
                </tr>
            </tbody>
        </table>
    </div>
    <hr>
    
    <div class="container">
    	<form action="ServletMovimiento?opcion=insert" method="post">
		  	<div class="form-group">
			    <label>Fecha</label>
			    <input type="date" class="form-control" name="fecha" value="<c:out value="${movimiento.fecha}"/>" disabled>
		  	</div>
		  	<div class="form-group">
			    <label>Cantidad de entregas</label>
			    <input type="number" class="form-control" name="cant_entregas" value="<c:out value="${movimiento.cant_entregas}"/>" disabled>
		  	</div>
		  	<div class="form-group">
			    <input class="form-check-input" type="checkbox" id="defaultCheck1" <c:if test="${movimiento.cubrio_turno==1}">checked</c:if> disabled>
			  	<label class="form-check-label" for="defaultCheck1">Cubri� turno</label>
		  	</div>
		</form>
    </div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="./resources/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>