<%--
  Created by IntelliJ IDEA.
  User: Jacob
  Date: 2020/6/29
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Documents</title>
    <script
            src="../../resources/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script
            src="../../resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet"
          href="../../resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-default" style="font-size: large">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/"><img src="../../resources/images/home/circle-cropped.png" alt="ISL" class="navbar-brand center-block" style="padding: 3px 30px 3px 3px"></a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="/">Home</a></li>
                <li><a href="calendar">Calendar</a></li>
                <li><a href="competition">Competitions</a></li>
                <li class="active"><a href="#">Documents</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        Member schools
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">School 1</a></li>
                        <li><a href="#">School 2</a></li>
                        <li><a href="#">School 3</a></li>
                        <li><a href="#">School 4</a></li>
                        <li><a href="#">School 5</a></li>
                        <li><a href="#">School 6</a></li>
                    </ul>
                </li>
                <li><a href="gallery">Gallery</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="contact">Contact us</a></li>
            </ul>
        </div>
    </div>
</nav>
<div style="margin-top: 1%"></div>
<div class="well well-lg">
    <div class="container">
    <ul style="font-size: 1.4em">
        <%!int length;String[] path;String fileName;%>
        <%
            length = (int) request.getAttribute("length");
            path = new String[length];
            for (int i = 0; i < length; i++){
                path[i] = request.getAttribute("filePath"+i).toString();
                fileName = path[i].substring(path[i].indexOf("\\") + 1);
                out.println("<li><a href=\""+ path[i] +"\">"+fileName+"</a></li>");
            }
        %>
    </ul>
</div>
</div>
<div style="height: 5%"></div>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <p class="navbar-text navbar-left" id="userNameText">Login as: ${sessionScope.userName}</p>
        <ul class="nav navbar-nav navbar-right">
            <li><a id="adminLink"></a></li>
        </ul>
    </div>
</nav>
<script>
    function adminLink() {
        if ("" === "${sessionScope.userName}") {
            $("#userNameText").hide();
            $("#adminLink").attr("href", "admin");
            $("#adminLink").html("Login as admin")
        }else {
            $("#adminLink").attr("href", "admin/calendar");
            $("#adminLink").html("Admin page")
        }
    }
    window.onload = adminLink();
</script>
</body>
</html>
