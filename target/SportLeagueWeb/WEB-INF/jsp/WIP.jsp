<%--
  Created by IntelliJ IDEA.
  User: Jacob
  Date: 2020/7/10
  Time: 02:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Work in progress</title>
    <script
            src="../../resources/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script
            src="../../resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet"
          href="../../resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="icon" href="${pageContext.request.contextPath }/resources/favicon.ico">
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
            <a href="#"><img src="../../resources/images/home/circle-cropped.png" alt="ISL" class="navbar-brand center-block" style="padding: 3px 30px 3px 3px"></a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="/">Home</a></li>
                <li><a href="calendar">Calendar</a></li>
                <li class="active"><a href="#">Competitions</a></li>
                <li><a href="documents">Documents</a></li>
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
    <div class="container jumbotron">
        <div class="text-info">
            <p>Hi there!</p>
            <p>This page is currently working in progress</p>
            <p>Please <a href="#" onclick="history.back();">click here</a> to go back</p>
        </div>
    </div>
</body>
</html>
