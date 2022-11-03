<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="alta-pedido" method="post" modelAttribute="altaForm"><!-- modelAtribute se sincroiza con el que esta el loggincontrollermodel.addatribute -->

<form:label path="desc">Descripcion:</form:label>
<form:input path="desc" />
<form:errors path="desc" style="color:red"></form:errors></br>

<form:label path="entregado">Entregado a cliente:</form:label>
<form:input path="entregado" />
<form:errors path="entregado" style="color:red"></form:errors></br>
<form:button >Crear Pedido</form:button>
</form:form>
</body>
</html>