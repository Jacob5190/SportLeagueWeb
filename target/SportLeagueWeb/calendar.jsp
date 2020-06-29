<%--
  Created by IntelliJ IDEA.
  User: Jacob
  Date: 2020/6/1
  Time: 08:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calendar</title>
    <meta charset="UTF-8">
    <script
            src="resources/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script
            src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet"
          href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link href='resources/simpleCalendar/stylesheets/fullcalendar.print.min.css' rel='stylesheet' media='print' />
    <link rel='stylesheet'
          href='resources/simpleCalendar/stylesheets/fullcalendar.min.css'>
    <link rel='stylesheet'
          href='resources/simpleCalendar/stylesheets/semantic.min.css'>
    <script
            src='resources/simpleCalendar/javascript/semantic.min.js'></script>
    <script
            src='resources/simpleCalendar/javascript/jquery.min.js'></script>
    <script
            src='resources/simpleCalendar/javascript/moment.min.js'></script>
    <script
            src='resources/simpleCalendar/javascript/fullcalendar.min.js'></script>
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
            <a href="#"><img src="resources/images/home/circle-cropped.png" alt="ISL" class="navbar-brand center-block" style="padding: 3px 30px 3px 3px"></a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="">Home</a></li>
                <li class="active"><a href="#">Calendar</a></li>
                <li><a href="competition">Competitions</a></li>
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
<div style="padding-top: 1%"></div>
<div class="row well well-lg">
    <div class="container col-md-3"></div>
    <div class="container col-md-6">
        <div id="calendar"></div>
        <script>
            var day1 = new Date();
            day1.setDate(day1.getDate());
            var s1 = day1.getFullYear()+"-" + (day1.getMonth()+1) + "-" + day1.getDate();
            $(document).ready(function() {
                $('#calendar').fullCalendar({
                    header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'month,basicWeek,basicDay'
                    },
                    defaultDate: s1,
                    navLinks: true, // can click day/week names to navigate views
                    editable: false,
                    eventLimit: true, // allow "more" link when too many events
                    events: <%=request.getAttribute("calendar_events")%>
                });
            });
        </script>
    </div>
</div>
</body>
</html>
