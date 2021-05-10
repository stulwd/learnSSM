<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Title</title>
  <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
    <br><br>
<%--    <form action="some.do" method="post">--%>
<%-- 将url-pattern 设置为/，并且处理完静态资源后，就可以修改为如下--%>
    <form action="some" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <img src="images/p1.jpg" alt="我是一个静态资源，不能显示">

    <p>模拟跳转失败</p>
    <br/>
    <form action="a/b/c/d/some2" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>
    <br/>
</body>
</html>
