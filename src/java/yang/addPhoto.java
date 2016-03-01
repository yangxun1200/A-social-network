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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "addPhoto", urlPatterns = {"/addphoto"})
public class addPhoto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
        out.println("<h1>Message:</h1>");
        try {
            // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu  = new ServletFileUpload(factory);
 
            if (! ServletFileUpload.isMultipartContent(request)) {
                System.out.println("sorry. No file uploaded");
                return;
            }
            // parse request
            List items = sfu.parseRequest(request);
            FileItem file = (FileItem) items.get(0);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/user", "yang", "19890914");
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement("insert into photo2 values(?,?)");        
            ps.setString(1, loginServlet.userid);
            // size must be converted to int otherwise it results in error
            ps.setBinaryStream(2, file.getInputStream(), (int) file.getSize());
            ps.executeUpdate();
            con.commit();
            con.close();
            out.println("Photo Added Successfully. <p> <a href='showPhoto'>See my profile picture </a> </p>");
            
        }
        catch(Exception ex) {
            System.err.println("A ClassNotFoundException was caught: " + ex.getMessage());
        }
        out.println("<p> <a href='second.jsp'>Back to home page</a> </p>");
        out.println("<p> <a href='index.jsp'>Log out </a> </p>");
    } 
}
