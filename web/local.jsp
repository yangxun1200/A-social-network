<%-- 
    Document   : local
    Created on : Dec 11, 2015, 9:38:15 AM
    Author     : Xun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel=\"stylesheet\" href="local.css">
        <script>
            function CheckBrowser() {
    if ('localStorage' in window && window['localStorage'] !== null) {
        // use localStorage object to store data
        return true;
    } else {
             return false;
    }
}
function ShowAll() {

if (CheckBrowser()) {
        var key = "";
        var list = "<tr><th>Recipe</th><th></th><th>Reason</th></tr>\n";
        var i = 0;
        for (i = 0; i <= localStorage.length - 1; i++) {
            key = localStorage.key(i);
            list += "<tr><td>" + key + "</td>\n<td></td><td>"
                    + localStorage.getItem(key) + "</td></tr>\n";
        }
        if (list === "<tr><th>Recipe</th><th>Reason</th></tr>\n") {
            list += "<tr><td><i>Make some nutrition suggestion</i></td>\n\n\n\n\n<td><i>Reason</i></td></tr>\n";
        }
        document.getElementById('list').innerHTML = list;
    } else {
        alert('Cannot store user preferences as your browser do not support local storage');
    }
    }
    function Save() {
    var name = document.forms.ShoppingList.name.value;
    var data = document.forms.ShoppingList.data.value;
    localStorage.setItem(name, data);
    ShowAll();  
}
function Modify() {
    var name = document.forms.ShoppingList.name.value;
    document.forms.ShoppingList.data.value = localStorage.getItem(name);
    ShowAll();
}
function Remove() {
    var name = document.forms.ShoppingList.name.value;
    document.forms.ShoppingList.data.value = localStorage.removeItem(name);
    ShowAll();
}
function ClearAll() {
    localStorage.clear();
    ShowAll();
}



                   </script>
<link rel="stylesheet" href="localstorage.css">

        <title>JSP Page</title>
    </head>
    <body onload="ShowAll()">
        <h1>See the nutrition recipe even if you are offline</h1>
        <div id="PlayArea">
            <form id="ShoppingList">
      <table>
            <tr>
                 <td><b>Recipe</b><input type=text name=name></td>
                 <td><b>Reason:</b><input type=text name=data></td>
             </tr>
             <tr>
                    <td>
                        <input type=button value="Save"   onclick="Save()">
                        <input type=button value="Modify" onclick="Modify()">
                        <input type=button value="Remove" onclick="Remove()">
                     </td>      
             </tr>
        </table>
                </form>
            <table id="list">                 
            </table>
            <input type=button value="Clear" onclick="ClearAll()">

</div>
        <br/>
    <a href ="second.jsp">Back to home page</a>
    <br/>
    <br/>
    <a href ="index.jsp">Log out</a>
    </body>
</html>
