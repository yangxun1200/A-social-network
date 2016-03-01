<%-- 
    Document   : discussion
    Created on : Dec 13, 2015, 1:05:32 AM
    Author     : Xun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="discussion.css"> 
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Discuss the fantastic skills we can use in a game</h1>
        <p> How can we improve the releasing rate of shooting?</p>
        <form>
        <textarea id="words" rows="10" cols="20"> </textarea>
        <input class="button" type="button" onclick="getwords()" value="Comment" /> <br>
        <p id="para"></p>
        </form>

    <script type="text/javascript">
    function getwords() {
    text = words.value;
    document.getElementById("para").innerHTML += '<p>'+text
    }
    </script>
    
   <p>
   <a href ="second.jsp">Back to home page</a>
   </p>
   <p>
   <a href ="index.jsp">Log out</a>
   </p>
   </body>
</html>
