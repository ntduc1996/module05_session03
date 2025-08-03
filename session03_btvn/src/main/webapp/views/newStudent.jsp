<%--
  Created by IntelliJ IDEA.
  User: asahi
  Date: 8/3/2025
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new student</title>
</head>
<body>
<h3>Add new student</h3>
<form action="<%=request.getContextPath()%>/StudentController?action=Create" method="post">
    <label for="studentName"></label>
    <input type="text" name="studentName" id="studentName" placeholder="Enter your name"><br>
    <label for="studentAge"></label>
    <input type="text" name="studentAge" id="studentAge" placeholder="Enter your age"><br>
    <label for="studentAddress"></label>
    <input type="text" name="studentAddress" id="studentAddress" placeholder="Enter your address"><br>
    <input type="submit" value="Add student">
</form>
</body>
</html>
