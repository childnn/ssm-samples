<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="js/jquery-3.3.1.min.js"></script>
    <%--会被 DispatcherServlet 拦截: 必须要配置: springmvc.xml--%>

    <title></title>
</head>
<body>
<h2>Hello World!</h2>

<%--org.anonymous.controller.UserController--%>
<form action="test1" method="post">
    <input type="text" name="id">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="submit">
</form>
<hr/>
<a href="save">saveSession</a>
<a href="find">findSession</a>
<a href="find0">findSession0</a>
<a href="delete">deleteSession</a>
<br/>
<br/>
<br/>

RestFul 编程风格：
<form action="restFul/user/1" method="get">
    <input type="submit" value="get获取">
</form>

<form action="restFul/user/2" method="post">
    <input type="submit" value="post增加">
</form>

<hr/>

<input type="button" id="bt" value="ajax">

<br/>
<a href="string/test1">string类型返回值:实现重定向/请求转发</a><br/>
<a href="string/test2">void类型返回值:实现重定向/请求转发</a><br/>
<a href="string/test3">ModelAndView 返回值实现 数据响应/页面跳转(重定向/请求转发)</a><br/>

<hr/>

<%--上传--%>
<form action="upload/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="myFile">
    <input type="submit" value="upload">
</form>


<%--给 ajax 按钮绑定点击事件--%>
<script>
    $("#bt").click(function () {
        $.ajax({
            url: '/springMVC_day02_a/ajax',
            data: '{"id":1, "username":"jack", "password":"abcd"}',
            type: 'post',
            dataType: "json",
            contentType: 'application/json;charset=utf8',
            sync: true,
            success: function (d) {
                alert(d.username);
            },
            error: function () {
                alert("error..")
            }
        })
    });
</script>

</body>
</html>
