<%--
  Created by IntelliJ IDEA.
  User: Jacob
  Date: 2020/6/29
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Documents Admin</title>
    <script
            src="../../resources/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script
            src="../../resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet"
          href="../../resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <style>
        .jumbotron .input-group{
            padding: 10px;
            margin: 10px;
        }
    </style>

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
                <li><a href="/admin/calendar">Calendar Admin</a></li>
                <li><a href="competition">Competitions</a></li>
                <li class="active"><a href="#">Documents Admin</a></li>
                <li><a href="/admin/gallery">Gallery Admin</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" style="margin-top: 10px">
    <div class="jumbotron">
        <div class="input-group input-group-lg">
            <span class="input-group-addon">Upload File</span>
            <input type="file" name="document" id="file" class="form-control" accept=".pdf, .docx">
            <span class="input-group-btn">
                <button value="Upload" onclick="uploadDocs()" class="btn btn-success">Upload</button>
            </span>
        </div>

        <div class="input-group input-group-lg">
            <span class="input-group-addon">Delete File</span>
            <select id="docSelect" class="form-control">
            </select>
            <span class="input-group-btn">
                <button onclick="delDoc()" class="btn btn-danger">Delete</button>
            </span>
        </div>
    </div>
</div>
<script>
    function uploadDocs() {
        var params = new FormData();
        var files = $("#file")[0].files;
        params.append("document", files[0]);
        $.ajax({
            url: "/docUpload",
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            data: params,
            success: function () {
                alert("File Upload successfully");
                getDocs();
            }
        });
    }

    function delDoc() {
        if (confirm("Do you want to delete this document?")) {
            const option = $("#docSelect option:selected");
            const optVal = option.val();
            $.ajax({
                url: "delDoc",
                data: {"option": optVal},
                type: "post",
                success: function () {
                    alert("Document delete successfully.");
                    location.reload();
                },
                error: function (error) {
                    console.log(error)
                }
            })
        }
    }

    function getDocs() {
        $.ajax({
            url: "reqDocs",
            success: function (data) {
                var docs = JSON.parse(data);
                var opt = "";
                for (i = 0; i < docs.length; i++) {
                    opt += "<option value='" + docs[i] + "'>" + docs[i] + "</option>\n";
                }
                $("#docSelect").html(opt);
            },
            error: function (err){
                console.log(err);
            },
            type: "get"
        });
    }

    window.onload = getDocs();
</script>
</body>
</html>
