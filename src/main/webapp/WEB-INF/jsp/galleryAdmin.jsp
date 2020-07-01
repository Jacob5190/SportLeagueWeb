<%--
  Created by IntelliJ IDEA.
  User: Jacob
  Date: 2020/5/28
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image Upload</title>
    <script
            src="../../resources/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script
            src="../../resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet"
          href="../../resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script>
        function getImgs() {
            $.ajax({
                url: "/reqImgs",
                success: function (data) {
                    var imgArr = $.parseJSON(data);
                    var opt = "";
                    for (i = 0; i < imgArr.length; i++) {
                        opt += "<option value='" + imgArr[i] + "'>" + imgArr[i] + "</option>\n";
                    }
                    $("#imgSelect").html(opt);
                },
                error: function (err){
                    console.log(err)
                },
                type: "get",
                dataType: "text"
            })
        }
        function delImgs() {
            if (confirm("Do you want to delete this image from the gallery?")){
                const option = $("#imgSelect option:selected");
                const optVal = option.val();
                $.ajax({
                    url: "/imgDelete",
                    data: {"option": optVal},
                    type: "post",
                    success: function () {
                        alert("File delete successfully.");
                        location.reload();
                    },
                    error: function (error) {
                        console.log(error)
                    }
                })
            }
        }
        window.onload = getImgs();
    </script>
    <style>
        .jumbotron .input-group{
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
                <li><a href="/admin/documents">Documents Admin</a></li>
                <li class="active"><a href="#">Gallery Admin</a></li>
            </ul>
        </div>
    </div>
</nav>
<div style="padding-top: 1%"></div>
<div class="container" style="margin-top: 10px">
    <div class="jumbotron">
        <div class="input-group input-group-lg">
            <span class="input-group-addon">Upload File</span>
            <input type="file" name="picture" id="file" class="form-control" accept="image/*">
            <span class="input-group-btn">
                <button value="Upload" onclick="uploadPics()" class="btn btn-success">Upload</button>
            </span>
        </div>

        <ul class="nav nav-list"><li class="divider"></li></ul>
        <div class="input-group input-group-lg">
            <span class="input-group-addon">Delete File</span>
            <select id="imgSelect" class="form-control">
            </select>
            <span class="input-group-btn">
                <button onclick="delImgs()" class="btn btn-danger">Delete</button>
            </span>
        </div>
    </div>
</div>
<script>
    function uploadPics() {
        var params = new FormData();
        var files = $("#file")[0].files;
        params.append("picture", files[0]);
        $.ajax({
            url: "/imgUpload",
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            data: params,
            success: function () {
                alert("File Upload successfully");
                getImgs();
            }
        });
    }
</script>
</body>
</html>
