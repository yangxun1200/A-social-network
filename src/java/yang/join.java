/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yang;

/**
 *
 * @author Xun
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "join", urlPatterns = {"/join"})
public class join extends HttpServlet {
    private Connection conn;
    private Statement st;
   //  private Statement st2;
    private ResultSet rs=null;
 //   private ResultSet rs2=null;
    boolean check=false;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String u=request.getParameter("host");
        PrintWriter out = response.getWriter();       
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/user";
            conn = DriverManager.getConnection(connectionURL, "yang", "19890914");
            st = conn.createStatement();
            
            String q = new String("update event set participants=participants+1 where host='"
                   + u+"'");
            st.execute(q);
            check=true;
        }
        catch( ClassNotFoundException cnfe)
        {
           System.err.println("A ClassNotFoundException was caught: " + cnfe.getMessage());
        }
        catch (SQLException se)
        {
             System.err.println("A SQLException was caught: " + se.getMessage());
        }
        if(check==true){
        out.println("<html>");
        out.println("<head>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" href=\"result.css\"> ");
        out.println("<title>join</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>You are in this event! See you there!</p>");
        out.println("<p><a href =\"event.jsp\">Back to event page</a></p>");
        out.println("<p><a href =\"index.jsp\">Log out</a></p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        }
        else{
        out.println("<html>");
        out.println("<head>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" href=\"result.css\"> ");
        out.println("<title>join</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>There are some unexpected error! Try again</p>");
        out.println("<p><a href =\"event.jsp\">Back to event page</a></p>");
        out.println("<p><a href =\"index.jsp\">Log out</a></p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}