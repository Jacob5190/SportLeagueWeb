<%--
  Created by IntelliJ IDEA.
  User: Jacob
  Date: 2020/6/1
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calendar Admin</title>
    <meta charset="UTF-8">
    <script
            src="resources/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script
            src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet"
          href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script
            src="resources/dateTimePicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    <link rel="stylesheet"
          href="resources/dateTimePicker/css/bootstrap-datetimepicker.min.css">
</head>
<body>
    <div class="container" style="margin-top: 10px">
        <div class="jumbotron">
            <div class="input-group input-group-lg">
                <span class="input-group-addon">Date</span>
                <input class="datetimepicker-inline form-control" type="date" id="inputDate">
            </div>
            <div style="height: 2%"></div>
            <div class="input-group input-group-lg">
                <span class="input-group-addon">Event</span>
                <input class="form-control" type="text" id="inputEvent">
                <span class="input-group-btn">
                    <button class="btn btn-success" onclick="uploadEvent()">Confirm</button>
                </span>
            </div>
        </div>

    </div>
    <script>
        function uploadEvent() {
            var iDate = $("#inputDate").val();
            var iEvent = $("#inputEvent").val();
            $.ajax({
                url: "/eventUpload",
                type: "post",
                data: {
                    "date": iDate,
                    "title": iEvent
                },
                success: function () {
                    alert("Event uploaded successfully.");
                },
                error: function (err) {
                    console.log(err);
                }
            });
        }
    </script>
</body>
</html>
