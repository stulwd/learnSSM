<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <p>购买商品</p>
        <form action="purchase" method="POST">
            <table>
                <tr>
                    <td>商品编号:</td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td>购买数量:</td>
                    <td><input type="text" name="amount"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="购入"></td>
                </tr>
            </table>
        </form>
    </body>
</html>