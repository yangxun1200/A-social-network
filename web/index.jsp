<%-- 
    Document   : index
    Created on : Dec 8, 2015, 3:14:34 PM
    Author     : Xun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="login.css"> 
        <title>Home Page</title>
    </head>
    <body>
        <span><img class="banner" src="http://www.socialknx.com/wp-content/uploads/2015/02/basketball-swish1.jpg?b4fa92" width="800" height="150"/> </span>
        <p>Grace. This simple app is for people who like playing basketball and they can add friends with each other (By sending request and give response)
            create or join events, such as a game that needs participants, post their breaking news, upload their profile picture, search friends..
            Log in with (<inline>Username:1,password:mbs</inline>), some users have sent you friend requests, you can choose accept or refuse them.
         You can also create an account and log in by using your account. When you create an account, we will harvest some information, such as 
         hobby, city,playing position in a basketball, etc. However, if you try to  create an account with a user name that has been used. You have to choose another user name.
           In "nutrition" choice in the app, the storage is offline by using local storage in javascript.
        </p>   
        <p>I spend most of my time on how to make the information consistent, such as when you have already added someone,
        it will tell you that he is already your friend. When a person decides to click on to go to an event, the number
        of participants will automatically increase 1, etc. However, there are still some flaws. </p>
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