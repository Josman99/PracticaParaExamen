<%@page import="unu.ProyectoPractica.beans.Autor"%>
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
	Autor autor;
	HttpSession sesion = request.getSession();
	if (request.getAttribute("autor") == null) {
		autor = new Autor();
	} else {
		autor = (Autor) request.getAttribute("autor");
		System.out.println(autor.getIdAutor());
		System.out.println(autor.getNombreAutor());
		System.out.println(autor.getNacionalidad());
	}
	%>

	<div class="container">
		<h3>Nuevo Autor</h3>
		<form role="form" action="<%=url%>AutoresController?op=modificar"
			method="POST">

			<input  type="hidden" name="id" id="id" value="<%=autor.getIdAutor() %>">
			<label>Ingrese nombre</label><br>
			<input type="text" name="nombre" id="nombre" value="<%=autor.getNombreAutor()%>"><br>
			<label>Ingrese nacionalidad</label><br>
			<input type="text" name="nacionalidad" id="nacionalidad" value="<%=autor.getNacionalidad()%>"><br>
			<input type="submit" name="guardar" value="guardar"><br>
			<a href="<%=url%>AutoresController?op=listar">volver</a>

		</form>
	</div>
	
</body>
</html>