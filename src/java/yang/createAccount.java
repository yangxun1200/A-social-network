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

/**
 *
 * @author Xun
 */
@WebServlet(name = "createAccount", urlPatterns = {"/createAccount"})
public class createAccount extends HttpServlet {
    private Connection conn;
    private Statement st;
     private Statement st2;
    private ResultSet rs = null;
    private ResultSet rs2 = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(true);
        calebBean cb = new calebBean();
        session.setAttribute("cb",cb);
        Boolean valid = false;
        Boolean check=false;
        String p=request.getParameter("password");
        String u=request.getParameter("bbname");
        String f=request.getParameter("fname");
        String h=request.getParameter("hobby");
        String g=request.getParameter("gender");
        String city=request.getParameter("city");
        String state=request.getParameter("state");
        String position=request.getParameter("position");
        String idol=request.getParameter("idol");
        try{Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/user";
            conn = DriverManager.getConnection(connectionURL, "yang", "19890914");
            st = conn.createStatement();
             st2= conn.createStatement();
            String q1 = new String("SELECT * FROM userinfo WHERE user_name = "+"'"+
                    u+"'");
            rs =  st.executeQuery(q1);
            while(rs.next()){          
                check = true;
       
            }
            if(check==false){
                String q2 = new String("insert into userinfo(user_name, name, pass,hobby,gender,city,state,position,idol)"
                        +" values ("+"'"+u+"'"+","+"'"+f+"'"+","+"'"+p+"'"+","+"'"+h+"'"+","+"'"+g+"'"+","+"'"+city+"'"+
                        ","+"'"+state+"'"+","+"'"+position+"'"+","+"'"+idol+"'"+")"); 
                 st2= conn.createStatement();
                 st2.execute(q2);         
                 valid=true;
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
        if(valid==true){    
            cb.setStatus("Create SUCCESS");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/successCreate.jsp");
            rd.forward(request, response);
            }
            else{
           cb.setStatus("FAILURE Create");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/failCreate.jsp");
            rd.forward(request, response);
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

