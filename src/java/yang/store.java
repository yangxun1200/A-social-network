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
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "store", urlPatterns = {"/store"})
public class store extends HttpServlet {
    private Connection conn;
    private Statement st;
    private ResultSet rs=null;
    boolean check=false;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();       
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/user";
            conn = DriverManager.getConnection(connectionURL, "yang", "19890914");
            st = conn.createStatement();
            String q1 = new String("SELECT * FROM store");
            rs =  st.executeQuery(q1);
        }
        catch( ClassNotFoundException cnfe)
        {
           System.err.println("A ClassNotFoundException was caught: " + cnfe.getMessage());
        }
        catch (SQLException se)
        {
             System.err.println("A SQLException was caught: " + se.getMessage());
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" href=\"store.css\"> ");        
        out.println("<title>Store</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>We are still seeking for sprots goods sponsors for this network community, more products are on the way....In the next semester, it might be implemented in E-commerce class...</h1>");
        out.println("<table border=\"1\">"+"<tbody>"+"<tr>");
        out.println("<td>Brand</td>");
        out.println("<td>Product</td>");
        out.println("<td>Price</td>");
        
       try{
           while(rs.next())
           {
             out.println("</tr>");
             out.println("<tr>");            
             out.println("<td>"+rs.getString("host")+"</td>");
             out.println("<td>"+rs.getString("product")+"</td>");
             out.println("<td>"+rs.getLong("price")+"</td>");     
             out.println("<td><input type=\"hidden\" name=\"host\" id=\"host\" value=\""+rs.getString("host")+"\"/>"+"</td>");                                                               
           }
       }
       
       catch(SQLException sqle)
                 {
            System.err.println("A SQLException was caught: " + sqle.getMessage()); 
        }
        out.println("</tr>"+"</tbody>"+"</table>"+"</form>");
        out.println("<p>");
        out.println("<a href =\"second.jsp\">Back to home page</a>");
        out.println("</p>");
        out.println("<p>");
        out.println("<a href =\"index.jsp\">Log out</a>");
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
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