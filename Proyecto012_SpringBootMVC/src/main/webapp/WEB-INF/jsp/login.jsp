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
<form:form action="login" method="post" modelAttribute="usuario"><!-- modelAtribute se sincroiza con el que esta el loggincontrollermodel.addatribute -->
<form:label path="nombre">nombre Usuario:</form:label>
<form:input path="nombre" />
<form:label path="clave">Password:</form:label>
<form:input path="clave" />
<form:button onclick="/login">LOGIN</form:button>
</form:form>
</body>
</html>