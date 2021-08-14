<%--
  Created by IntelliJ IDEA.
  User: 86151
  Date: 2021/6/5
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="AddCom.do">
    名字：<input type="text" name="cname"></br>
    价格：<input type="text" name="price"></br>
    图片：<input type="file" name="img"></br>
    <input type="submit" value="提交">
</form>
</body>
</html>
