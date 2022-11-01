<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>lista</title>
</head>
<body>

	<h1>Tienda Online</h1>
	<h4>Lista de un productos</h4>

	<div>usuario: ${sessionScope.usuario.nombre }</div>
	<div class="border border-warning">
		<h2>${requestScope.mensaje}</h2>
	</div>

	<!--  <table>
		<c:forEach var="producto" items="${requestScope.lista}">
			<tr>
				<td>${producto.idProducto}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio}</td>
				<td>${producto.stock}</td>
				<td>
				   <a href="comprar?idProducto=${producto.idProducto}">Comprar 1 unidad</a>
				
				</td>
				
			</tr>
		</c:forEach>
	</table>-->

	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Producto</th>
				<th scope="col">Precio</th>
				<th scope="col">Stock</th>
				<th scope="col">¿Que hacer?</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach var="producto" items="${requestScope.lista}">
				<tr>
					<td>${producto.idProducto}</td>
					<td>${producto.descripcion}</td>
					<td>${producto.precio}</td>
					<td>${producto.stock}</td>
					<!--  <td><a href="comprar?idProducto=${producto.idProducto}">Comprar
							1 unidad</a></td>-->
					<td><a href="comprar?idProducto=${producto.idProducto}"
						class="btn btn-success">Comprar 1</a>
					<a href="borrar?idProducto=${producto.idProducto}"
						class="btn btn-danger">Eliminar Producto</a>
					<a href="update?idProducto=${producto.idProducto}"
						class="btn btn-warning">Añadir Stock</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<form class="row row-cols-lg-auto g-3 align-items-center" action="comprar" method="get">
		

		<div class="col-4">
			<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
			<select class="form-select" id="inlineFormSelectPref" name="idProducto">
				<c:forEach var="producto" items="${requestScope.lista}">
				<option value="${producto.idProducto}" >${producto.descripcion}</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="col-4">
			<label class="visually-hidden" for="inlineFormInputGroupUsername">Cantidad</label>
			<div class="input-group">
				<input type="number" class="form-control"
					name="cantidad" placeholder="cantidad">
			</div>
		</div>


		<div class="col-4">
			<button type="submit" class="btn btn-danger">Comprar</button>
		</div>
	</form>



</body>
</html>