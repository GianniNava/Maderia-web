
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Menu Principal</title>
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
    <link href="estilos/estilo-general.css" rel="stylesheet" type="text/css" />
</head>
<body>

<% usuario.setRequest(request);%>

<div class="encabezado">Login</div>
<form name="forma01" action="index.jsp" method="post">
<table class="login">
<tr>
<td>Usuario:</td>
<td><input type="text" name="usuario" value="<jsp:getProperty name="usuario" property="cookie" />" /></td>
</tr>

<tr>
<td>Password:</td>
<td><input type="password" name="password" /></td>
</tr>

<tr>
<td>
<td><button type="submit">Enviar</button><button type="reset">Limpiar</button></td>
</tr>
<td colspan=2>
<h5 id="error"><jsp:getProperty name="usuario" property="mensaje" /></h5><br>
<a href="registrarse.jsp">Registrarse!</a>
</td>
</tr>
</table>
</form>

</div>
</body>
</html>