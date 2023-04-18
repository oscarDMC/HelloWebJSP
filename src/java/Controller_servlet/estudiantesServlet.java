package Controller_servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ddav_
 */
@WebServlet(name = "estudiantesServlet", urlPatterns = {"/estudiantesServlet"})
public class estudiantesServlet extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
               
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        LocalTime horaActual = LocalTime.now();
        String horas = "";
        String saludo = "";
        int hora = horaActual.getHour();    
        if (hora >= 12 && hora < 18) {
            saludo = "Buenas tardes, ";
            horas = ", de la tarde";
        }else if (hora >= 18 && hora <= 24) {
            saludo = "Buenas noches, ";
            horas = ", de la noche";
        }else if(hora >= 0  && hora < 12){
            saludo = "Buen días, ";
            horas = ", del dia";
        }
        
        LocalTime horaHM = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
        String horaahm = horaHM.format(formatter);
                
        String fechaNacimientoStr = request.getParameter("yearnacimiento");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int edad = periodo.getYears();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>HelloWeb!</title>");
            out.println("<style>");
            out.println("body {");
            out.println("   font-family: Arial, Helvetica, sans-serif;");
            out.println("   text-align: center;");
            out.println("}");
            out.println("h1 {");
            out.println("   font-size: 3em;");
            out.println("   margin-top: 50px;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");      
            out.println("<h1>"+ saludo + "  " + nombre +"  "+ apellido + "! </h1>");                   
            out.println("<h1>Tu edad es: "  + edad + " años!  </h1>");
            out.println("<h1>Son las: "  +horaahm+ " "+ horas + " :) </h1>");        
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
