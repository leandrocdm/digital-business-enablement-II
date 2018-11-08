<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Carro</title>
</head>
<body>

	<form action="cadastrar" method="post">

		<div>
			<label for="id-modelo">Modelo:</label> <input type="text"
				name="modelo" id="id-modelo" />
		</div>

		<div>
			<label for="id-marca">Marca:</label> <input type="text" id="id-marca"
				name="marca" />
		</div>
		<div>
			<input type="checkbox" name="novo" id="id-novo"> 
			<label for="id-novo">Novo</label>
		</div>

		<div>
			<input type="radio" name="cambio" value="automatico">Automatico
			<br> 
			<input type="radio" name="cambio" value="manual">Manual
			<br>
		</div>
		<div>
					<label for="id-ano">Ano:</label> <input type="text" id="id-ano"
				name="ano" />
		</div>

		<input type="submit" value="Enviar">

	</form>

</body>
</html>