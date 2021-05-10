<%--
  Created by IntelliJ IDEA.
  User: wendi
  Date: 2021/5/3
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--使用方法二解決跳转路径不正确--%>
<%
     String basePath = request.getScheme() + "://" +
                        request.getServerName() + ":" + request.getServerPort() +
                        request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <%--使用方法二解決跳转路径不正确--%>
    <base href="<%=basePath%>">
</head>
<body>
    <h3>/WEB-INF/view/show2.jsp从request作用域获取数据</h3>
    <h3>myName数据:${myName}</h3>
    <h3>myAge数据:${myAge}</h3>

    <p>模拟跳转失败</p>
    <br/>
    <form action="index.jsp" method="post">
<%--    使用方法一解决跳转路径不对的问题--%>
<%--    <form action="${pageContext.request.contextPath}/index.jsp">--%>
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
    <br/>
</body>
</html>
