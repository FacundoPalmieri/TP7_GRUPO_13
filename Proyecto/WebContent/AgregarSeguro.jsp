<%@page import="negocio.TipoSeguro" %>
<%@page import="java.util.ArrayList" %>
<%@page import="negocio.Seguro" %>
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
		<a href = "ListarSeguro.jsp"> Listar Seguro</a>
		<br><br>
		ID Seguro: <%=request.getAttribute("idSeguro") %>
		<br>
		Descripci�n: <input type="text" name="txtDescripcion">
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
		Costo contrataci�n: <input type="text" name="txtCostoContratacion">
		<br>
		Costo m�ximo asegurado: <input type="text" name="txtCostoMaximo">
		<br>
		<input type="submit" value="Aceptar" name="btnAceptar">
	</form>
</body>
</html>