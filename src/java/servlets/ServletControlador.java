package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.BeanProducto;

public class ServletControlador extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession ses=request.getSession(true);
        BeanProducto producto=(BeanProducto) ses.getAttribute("producto");
        
        if(producto==null){
            producto=new BeanProducto();
            ses.setAttribute("producto",producto);
        }
        
        String accion=request.getParameter("submit");
        String id=request.getParameter("id");
        String arbol=request.getParameter("arbol");
        String largo=request.getParameter("largo");
        String ancho=request.getParameter("ancho");
        String alto=request.getParameter("alto");
        String sprecio=request.getParameter("precio");
        String imagen=request.getParameter("imagen");
        float precio=0;
        
        if(sprecio!=null && !sprecio.equals("")){
            precio = Float.parseFloat(sprecio);
        }
        if(id==null){
            id="";
        }
        if(arbol==null){
            arbol="";
        }
        if(largo==null){
            largo="";
        }
        if(ancho==null){
            ancho="";
        }
        if(alto==null){
            alto="";
        }
        if(imagen==null){
            imagen="no_image.jpg";
        }
        
        if(accion.equals("Consulta")){
            
        }

    }
}