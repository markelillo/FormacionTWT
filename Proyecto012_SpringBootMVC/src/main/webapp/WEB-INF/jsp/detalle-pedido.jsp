<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pedido</title>
</head>
<body>

	<h1>Detalle de pedido</h1>
id: ${pedido.id}
</br>
descipcion:${pedido.desc}
</br>
Fecha:${pedido.fechaPedido}
</br>
Entregado:${pedido.entregado}
</body>
</html>