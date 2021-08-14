<%--
  Created by IntelliJ IDEA.
  User: 86151
  Date: 2021/6/2
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="addTeacher.jsp">添加老师信息</a>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>sex</td>
        <td>score</td>
    </tr>
    <c:forEach items="${list}" var="tea" >
        <tr>
            <td>${tea.tid}</td>
            <td>${tea.tname}</td>
            <td>${tea.sex}</td>
            <td>${tea.times}</td>
<%--            <td><a href="${pageContext.request.contextPath}/delete?id=${stu.id}">delete</a></td>--%>
<%--            <td><a href="${pageContext.request.contextPath}/findid?id=${stu.id}">update</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
