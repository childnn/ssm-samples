<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="myFile">
    <input type="submit" value="跨服务器上传">
</form>
<hr/>
<%--异常处理--%>
<a href="test1">异常处理</a>

<%--拦截器--%>
<a href="test2">拦截器测试</a>

<%--拦截器案例: 用户校验--%>
<a href="find">查看用户信息</a>
</body>
</html>
