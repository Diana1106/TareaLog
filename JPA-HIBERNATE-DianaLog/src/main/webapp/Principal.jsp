<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
HttpSession sesionP = (HttpSession) request.getSession();
String usuariosesion = (String) sesionP.getAttribute("usuario");
if(usuariosesion==null){
	response.sendRedirect("loginvista.jsp");
}
%>

<body>

<form action="ServletUser" method = "post">

<input type="submit" value ="CERRAR SESION" name="btncerrar">

</form>
<a href="historialUsuarios.jsp">VER HISTORIAL DE USUARIOS </a>
<h1>Hola desde principal</h1>
</body>
</html>