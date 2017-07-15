/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import javax.servlet.http.*;

// Clases para el pool de conexiones

import javax.servlet.ServletContext;

public class BeanUsuario
{
	private String user;
	private String password;
	private String nombre;
        private String apellido;
	private String mensaje="";
	private boolean autentico;
	private HttpServletRequest request;
	private String cookie;
        private ServletContext contexto;


	// Constructor sin parametros

	public BeanUsuario()
	{
		user=null;
		password=null;
		autentico=false;
	}

	

	public boolean isAutentico()
	{
		return autentico;
	}


	// Metodos set

        public void setContexto(ServletContext contexto)
        {
            this.contexto = contexto;
        }
        
	public void setUser(String user)
	{
		if(user!=null)
		this.user = user;
	}

	public void setPassword(String password)
	{
		if(password!=null)
		this.password = password;
	}

	public void setNombre(String nombre)
	{
		if(nombre!=null)
		this.nombre = nombre;
	}
        public void setApellido(String apellido){

        if(apellido!=null)
            this.apellido=apellido;
        }
        // Metodos get
	public String getUser()
	{
		return user;
	}

	public String getPassword()
	{
		return password;
	}

	public String getNombre()
	{
		return nombre;
	}

	public String getMensaje()
	{
		return mensaje;
	}



	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	public 	String getCookie() // Regresa una galleta guardada, si existe
	{
		if(request!=null)
		{
			cookie = getCookie(request);
			if(cookie!=null)
			{
				return cookie;
			}
		}
		return "";
	}

	public void autenticar(HttpServletRequest request, HttpServletResponse response)
	{
		this.request = request;

		if(user!=null && user.length() > 0)
		{
			try
		    {

		        Connection con = DataConnetor.obtieneConexion(contexto);

	        	Statement stmt = con.createStatement();
	        	boolean r = stmt.execute("select * from usuarios where user='"+user+"'");
	        	if(r)
	        	{
		        	ResultSet rs = stmt.getResultSet();
	        		if(rs.next())
	        		{
	        			String pass = rs.getString("password").trim();
	        			String name = rs.getString("nombre");
	        			password = password.trim();
	        			if(pass.equals(password))
	        			{
	        				autentico = true;
	        				this.password = pass;
	        				this.nombre   = name;
	        				this.mensaje = "";
	        				guardaGalleta(response);
	        			}
	        		}
	        	}

	        	con.close();
	    	}
	    	catch (Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	    	if(!autentico) this.mensaje="Usuario o Contraseña erroneos";
	    }
	}
        
        public void add(String nombre, String apellido, String correo, String password)
        {
			

			try
			{

				Connection con = DataConnetor.obtieneConexion(contexto);

				if(con!=null)
				{
					PreparedStatement ps = con.prepareStatement("insert productos values(?,?,?,?)");
					ps.setString(1,nombre);
					ps.setString(2,apellido);
                                        ps.setString(3, correo);
                                        ps.setString(4,password);
                                        ps.execute();
                                        this.nombre = nombre;
                                        this.apellido = apellido;
                                        this.user = correo;
                                        this.password=password;
					con.close();
				}
                        }
                        catch(Exception ex){
                                
                                ex.printStackTrace();
				mensaje = "Acción no realizada";
                                }
                        }


	public void reset()
	{
		user 	 = null;
		password = null;
		nombre   = null;
		mensaje  = "";
		autentico=false;
	}
        
        

	// Guarda el nombre del usuario en una Galleta

	public void guardaGalleta(HttpServletResponse response)
	{
		if(autentico && user!=null)
		{
			Cookie cookie=new Cookie("user",user);
			cookie.setMaxAge(3600);
			cookie.setComment("Cookie Creada desde el BEAN Autenticacion");
			cookie.setSecure(false);
			response.addCookie(cookie);
		}
	}

	// Recupera el nombre del usuario desde la galleta

	public String getCookie(HttpServletRequest request)
	{
		String nombreCookie = "user";
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			for(int i=0; i<cookies.length; i++)
			{
				Cookie cookie = cookies[i];
				if (nombreCookie.equals(cookie.getName()))
				{
					this.cookie = cookie.getValue();
					return(cookie.getValue());
				}
			}
		}
		return(null);
	}
}