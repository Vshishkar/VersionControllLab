<%--
  Created by IntelliJ IDEA.
  User: vshishkarov
  Date: 06.07.2018
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Repository</title>
</head>
<body>




    <form class="form-signin custom-sign-up-form" action="FrontController" method="post">

            <input name="command" value="create_rep" type="hidden"/>
            <h2 class="form-signin-heading">Please Enter Repository Title</h2>

            <label  class="sr-only" > Repository Title</label>
                <input name="repository_title" value=""  class="form-control" placeholder="Repository Title " required="" autofocus="">

            <button class="btn btn-lg btn-primary btn-block" type="submit" >Create Repository</button>
    </form>



    </body>
</html>
