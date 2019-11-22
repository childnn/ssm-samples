
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<%--简单数据: 变量名一致即可: name=方法参数变量名--%>
<form action="user/test">
    <input type="text" name="username"/>
    <input type="password" name="password"/>
    <input type="submit" value="简单数据"/>
</form>
<hr/>

<%--对象:name 属性值 = 对象的 成员变量名--%>
<form action="user/test1">
    <input type="text" name="username"/>
    <input type="password" name="password"/>
    <br/>
    日期<input type="text" name="date"/>
    <input type="submit" value="对象"/>
</form>
<hr/>


<%--对象的 list 集合 数据的封装: name 属性值 == 对象的集合属性名[索引].属性名--%>
<form action="user/test2">
    <input type="text" name="username"/>
    <input type="password" name="password"/>
    <br/>
    第一个账户名: <input type="text" name="accounts[0].name"/>
    第一个账户金额:<input type="text" name="accounts[0].money"/>
    <br/>
    第二个账户名: <input type="text" name="accounts[1].name"/>
    第二个账户金额:<input type="text" name="accounts[1].money"/>
    <br/>
    第三个账户名: <input type="text" name="accounts[2].name"/>
    第三个账户金额:<input type="text" name="accounts[2].money"/>
    <br/>
    <input type="submit" value="对象的list集合"/>
</form>
<hr/>


<%--Map<String, Account> : name 属性值 == map 集合属性名[key值].属性名 --%>
<form action="user/test3">
    <input type="text" name="username"/>
    <input type="password" name="password"/>
    <br/>
    第一个账户名: <input type="text" name="maps['1'].name"/>
    第一个账户金额:<input type="text" name="maps['1'].money"/>
    <br/>
    第二个账户名: <input type="text" name="maps[2].name"/>
    第二个账户金额:<input type="text" name="maps[2].money"/>
    <br/>
    第三个账户名: <input type="text" name="maps[3].name"/>
    第三个账户金额:<input type="text" name="maps[3].money"/>
    <br/>
    <input type="submit" value="对象的map集合"/>
</form>
<hr/>

<%--servlet--%>

<a href="user/test4">servlet</a>

<hr/>
<hr/>

<%--获取请求头--%>
<a href="user/test5">requestHeader</a>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
</body>
</html>
