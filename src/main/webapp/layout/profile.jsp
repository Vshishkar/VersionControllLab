    <%@ page import="by.tc.vcl.entity.user.User" %><%--
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

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <link rel="stylesheet" href="style/style.css">

        <script src="jquery-3.3.1.min.js"></script>
</head>

<body>

        <jsp:include page="/layout/navbar.jsp"></jsp:include>


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

        <div class="profile-container">

            <div class="profile-info">
                <div class="card" style="width: 18rem;">
                        <img class="card-img-top" src="static/img/no_avatar.png" alt="Card image cap">
                        <div class="user-info">
                            <p class="lead"> Weclome back <%=username%></p>
                            <p class="lead"> Lorem ipsum</p>
                        </div>
                </div>

            </div>

            <div class="repository-container">

                <div class="repository-bar">

                    <p class="lead"> List of repositories</p>


        <form class="form-inline mt-2 mt-md-0">
            <a href="create_rep" class="btn btn-outline-success" role="button" aria-pressed="true">Create repository</a>
        </form>


                </div>

                <div class="repository-list">

                    <ul>
                        <li>
                             <div class="repository-list-item">
        consectetur adipiscing elit. Proin molestie maximus erat sed molestie. Morbi cursus lectus eu turpis luctus feugiat. Vivamus sollicitudin enim euismod neque elementum, tempor bibendum nisl venenatis. Morbi velit nulla, finibus vitae tempus varius, volutpat sed diam. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam arcu turpis, aliquam vitae risus at, pulvinar porttitor sem. Phasellus facilisis tristique ligula et porta. Fusce sapien justo, commodo at sapien vitae, tristique cursus tortor. Donec gravida sagittis risus sit amet sollicitudin. Aliquam eget est quis purus dapibus feugiat a pellentesque lacus.
        Vivamus fringilla sodales massa, non facilisis orci.
        Aenean id elit et diam auctor maximus quis vitae nisl.
                              </div>
                        </li>
                        <li>
                            <div class="repository-list-item">
                                consectetur adipiscing elit. Proin molestie maximus erat sed molestie. Morbi cursus lectus eu turpis luctus feugiat. Vivamus sollicitudin enim euismod neque elementum, tempor bibendum nisl venenatis. Morbi velit nulla, finibus vitae tempus varius, volutpat sed diam. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam arcu turpis, aliquam vitae risus at, pulvinar porttitor sem. Phasellus facilisis tristique ligula et porta. Fusce sapien justo, commodo at sapien vitae, tristique cursus tortor. Donec gravida sagittis risus sit amet sollicitudin. Aliquam eget est quis purus dapibus feugiat a pellentesque lacus.
                                Vivamus fringilla sodales massa, non facilisis orci.
                                Aenean id elit et diam auctor maximus quis vitae nisl.
                            </div>
                         </li>
                    </ul>

                </div>

            </div>
        </div>


        <script rel="script" src="js/profilePageAjax.js" ></script>

    </body>
</html>
