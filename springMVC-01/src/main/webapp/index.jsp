<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
    <p><h1>第一个springmvc项目</h1><p>
    <p><a href="some.do">发起some.do的请求</a><p>
    <p><a href="other.do">发起other.do的请求</a><p>
<%--
href值一定不能加/前缀，
浏览器会把 / 当作 http://ip:port/
而不是 http://ip:port/工程名/
错误写法:
<p><a href="/other.do">发起other.do的请求</a><p>
--%>
    <p><a href="user/some.do">发起user/some.do的请求</a><p>
    <p><a href="user/other.do">发起user/other.do的请求</a><p>


    <br/>
    <p><a href="user1/some.do">发起user1/some.do的get请求</a><p>
    <p><a href="user1/other.do">发起user1/other.do的get请求</a><p>
    <form action="user1/other.do" method="post">
        <input type="submit" value="发起user1/other.do的post请求">
    </form>
    <p><a href="user1/first.do">发起user1/first.do的get请求</a><p>
    <form action="user1/first.do" method="post">
        <input type="submit" value="发起user1/first.do的post请求">
    </form>

    <br><br>
    <h2>receiveProperty:</h2>
    <form action="receiveProperty.do" method="get">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
    <form action="receiveProperty.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>

    <br><br>
    <h2>receiveProperty2:参数名和形参名不一样</h2>
    <form action="receiveProperty2.do" method="post">
        姓名:<input type="text" name="rname"><br>
        年龄:<input type="text" name="rage"><br>
        <input type="submit" value="提交参数">
    </form>

    <br><br>
    <h2>receiveProperty3:对象接受参数</h2>
    <form action="receiveProperty3.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>

    <br><br>
    <h2>处理器方法返回string表示视图名称</h2>
    <form action="returnString-view.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
</body>
</html>