<%@page import="unu.ProyectoPractica.beans.Autor"%>
<%@page import="java.util.List"%>
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
	<a href="<%=url%>AutoresController?op=nuevo">Nuevo</a>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre Autor</th>
				<th>Nacionalidad Autor</th>
				<th>operaciones</th>
			</tr>
		</thead>
		<tbody>
		<%
			List<Autor> listaAutores =(List<Autor>) request.getAttribute("listaAutores");
			//verificamos si la lista esta vacia
			if(listaAutores != null){
				//creamos un iterador sobre la lista
				for(Autor autor: listaAutores){
					%>
					<tr>
						<td><%=autor.getIdAutor()%></td>
						<td><%=autor.getNombreAutor()%></td>
						<td><%=autor.getNacionalidad()%></td>
						<td>
						<a type="button" href="<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>">Modificar</a>
						<a type="button" href="<%=url%>AutoresController?op=eliminar&id=<%=autor.getIdAutor()%>">Eliminar</a>
						</td>
					</tr>
					<%
				}
			} else { %>
				<tr>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td></td>
				</tr>
			
			<%	
			}
		%>	
		</tbody>
	</table>
</body>
</html>