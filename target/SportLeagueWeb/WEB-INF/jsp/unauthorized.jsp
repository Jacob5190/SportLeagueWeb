<%--
  Created by IntelliJ IDEA.
  User: Jacob
  Date: 2020/7/5
  Time: 02:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<div class="container">
    Unauthorized access: ${ex.message}
    <br />
    <a href="#" onClick="history.back()">Return</a>
</div>
