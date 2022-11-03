<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pedido</title>
</head>
<body>

	<h1>Detalle de pedido</h1>
	id: ${pedido.id}
	</br> descipcion:${pedido.desc}
	</br> Fecha:
	<fm:formatDate value="${pedido.fechaPedido}" pattern="dd-MM-yyyy" />
	</br> Entregado:${pedido.entregado}
</body>
</html>