<%@page import="negocio.TipoSeguro" %>
<%@page import="java.util.ArrayList" %>
<%@page import="negocio.Seguro" %>
<%@page import="negocio.SeguroDao" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tipo de seguros de la base de datos</title>
</head>
<body>

			<a href = "Inicio.jsp"> Inicio</a>
			<a href="servletSeguro?Param=1">Agregar Seguro</a>
			<a href="servletSeguro?Param=2">Listar Seguro</a>
		<br><br>
		<% 
			ArrayList<TipoSeguro> listaTipos = null;
			if(request.getAttribute("ListaTipos")!=null){
				listaTipos= (ArrayList<TipoSeguro>)request.getAttribute("ListaTipos");
			}
		%>
			<b>Busqueda por tipo de Seguros: </b>
			<select name="tipoSeguro">
				<%
					if(listaTipos!=null)
					for(TipoSeguro ts : listaTipos){%>
						<option value=<%=ts.getIdTipo()%>> <%=ts.getDescripcion() %> </option>
			<%} %>
			</select>
			
			<input type="submit" name"btnFiltrar" value="Filtrar">
			
		<% ArrayList<Seguro> ListaSeguros =null;
		
		 if(request.getAttribute("ListaS")!=null){
		
	ListaSeguros = (ArrayList<Seguro>) request.getAttribute("ListaS");
			}
		%>

	<table border="1">
		<tr><th> Id Seguro</th><th> Descripcion Seguro</th> <th> Descripcion Tipo de Seguro</th> <th> Costo Contratacion</th><th> Costo Maximo Asegurado</th>	</tr>
	
		<% 	if(ListaSeguros!=null)
		 for(Seguro user : ListaSeguros)
			{
		%>
	<tr><th><%= user.getId() %></th> <th><%= user.getDescripcion() %></th> <th> 3 </th><th><%= user.getCostoContratacion() %></th><th><%= user.getCostoMaximoAsegurado() %></th></tr>
		
	<%	}	%>

	</table>


</body>
</html>