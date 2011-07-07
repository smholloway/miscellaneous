<%@ page import="java.util.*,java.text.*" %>
<%! static String staticDirX = ""; 
    static String staticDirY = ""; %>
<%
 String directionX = request.getParameter("dirX");
 String directionY = request.getParameter("dirY");
 if ( directionX == null  ) {
   directionX = staticDirX;
 } else {
   staticDirX = directionX;
 }
 if ( directionY == null  ) {
   directionY = staticDirY;
 } else {
   staticDirY = directionY;
 }
 session.setAttribute("dirX", directionX);
 session.setAttribute("dirY", directionY);
%>

<html>
 <head>
  <title>
   Project MovaRoomba Web Application
  </title>
  <style type="text/css" title="currentStyle" media="screen">
   @import "style.css";
  </style>
  </script>
 </head>

 <body>
  <%= new java.util.Date().toString() %> <br/>
  You are accessing this page from <% out.println(request.getRemoteHost()); %> <br/>
  <br/>
  <br/>
  <div class="formContent">
   Roomba, move <%= session.getAttribute("dirX") %> in X and <%= session.getAttribute("dirY") %> in Y!<br/>
   <br/>
   <form action="roomba.jsp" method="post">
    Direction:
    <input type="text" size="5" name="dirX" value="<%= session.getAttribute("dirX").toString() %>"/>
    <input type="text" size="5" name="dirY" value="<%= session.getAttribute("dirY").toString() %>"/>
    <input type="submit" value="Submit" />
   </form>
   <a href="">home</a> <a href="">refresh</a>
  </div>
 </body>
</html>
