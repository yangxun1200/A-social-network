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

@WebServlet(name = "allMyFriend", urlPatterns = {"/allMyFriend"})
public class allMyFriend extends HttpServlet {
    private Connection conn;
    private Statement st;
    private ResultSet rs=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
         try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/user";
            conn = DriverManager.getConnection(connectionURL, "yang", "19890914");
            st = conn.createStatement();
            String q1 = new String("SELECT * FROM  userinfo, friends where userinfo.user_name=friends.guest and friends.host='"
                    +loginServlet.userid+"'"+"and friends.status='accept'");
         //  where id<>'"+loginServlet.userid+"'
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
        out.println("<link rel=\"stylesheet\" href=\"result.css\"> ");
        out.println("<title>Friend info</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Here are all of your current friends</h1>");
        out.println("<ul>");
       try{
           while(rs.next())
           {
         
             
             out.println("<td>"+rs.getString("name")+"</td>");
              out.println("<td>&nbsp hobby:</td>");
             out.println("<td>"+rs.getString("hobby")+"</td>");
         
             out.println("</tr>"+"</tbody>"+"</table>"+"</form>");
             out.println("<img width='60' height='60' src=displayphoto?id=" +  rs.getString("user_name") + "></img> <p/>");
           }
       }
       catch(SQLException sqle)
                 {
            System.err.println("A SQLException was caught: " + sqle.getMessage()); 
        }

        out.println("</ul>");
        out.println("<p>");
        out.println("<a href =\"second.jsp\">Back to your homepage</a>");
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
