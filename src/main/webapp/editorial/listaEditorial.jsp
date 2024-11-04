<%@page import="unu.ProyectoPractica.beans.Editorial"%>
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
	<a href="<%=url%>EditoresController?op=nuevo">Nuevo</a>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre editorial</th>
				<th>Contacto</th>
				<th>Telefono</th>
			</tr>
		</thead>
		<tbody>
		<%
			List<Editorial> listaEditorial = (List<Editorial>) request.getAttribute("listaEditorial");
			//verificamos si la lista esta vacia
			if(listaEditorial != null){
				//creamos un iterador sobre la lista
				for(Editorial editoral: listaEditorial){
					%>
					<tr>
						<td><%=editoral.getId()%></td>
						<td><%=editoral.getNombreEdit()%></td>
						<td><%=editoral.getContactoEdit()%></td>
						<td><%=editoral.getTelefonoEdit()%></td>
						<td>
						<a type="button" href="<%=url%>EditoresController?op=obtener&id=<%=editoral.getId()%>">Modificar</a>
						<a type="button" href="<%=url%>EditoresController?op=eliminar&id=<%=editoral.getId()%>">Eliminar</a>
						</td>
					</tr>
					<%
				}
			} else { %>
				<tr>
					<td>No hay datos</td>
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