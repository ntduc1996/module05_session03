<%--
  Created by IntelliJ IDEA.
  User: asahi
  Date: 8/4/2025
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Đăng nhập</h3>
<form action="<%=request.getContextPath()%>/AdminController?action=login" method="post">
    <label for="username">Username</label>
    <input type="text" name="username" id="username" placeholder="Username">
    <label for="password">Password</label>
    <input type="password" name="password" id="password" placeholder="Password"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
