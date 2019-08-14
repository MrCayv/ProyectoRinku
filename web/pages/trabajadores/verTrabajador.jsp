<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ver Trabajador</title>
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
	
	<h1 align="center">Ver Trabajador '<c:out value="${trabajador.nombre}"/>'</h1>
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
    
    <div class="container" >
    	<form action="">
    		<div class="form-row">
    			<div class="form-group col-3">
	    			<select class="form-control" name="mes">
					  	<option value="1">Enero</option>
					  	<option value="2">Febrero</option>
					  	<option value="3">Marzo</option>
					  	<option value="4">Abril</option>
					  	<option value="5">Mayo</option>
					  	<option value="6">Junio</option>
					  	<option value="7">Julio</option>
					  	<option value="8">Agosto</option>
					  	<option value="9">Septiembre</option>
					  	<option value="10">Octubre</option>
					  	<option value="11">Noviembre</option>
					  	<option value="12">Diciembreo</option>
					</select>
				</div>
				<div class="form-group col-3">
	    			<select class="form-control" name="year">
					  	<option value="2018">2018</option>
					  	<option value="2019">2019</option>
					  	<option value="2020">2020</option>
					  	<option value="2021">2021</option>
					  	<option value="2022">2022</option>
					  	<option value="2023">2023</option>
					  	<option value="2024">2024</option>
					  	<option value="2025">2025</option>
					</select>
				</div>
				<div class="form-group col-3">
	    			<button type="submit" class="btn btn-primary">Enviar</button>
				</div>
    		</div>
    	</form>
    </div>
    
    <div class="container" >
		<div class="form-group">
	    	<div class="row">  
		        <table class="table table-sm">
		        	<thead>
			            <tr>
			                <th scope="col">#</th>
			                <th scope="col">Fecha</th>
			                <th scope="col">Trabajador</th>
			                <th scope="col">Entregas</th>
			            </tr>
		            </thead>
		            <tbody>
			            <c:forEach var="movimiento" items="${listaMovimientos}">
			                <tr>
			                    <th scope="row"><c:out value="${movimiento.id}" /></td>
			                    <td><c:out value="${movimiento.fecha}" /></td>
			                    <td><c:out value="${movimiento.trabajador}" /></td>
			                    <td><c:out value="${movimiento.cant_entregas}" /></td>
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