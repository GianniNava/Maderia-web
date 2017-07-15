/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletConfig;

public class ServletCatalogo extends HttpServlet{
    private String mySQLHost;
    private String dbName;
    private String user;
    private String password;
    
    @Override
    public void init(ServletConfig config) throws ServletException
    {
    	super.init(config);
        mySQLHost = getServletContext().getInitParameter("mySQLHost");
	dbName = getServletContext().getInitParameter("dbName");
        user = getServletContext().getInitParameter("user");
        password = getServletContext().getInitParameter("password");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            PrintWriter out = response.getWriter ();
            String indicadorTipo = request.getParameter("tipo");

            if(indicadorTipo==null){
                indicadorTipo="1";
            }

            if(indicadorTipo.equals("1"))
            {
                response.setContentType("text/html");
                out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
                out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
                out.println("<head>");
                  out.println("<title>Catalogo</title>");
                  out.println("<link href=\"estilos/estilo.css\" rel=\"stylesheet\" type=\"text/css\" />");
                out.println("</head><body>");
                out.println("<div>");
                  out.println("<div id=\"headder\">");
                    out.println("<div id=\"logo\">");
                      out.println("<h1>Madereria Sanchez</h1>");
                      out.println("<h2>La mejor madereria del mercado</h2>");
                    out.println("</div>");
                  out.println("</div>");
                  out.println("<div id=\"menu\">");
                    out.println("<ul>");
                      out.println("<li><a href=\"index.html\">Inicio</a></li>");
                      out.println("<li class=\"active\"><a href='catalogo?tipo=1'>Productos</a></li>");
                      out.println("<li><a href=\"ubicacion.html\">Ubicacion</a></li>");
                      out.println("<li><a href=\"contacto.html\">Contacto</a></li>");
                    out.println("</ul>");
                  out.println("</div>");
                  out.println("<div id=\"splash\">");
                    out.println("<img src=\"imagenes/madereria.jpg\" width=\"900\" height=\"200\" alt=\"\" repeat-none/>");
                  out.println("</div>");
                  out.println("<div id=\"page\">");
                    out.println("<div>");
                      out.println("<div id=\"content\">");
                
                      imprimeTablaHTML(out);
                
                      out.println("</div>");
                      out.println("<div id=\"sidebar\">");
                        out.println("<ul>");
                          out.println("<li>");
                          out.println("<h2>Maderas duras</h2>");
                            out.println("<ul>");
                              out.println("<li><a href=\"maderasDuras.html\">Descripcion</a></li>");
                              out.println("<li><a href=\"roble.html\">Roble</a></li>");
                              out.println("<li><a href=\"nogal.html\">Nogal</a></li>");
                              out.println("<li><a href=\"cerezo.html\">Cerezo</a></li>");
                            out.println("</ul>");
                          out.println("</li>");
                          out.println("<li>");
                          out.println("<h2>Maderas Blandas</h2>");
                            out.println("<ul>");
                              out.println("<li><a href=\"maderasBlandas.html\">Descripcion</a></li>");
                              out.println("<li><a href=\"alamo.html\">Alamo</a></li>");
                              out.println("<li><a href=\"abedul.html\">Abedul</a></li>");
                              out.println("<li><a href=\"aliso.html\">Aliso</a></li>");
                            out.println("</ul>");
                          out.println("</li>");
                        out.println("</ul>");
                      out.println("</div>");
                      out.println("<div style=\"clear:both;\"></div>");
                    out.println("</div>");
                    out.println("<div id=\"footer\">");
                      out.println("<div class=\"fleft\"><p></p></div>");
                      out.println("<div class=\"fright\"><p><a href=\"\" target=\"_blank\"></a></p></div>");
                      out.println("<div class=\"fcenter\"><p><a href=\"\"></a></p></div>");
                      out.println("<div class=\"fclear\"></div>");
                    out.println("</div>");
                  out.println("</div>");
                out.println("</div>");

                out.println("</body></html>");
            }
            else
            {
    		response.setContentType("text/xml");
    		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<?xml-stylesheet type=\"text/xsl\" href=\"veterinaria.xsl\" ?>");
                out.println("<madereria xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"veterinaria.xsd\">");

                imprimeXML(out);

               out.println("</madereria>");
            }
            out.flush();
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    public void imprimeTablaHTML(PrintWriter out){
	try{
	    Class.forName("org.mariadb.jdbc.Driver");
            String urlBD = mySQLHost + dbName+ "?user=" + user + "&password=" + password;
	    Connection con = DriverManager.getConnection(urlBD);
            Statement stmt = con.createStatement();

	    boolean r = stmt.execute("select * from producto");
	    if(r){
	   	ResultSet rs = stmt.getResultSet();

                out.println("<table id=\"tablaC\">");
                out.println("<tr class=\"lineaC\"><th class=\"celdaCid\">Id</th><th class=\"celdaCarbol\">Arbol</th><th class=\"celdaClargo\">Largo (m)</th><th class=\"celdaCancho\">Ancho (m)</th><th class=\"celdaCalto\">Alto (in)</th><th class=\"celdaCprecio\">Precio (pesos)</th><th class=\"celdaCimagen\">Imagen</th>");
		while(rs.next()){
			out.println("<tr class=\"lineaC\">");
                        out.println("<td class=\"celdaCont\">" + rs.getString("id") + "</td>");
		        out.println("<td class=\"celdaCont\">" + rs.getString("arbol") + "</td>");
                        out.println("<td class=\"celdaCont\">" + rs.getString("largo") + "</td>");
                        out.println("<td class=\"celdaCont\">" + rs.getString("ancho") + "</td>");
                        out.println("<td class=\"celdaCont\">" + rs.getString("alto") + "</td>");
		        out.println("<td class=\"celdaCont\">" + rs.getString("precio") + "</td>");
                        String imagen = rs.getString("imagen");
		        out.println("<td class=\"celdaCont\"><img src=imagenes/"+ imagen +" width=\"200\" height=\"100\"></td>");
                        out.println("</tr>");
	      	}
	      	out.println("</table>");
	    }
	}
	catch(Exception e){
		out.println(e.toString());
	}
    }
    
    public void imprimeXML(PrintWriter out){
	try{
            Class.forName("org.mariadb.jdbc.Driver");
            String urlBD = mySQLHost + dbName+ "?user=" + user + "&password=" + password;
	    Connection con = DriverManager.getConnection(urlBD);
            Statement stmt = con.createStatement();

            boolean r = stmt.execute("select * from productos");
            if(r){
                ResultSet rs = stmt.getResultSet();
		while(rs.next()){
		    out.println("<producto>");
		    out.println("<id>" + rs.getString("id") + "</id>");
		    out.println("<arbol>" + rs.getString("arbol") + "</arbol>");
                    out.println("<largo>" + rs.getString("largo") + "</largo>");
                    out.println("<ancho>" + rs.getString("ancho") + "</ancho>");
                    out.println("<alto>" + rs.getString("alto") + "</alto>");
		    out.println("<precio>" + rs.getString("precio") + "</precio>");
		    out.println("<imagen>" + rs.getString("imagen") + "</imagen>");
		    out.println("</producto>");
                }
  	    }
	}
	catch(Exception e){
	    out.println(e.toString());
	}
    } 
}