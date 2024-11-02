<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String url = "http://localhost:8080/MisPracticasPersonales/";
	
%>

	<form role="form" action="<%=url%>AutoresController?op=ingresar" method="POST">
		<input  type="hidden" name="id" id="id">
		<label>Ingrese nombre</label><br>
		<input type="text" name="nombre" id="nombre"><br>
		<label>Ingrese nacionalidad</label><br>
		<input type="text" name="nacionalidad" id="nacionalidad"><br>
		<input type="submit" name="guardar" value="guardar"><br>
		<a href="<%=url%>AutoresController?op=listar">volver</a>
	</form>
	
</body>
</html>