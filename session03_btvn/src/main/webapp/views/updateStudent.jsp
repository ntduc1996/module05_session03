<%--
  Created by IntelliJ IDEA.
  User: asahi
  Date: 8/3/2025
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/StudentController?action=Update" method="post">
    <label for="studentId">StudentId</label>
    <input type="text" id="studentId" name="studentId" value="${student.id}" readonly/><br>
    <label for="studentName">Student Name</label>
    <input type="text" id="studentName" name="studentName" value="${student.studentName}"/><br>
    <label for="studentAge">Student Age</label>
    <input type="text" id="studentAge" name="studentAge" value="${student.studentAge}"/><br>
    <label for="studentAddress">Student Address</label>
    <input type="text" id="studentAddress" name="studentAddress" value="${student.studentAddress}"/><br>
    <input type="submit" value="Update"/>
</form>

</body>
</html>
