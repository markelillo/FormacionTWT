<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inicio</title>
</head>
<body>

	<h2>Bienvenido ${usuario.nombre}!!!!!!!!!!!</h2>
	<p>Eres:${usuario.rol}</p>
	
	<a href="pedidos">listar mis pedidos</a>


</body>
</html>