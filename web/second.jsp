<%-- 
    Document   : index
    Created on : Dec 8, 2015, 1:50:36 PM
    Author     : Xun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="homepage.css"> 
        <title>JSP Page</title>
        <jsp:useBean id="cb" class="yang.calebBean" scope="session" />
    </head>
    <body>
       <span><img class="banner" src="http://www.clubsetup.com/sites/www.clubsetup.com/files/banner%20basketball%202.jpg" width="900" height="60"/> </span>
        <div class="global-nav-container">
    <ul class="first">
    <li class="logo" itemprop="name"><span class="brand-logo "><img src="http://www.thelegendssportscomplex.com/baskeball-logos/Legends%20Basketball%20logo%20(for%20Print).png" width="40" height="40"/></span>
     <br/>   <span id="top"><a href="second.jsp" >home</a></span>
     <span><a href="event.jsp" >Event</a></span>
     <span><a href="discussion.jsp" >Skill Discussion</a></span><span><a href="local.jsp">Nutrition</a></span><span><a href="store">Shopping</a></span>
     <span><select  class="select" onChange="window.location.href=this.value">
     <option value="second.jsp">Group</option>
     <option value="guard.jsp">Guard</option>
     <option value="forward.jsp">Forward</option>
     <option value="center.jsp">Center</option>
     </select>
     </span>
    </li>
    </ul>
    <br/>
        </div>
       <p class="comment">Black text are "reports". First, I think I was bluffing a little bit in my project proposal. I'm sorry.
           At that time, I don't even know servlet, so I did not know how to make some things happen, and bluffed in the proposal.:-).
           When someone else send you a friend request, you can see it below and go to respond it.
       I impersonate some users to send you a friend request.</p>
       <div class="welcome">
           Dear
        <jsp:getProperty name="cb" property="name" />,Welcome back!
       <jsp:getProperty name="cb" property="reminder" />
       <jsp:getProperty name="cb" property="reminder2" />
       </div>
       <br/>
       <form id="formupload" enctype="multipart/form-data" method="post"  action="addphoto" >
            <table>
                <tr>
                    <td>Add your profile picture  </td>
                    <td><input type="file"  name="photo" /></td>
                    <td> <input type="submit" value="Upload"/></td>
                </tr>
            </table>
            
        </form>
       <br/>
   
       <a href='showPhoto'>See my profile picture </a>
       <p class="comment"> I'm trying to allow user to change their profile, however, update is not allowed for "blob" type attribute in derby database...</p>
       <br/>
       <form method="post" action="search">
           <br/>
  Search your potential friend by city(pitt or pittsburgh, etc.)  or hobby (golf ? run ?) or your common basketball player idol (kobe,etc..):
  <input type="search" name="friendsearch">
  <input type="submit" value="Search!">
  </form>
       <p class="comment">See all the users and you can send them friend request below...(Sorry, I forgot to make a message to you
       when they accept you as their friends when I write the report to here.)</p>
       <form method="post" action="showall">
           <br/> 
  <input type="submit" value="Show all users and add some as your friends"/>
  </form>
       </form>
  <form method="post" action="allMyFriend">
           <br/> 
  <input class="form1" type="submit" value="See all my friends"/>
  </form>
    <p class="breaking">Breaking News</p>
    <div>
    ${sessionScope.myList}
        <c:forEach var="a" items="${sessionScope.myList}">
    <c:out value="${a}"/>
    </div>
    <br/> 
    <p><a href ="allNews">Click here to see all breaking news</a></p>
    <br/><br/>
    <form class="high" method="post" action="postNew">
     Tell others about your breaking news!
     <br/>
     <input class="news" type="text" name="news">
     <br/>
     <input type="submit" value="Post">
     </form>
    <p class="comment">After making a post, you have to click on "see all breaking news" to see your post. What I want to improve
    is that after you submit the post, the post will be just shown on the home page. Does it have to use AJAX to make it
    happy? I'm trying to learn AJAX or Jquery, however, a little late...</p>
    <p><a href ="index.jsp">Log out</a></p>
    <div><a href='#top'>Back to top</a></div>
    </body>
</html>
