<%--
  Created by IntelliJ IDEA.
  User: child
  Date: 2019/4/20 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>okokokookokooko</h1>

获取 request 域中数据: <br/>
         jsp方式-----><%=request.getAttribute("msg")%>  <br/> <%--如果没有对应的数据, jsp 方式得到 null--%>
        el表达式----->${msg} <br/> <br/>  <%--el 表达式得到 : 空字符串--%>



</body>
</html>
