<%-- 
    Document   : event
    Created on : Dec 13, 2015, 8:45:03 AM
    Author     : Xun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="event.css"> 
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create or see our basketball events!</h1>
        <jsp:useBean id="cb2" class="yang.calebBean" scope="session" />
        <p><jsp:getProperty name="cb2" property="reminder3" /></p>
        <h1>Create a new event</h1>
        <form method = "post" action="createEvent" id="c">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Event</td>
                        <td><input type="text" name="event" id="e" /></td>
                    </tr>
                    <tr>
                        <td>Location</td>
                        <td><input type="text" name="location" id="l" /></td>
                    </tr>
                    <tr>
                        <td>Time</td>
                        <td><input type="text" name="time" id="t" /></td>
                    </tr>
                    <tr>
                        <td>Current number of participants</td>
                        <td><input type="text" name="par" id="n" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="submit" value="create" id="submit" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
     <br/>
     <a href ="allEvents">Show me all the events</a>
     <br/>
    <a href ="second.jsp">Back to home page</a>
    <br/>
    <a href ="index.jsp">Log out</a>
    </body>
</html>