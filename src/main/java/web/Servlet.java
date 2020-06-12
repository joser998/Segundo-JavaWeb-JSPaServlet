package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet") //Esta es el nombre con el que la pagina web o el JSP va a encontrar este Servlet
public class Servlet extends HttpServlet{
    /*Metodo do-Post en el que seran enviados mediante protocolo Http*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Leer los parametros del formulario HTML - de los campos de texto de usuario y contraseña
        String usuario = request.getParameter("Usuario");//-Recuperamos el valor que mandamos del HTML, del input text usuario
        String password = request.getParameter("Password");//--Recuperamos el valor Password del HTML, del campo de texto
        
        /*Mandamos a imprimir los valores guardados en  usuario, password. Esto es unicamente informativo y se imprimen
          del lado del servidor glassfish mas no del cliente (usuario), por lo tanto esto solo lo podriamos ver nosotros.
        */
        System.out.println("Usuario = "+usuario);
        System.out.println("Password = "+password);
            
        /*Mediante este objeto "PrintWriter" podemos imprimir con codigo HTML para quel cliente vea los valores de 
            usuario y contraseña*/
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("El parametro del Usuario es: "+usuario);
        out.print("<br/>");
        out.print("El parametro del Password es: "+password);
        out.print("<br/>");
        out.print("</body>");
        out.print("</html>");
    }
}