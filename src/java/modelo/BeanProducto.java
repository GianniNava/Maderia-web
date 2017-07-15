package modelo;

import java.sql.*;
import javax.servlet.ServletContext;

public class BeanProducto {
    private int id=0;
    private String arbol="";
    private double largo=0.00;
    private double ancho=0.00;
    private double alto=0.00;
    private double precio=0.00;
    private String imagen="";
    private ServletContext contexto;

    //gets
    
    public int getId() {
        return id;
    }

    public String getArbol() {
        return arbol;
    }

    public double getLargo() {
        return largo;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    public double getPrecio() {
        return precio;
    }

    public String getImagen() {
        return imagen;
    }

    public ServletContext getContexto() {
        return contexto;
    }

    //sets
    
    public void setId(int id) {
        this.id = id;
    }

    public void setArbol(String arbol) {
        this.arbol = arbol;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setContexto(ServletContext contexto) {
        this.contexto = contexto;
    }
    
    public String[][] readAll(){
        try{
	    Connection con = DataConnetor.obtieneConexion(contexto);
	    if(con != null){
		Statement st = con.createStatement();
		st.executeQuery("select * from producto order by id_producto");
		ResultSet rs = st.getResultSet();
		String[][] data = null;
		if(rs.next()){
   		    rs.last();
	            int rows = rs.getRow();
		    if(rows > 0){
			data = new String[rows][6];
			rs.beforeFirst();
			rows=0;
			while(rs.next()){
			    data[rows][0] = rs.getString("id");
			    data[rows][1] = rs.getString("arbol");
			    data[rows][2] = rs.getString("largo");
			    data[rows][3] = rs.getString("ancho");
                            data[rows][4] = rs.getString("alto");
                            data[rows][5] = rs.getString("precio");
                            data[rows][6] = rs.getString("imagen");
                            rows++;
			}
		    }
                }
		con.close();
		return data;
	    }
	}
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
