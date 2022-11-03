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
	<c:if test = "${usuario.rol eq 'cliente' }">
	<a href="pedidos/${usuario.nombre}">listar mis pedidos</a>
	<a href="alta-pedido">añadir pedido</a>
	</c:if>
	<c:if test = "${usuario.rol eq 'admin' }">
	<a href="pedidos">listar todos los pedidos</a>
	</c:if>

</body>
</html>