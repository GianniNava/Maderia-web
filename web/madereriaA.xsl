<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:template match="madereriaA">
<html>
	<head>
	    <title> </title>
	    <link href="estilos/estilo.css" rel="stylesheet" type="text/css" /> 
	</head>
	<body>
		<table class="catalogo" >
			<tr>
				<th>Producto</th>
				<th>Presentacion</th>
			</tr>
			<xsl:for-each select="producto">
				<tr>
					<td>
						<span>Id:  </span><xsl:value-of select="id"/><br></br>
						<span>Arbol:  </span><xsl:value-of select="arbol"/><br></br>
                                                <span>Largo:  </span><xsl:value-of select="largo"/><br></br>
                                                <span>Ancho:  </span><xsl:value-of select="ancho"/><br></br>
                                                <span>Alto:  </span><xsl:value-of select="alto"/><br></br>
						<span>Precio:  </span><xsl:value-of select="precio"/><br></br>
					</td>
				        <td>
					        <xsl:variable name="carpeta-imagenes">imagenes</xsl:variable>
					        <xsl:variable name="archivo-imagen"> <xsl:value-of select="imagen"/></xsl:variable>
					        <center><img src="{$carpeta-imagenes}/{$archivo-imagen}" /></center>
				        </td>
				</tr>
			</xsl:for-each>
		</table>
	</body>
</html>
</xsl:template>
</xsl:stylesheet>
