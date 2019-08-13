<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto Rinku</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="abs-center">
			<form action="ServletLogin" method="post" class="border p-3 form">
				<h3>Iniciar sesión</h3>
				<div class="form-group">
				    <label for="exampleInputEmail1">Usuario</label>
				    <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Introducir usuario" required>
			  	</div>
			  	<div class="form-group">
				    <label for="exampleInputPassword1">Contraseña</label>
				    <input type="password" class="form-control" id="pass" name="pass" placeholder="Contraseña" required>
		  		</div>
			  	<div class="form-group form-check">
				    <input type="checkbox" class="form-check-input" id="exampleCheck1">
				    <label class="form-check-label" for="exampleCheck1">Recordarme</label>
			  	</div>
			  	<button type="submit" class="btn btn-primary">Entrar</button>
			</form>
		</div>
	</div>
	
	<style type="text/css">
		.abs-center {
		  	display: flex;
		  	align-items: center;
		  	justify-content: center;
		  	min-height: 100vh;
		}
 
		.form {
  			width: 450px;
		}
  	</style>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="./resources/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>