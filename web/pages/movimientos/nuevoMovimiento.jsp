<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Nuevo Movimiento</title>
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
	
	<h1 align="center">Captura de movimientos</h1>
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
    		<input type="hidden" name="id_empleado" value="<c:out value='${trabajador.id}' />" />
		  	<div class="form-group">
			    <label>Fecha</label>
			    <input type="date" class="form-control" name="fecha" required>
		  	</div>
		  	<div class="form-group">
			    <label>Cantidad de entregas</label>
			    <input type="number" class="form-control" name="cant_entregas" placeholder="Introducir entregas" required>
		  	</div>
		  	<div class="form-group">
			    <label>Cubrió Turno</label>
			    <input type="number" class="form-control" name="cubrio_turno" placeholder="Introducir horas" required>
		  	</div>
		  	
		  	<button type="submit" class="btn btn-primary">Guardar</button>
		</form>
    </div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="./resources/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>