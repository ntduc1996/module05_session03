<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<h3>List Student</h3>
<table border="1">
    <thead>
    <tr>
        <td>No</td>
        <td>Mã sinh viên</td>
        <td>Họ và Tên</td>
        <td>Tuổi</td>
        <td>Địa chỉ</td>
        <td>Actions</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="student" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${student.id}</td>
            <td>${student.studentName}</td>
            <td>${student.studentAge}</td>
            <td>${student.studentAddress}</td>
            <td>
                <c:url var="updateUrl" value="/StudentController">
                    <c:param name="action" value="initUpdate"/>
                    <c:param name="studentId" value="${student.id}"/>
                </c:url>
                <a href="${updateUrl}">Update</a>

                <c:url var="deleteUrl" value="/StudentController">
                    <c:param name="action" value="Delete"/>
                    <c:param name="studentId" value="${student.id}"/>
                </c:url>
                <a href="${deleteUrl}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%= request.getContextPath()%>/views/newStudent.jsp">Thêm sinh viên mới</a>
</body>
</html>
