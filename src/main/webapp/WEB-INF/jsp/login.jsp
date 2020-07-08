<%--
  Created by IntelliJ IDEA.
  User: Jacob
  Date: 2020/7/1
  Time: 03:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrator login</title>
    <script
            src="../../resources/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script
            src="../../resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet"
          href="../../resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid" style="height: 100%">
    <div class="well well-lg" style="top: 40%; position: relative; transform: translateY(-50%);padding: 50px; padding-top: 26px">
        <div class="container" style="width: 50%">
            <div class="text-center container-fluid" style="margin-bottom: 10px">
                <h3><strong>Login as administrator</strong></h3>
            </div>
            <form action="/admin" method="post">
                <div class="input-group input-group-lg" style="margin-bottom: 2%">
                <span class="input-group-addon">Username</span>
                <input class="form-control" type="text" name="username">
            </div>
                <div class="input-group input-group-lg">
                <span class="input-group-addon">Password</span>
                <input class="form-control" type="password" name="password">
                <span class="input-group-btn">
                    <input type="submit" class="btn btn-success" value="Login">
                </span>
            </div>
            </form>
            <div class="text-danger">${error}</div>
        </div>
    </div>
</div>
<div style="height: 5%"></div>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="admin">Login as admin</a></li>
        </ul>
    </div>
</nav>

</body>
</html>
