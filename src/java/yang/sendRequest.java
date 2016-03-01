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

@WebServlet(name = "sendRequest", urlPatterns = {"/sendRequest"})
public class sendRequest extends HttpServlet {
    private Connection conn;
    private Statement st;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(true);
        calebBean cb = new calebBean();
        session.setAttribute("cb",cb);
        Boolean valid = false;
        String u=request.getParameter("bbname");
        String f=request.getParameter("friend");
        try{Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/user";
            conn = DriverManager.getConnection(connectionURL, "yang", "19890914");
            st = conn.createStatement();            
                String q = new String("insert into friends (host, guest,status)"+" values ("+"'"+
                    u+"'"+","+"'"+f+"'"+","+"'request')");                       
                 st.execute(q);             
                 valid=true;
            }
       
        catch( ClassNotFoundException cnfe)
        {
            System.err.println("A ClassNotFoundException was caught: " + cnfe.getMessage());
        }
        catch (SQLException se)
        {
        System.err.println("A SQLException was caught: " + se.getMessage()); 
        }
        if(valid==true){
            out.println("<html>");
        out.println("<head>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" href=\"result.css\"> ");
        out.println("<title>Success</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Request has been sent!</h1>");
        out.println("<p>");
        out.println("<a href =\"second.jsp\">Back to homepage</a>");  
        out.println("</p>");
        out.println("<p>");
        out.println("<a href =\"index.jsp\">Log out</a>");
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");   
            }
            else{
        out.println("<html>");
        out.println("<head>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" href=\"result.css\"> ");
        out.println("<title>Fail</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Error: you have already reserved the meal!</h1>");
        out.println("<p>");
        out.println("<a href =\"second.jsp\">Back to homepage</a>");
        out.println("</p>");
        out.println("<p>");
        out.println("<a href =\"index.jsp\">Log out</a>");
        out.println("</p>");
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
