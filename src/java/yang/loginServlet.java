/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yang;
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
import java.util.ArrayList;

/**
 *
 * @author Xun
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})

public class  loginServlet extends HttpServlet {
    public static String userid=null;
    private Connection conn;
    private Statement st;
    private ResultSet rs = null;
    private ResultSet rs2 = null;
    private ResultSet rs3 = null;
    private String check=null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(true);
        calebBean cb = new calebBean();
        session.setAttribute("cb",cb);
        ArrayList<String> a = new ArrayList<String>();
         session.setAttribute("myList", a);
    //    request.setAttribute("myList", a);
        Boolean valid = false;
        String p=request.getParameter("password");
        String u=request.getParameter("bbname");
        String uname=null;
        try{Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/user";
            conn = DriverManager.getConnection(connectionURL, "yang", "19890914");
            st = conn.createStatement();
            String q1 = new String("SELECT * FROM userinfo WHERE user_name = "+"'"+
                    u+"'");
            rs =  st.executeQuery(q1);
            while(rs.next()){          
                check = rs.getString("PASS");
                uname=rs.getString("name");
                valid=true;
            }
             String q2 = new String("SELECT N FROM NEWS " );                                                                         
            rs2 =  st.executeQuery(q2);
            while(rs2.next()){            
                a.add(rs2.getString("n"));
                a.add("<br />");
           
            }
           String q3 = new String("SELECT * FROM friends where guest= "+"'"+
                    u+"' and status='request'" );
           rs3 =  st.executeQuery(q3);
           if(rs3.next()){
               cb.setReminder("You have new friend request!<a href =\"seeRequest\">See all of your requests</a>");
           }
        }
        catch( ClassNotFoundException cnfe)
        {
            System.err.println("A ClassNotFoundException was caught: " + cnfe.getMessage());
        }
        catch (SQLException se)
        {          
            System.err.println("A SQLException was caught: " + se.getMessage()); 
        }
        if(request.getParameter("log")!=null){
         if(p.equals(check) && valid==true){    
            cb.setStatus("Login successfully! Pick up your Thanksgiving Meal");
            cb.setName(uname);
            cb.setId(u);
            userid=u;
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/second.jsp");        
            rd.forward(request, response);
            }
            else{
            cb.setStatus("Fail to log in, please try again!");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/JSP3.jsp");
            rd.forward(request, response);
            }
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
