<%--
  Created by IntelliJ IDEA.
  User: 86151
  Date: 2021/5/30
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    姓名：<input type="text" name="tname" id="tname"><br>
    性别：<input type="text" name="sex" id="sex"><br>
    时间：<input type="date" name="times" id="times"><br>
    <button>提交</button>
</table>
<script type="text/javascript" src="WEB-INF/js/jquery-3.3.1.js"></script>
<script>
    $("button").click(function () {
        $("#tname").val();
        $.ajax({
            type:"post",
            url:"http://localhost:8080/SpringMVCTest_war/AddTea",
            data:{tname:$("#tname").val(),sex:$("#sex").val(),times:$("times").val()}
        })
    })
</script>
</body>
</html>
