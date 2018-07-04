<%--
  Created by IntelliJ IDEA.
  User: vshishkarov
  Date: 04.07.2018
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login </title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <link rel="stylesheet" href="style/style.css">

    </head>
<body>

    <form class="form-signin custom-sign-up-form" action="FrontController" method="post">

        <input name="command" value="login" type="hidden"/>
        <h2 class="form-signin-heading">Please sign up</h2>

        <label  class="sr-only" > Username</label>
        <input name="login" value="" id="inputUsername" class="form-control" placeholder="Username " required="" autofocus="">

        <label for="inputPassword" class="sr-only">Password</label>
        <input  name="password" value="" type="password" id="inputPassword" class="form-control" placeholder="Password" required="">

        <div class="checkbox">
            <label>
            <input type="checkbox" value="remember-me"> Remember me					          </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit" >Sign up</button>
     </form>






    </body>
</html>
