    <%@ page import="by.tc.vcl.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: vshishkarov
  Date: 03.07.2018
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
</head>
<body>

    <% User user = (User) request.getSession().getAttribute("user");
        String username;
        if(user != null) {
             username = user.getLogin();
             String email = user.getEmail();
        }
        else {
           username  = "User";
        }
        %>
        <p> Weclome back <%=username%></p>


    </body>
</html>
