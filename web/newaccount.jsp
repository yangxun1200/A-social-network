<%-- 
    Document   : newaccount
    Created on : Dec 13, 2015, 9:10:18 AM
    Author     : Xun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="result.css"> 
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Dear, fill out the form to create a new account!</h1>
        <form method = "post" action="createAccount" id="c">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="bbname" id="username" /></td>
                    </tr>
                    <tr>
                        <td>Your Real Full name</td>
                        <td><input type="text" name="fname" id="realname" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" id="password" /></td>
                    </tr>
                    <tr>
                        <td>gender</td>
                        <td><input type="text" name="gender" id="gender" /></td>
                    </tr>
                    <tr>
                        <td>hobby</td>
                        <td><input type="text" name="hobby" id="hobby" /></td>
                    </tr>
                    <tr>
                        <td>city</td>
                        <td><input type="text" name="city" id="city" /></td>
                    </tr>
                    <tr>
                        <td>state</td>
                        <td><input type="text" name="state" id="state" /></td>
                    </tr>
                    <tr>
                        <td>Playing position</td>
                        <td><input type="text" name="position" id="position" /></td>
                    </tr>
                    <tr>
                        <td>your basketball idol</td>
                        <td><input type="text" name="idol" id="idol" /></td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td><input type="submit" name="submit" value="create" id="submit" /></td>
                    </tr>
                </tbody>
            </table>
            <p><a href ="index.jsp">Back to login page</a></p>
        </form>
    </body>
</html>
