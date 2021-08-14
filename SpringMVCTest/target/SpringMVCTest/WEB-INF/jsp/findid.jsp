<%--
  Created by IntelliJ IDEA.
  User: 86151
  Date: 2021/6/5
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="Update.do">
    名字：<input type="text" name="cname" value="${com.cname}"></br>
    价格：<input type="text" name="price" value="${com.price}"></br>
    图片：<img src="/${com.imgs}" width="50px"></br>
    图片更改：<input type="file" name="img" value="${com.imgs}"></br>
    <input type="submit" value="提交">
</form>
</body>
</html>
