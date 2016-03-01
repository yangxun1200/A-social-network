<%-- 
    Document   : failCreate
    Created on : Nov 14, 2015, 5:26:33 PM
    Author     : Xun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="result.css"> 
        <title>Invalid information</title>
        <jsp:useBean id="cb" class="yang.calebBean" scope="session" />
    </head>
    <body>
        <h1><jsp:getProperty name="cb" property="status" /></h1>
        <h1>This user name has been used by someone else. Please use another user name</h1>
        <%
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/newaccount.jsp");
            rd.include(request, response);
 %>
    </body>
</html>
