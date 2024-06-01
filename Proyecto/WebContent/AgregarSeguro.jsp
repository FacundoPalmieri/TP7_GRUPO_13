<%@page import="negocio.TipoSeguro" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar seguros</title>
</head>
<body>
	<form action="servletSeguro" method="post">
		<a href = "Inicio.jsp"> Inicio</a>
		<a href = "AgregarSeguro.jsp"> Agregar Seguro</a>
		<a href = "ListarSeguro.jsp"> Listar Seguro</a>
		<br><br>
		ID Seguro: <input type="text" name="txtIDSeguro">
		<br>
		Descripción: <input type="text" name="txtDescripcion">
		<br>
		<br>
		<% 
			ArrayList<TipoSeguro> listaTipos = null;
			if(request.getAttribute("ListaTipos")!=null){
				listaTipos= (ArrayList<TipoSeguro>)request.getAttribute("ListaTipos");
			}
		%>
			<b>Tipo seguro: </b>
			<select name="tipoSeguro">
				<%
					if(listaTipos!=null)
					for(TipoSeguro ts : listaTipos){%>
						<option value=<%=ts.getDescripcion()%>></option>
			<%} %>
			</select>
		<br>
		Costo contratación: <input type="text" name="txtCostoContratacion">
		<br>
		Costo máximo asegurado: <input type="text" name="txtCostoMaximo">
		<br>
		<input type="submit" value="Aceptar" name="btnAceptar">
	</form>
</body>
</html>