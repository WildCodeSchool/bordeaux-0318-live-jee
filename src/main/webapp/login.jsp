<%--
  Created by IntelliJ IDEA.
  User: fabien
  Date: 16/04/18
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" enctype="application/x-www-form-urlencoded" method="post">
    <label>User name:</label>
    <input name="login" type="text">
    <br/>
    <label>Password:</label>
    <input name="password" type="password">
    <br/>
    <button type="submit">Go!</button>
</form>

</body>
</html>
