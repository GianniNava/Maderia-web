package modelo;

import java.sql.*;
import javax.servlet.ServletContext;

public class DataConnetor {
    public static Connection obtieneConexion(ServletContext contexto){
        Connection con=null;
        try{
            String mySQLHost = contexto.getInitParameter("mySQLHost");
            String dbName = contexto.getInitParameter("dbName");
            String user = contexto.getInitParameter("user");
            String password = contexto.getInitParameter("password");
			
            Class.forName("org.mariadb.jdbc.Driver");
            String urlBD = mySQLHost + dbName+ "?user=" + user + "&password=" + password;
            con = DriverManager.getConnection(urlBD);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
