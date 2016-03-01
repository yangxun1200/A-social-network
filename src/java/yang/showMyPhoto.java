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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "showMyPhoto", urlPatterns = {"/showPhoto"})

public class showMyPhoto extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");     
        out.println("<head>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" href=\"result.css\"> ");
        out.println("<title>Show my photo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>My profile:</h1>");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/user", "yang", "19890914");
            PreparedStatement ps = con.prepareStatement("select * from photo2 where id="+"'"+
                   loginServlet.userid +"'");
            ResultSet rs = ps.executeQuery();
            
            while ( rs.next()) {                                             
                  out.println("<img width='60' height='60' src=displayphoto?id=" +  rs.getString("id") + "></img> <p/>");
         
            }
            con.close();
        }
        catch(Exception ex) {
            System.err.println("A ClassNotFoundException was caught: " + ex.getMessage());
        }
         out.println(" <p> <a href='second.jsp'>Back to home page</a> </p>");
         out.println(" <p> <a href='index.jsp'>Log out </a> </p>");
         out.println("</body>");
         out.println("</html>");
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}
