
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author djeny
 */
// une annotation qui relie une url a ce setvlet(mappe) à l'url "/UserServlet" 
  //@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
      
      

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
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
      // recuperer les données
         String nom = request.getParameter("nom");
         String prenom = request.getParameter("prenom");
         String email = request.getParameter("email");
       // processRequest(request, response);
       
      // validation des données
        
        if(nom==null || nom.trim().isEmpty() || prenom==null || prenom.trim().isEmpty()
                || email==null || email.trim().isEmpty()){
            //request.setAttribute("Erreur", "Tous les champs sont obligatioirs");
            //request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
      //création d'un objet
        User user=new User(nom, prenom, email);
       
      /* on va créer et recuperer une session d'un user 
        et le stocker dans une list user
        */
      HttpSession session= request.getSession();
      
       //on va stocker l'utilisateur dans la session
        session.setAttribute("utilisateur", user);
      
      List<User> userlist = (List<User>) session.getAttribute("users");
      if(userlist==null){
          userlist= new ArrayList<>();
     }     
        userlist.add(user);
        session.setAttribute("users", userlist);
        
     // redirection vers la page userDetail.jsp
        response.sendRedirect("userDetails.jsp");
      
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
