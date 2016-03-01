<%-- 
    Document   : JSP3
    Created on : Nov 14, 2015, 11:36:21 AM
    Author     : Xun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="result.css"> 
        <title>JSP Page for failing log in</title>
    <jsp:useBean id="cb" class="yang.calebBean" scope="session" />
    </head>
    <body>
        <h2><jsp:getProperty name="cb" property="status" /></h2>
        <h2>Login</h2>
        <form method = "post" action="loginServlet" id="loginfrm">
            <input type="hidden" name="log" />
            <table border="1">
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="bbname" id="username" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" id="password" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="Login" value="Login" id="submit" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
         <BR/><BR/>
    <a href ="newaccount.jsp">Create a new account</a>
    </body>
</html>
