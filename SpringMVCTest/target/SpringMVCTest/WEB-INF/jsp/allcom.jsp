<%--
  Created by IntelliJ IDEA.
  User: 86151
  Date: 2021/6/5
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>cid</td>
        <td>cname</td>
        <td>price</td>
        <td>imgs</td>
    </tr>
    <c:forEach items="${list}" var="com" >
        <tr>
            <td>${com.cid}</td>
            <td>${com.cname}</td>
            <td>${com.price}</td>
            <td><img src="/${com.imgs}" width="50px"></td>
            <td><a href="${pageContext.request.contextPath}/Delete.do?cid=${com.cid}">delete</a></td>
            <td><a href="${pageContext.request.contextPath}/FindById.do?cid=${com.cid}">update</a></td>
        </tr>
    </c:forEach>
</table>
<a href="toAdd.do">增加</a>
</body>
</html>
