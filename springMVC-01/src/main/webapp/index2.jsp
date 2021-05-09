<%--
  Created by IntelliJ IDEA.
  User: wendi
  Date: 2021/5/4
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn").click(function () {
                $.ajax({
                    // url:"returnVoid-ajax.do",
                    url: "returnJsonObj.do",
                    data:{
                        name:"zhangsan",
                        age: 20
                    },
                    type:"post",
                    dataType: "json",
                    //如果上面一行注释掉，服务器端也是
                    //可以通过response.setContentType("application/json")
                    //来指定数据类型，jquery照样能解析，但如果两端都没有指定，resp就是一个
                    //普通的字符串了，此时打印 alert(resp)，会出现一个json字符串
                    success:function (resp){
                        // resp从服务器端返回的是json格式的字符串
                        // jquery会根据dataType把json字符串转为json对象，赋值给resp形参
                        alert(resp.name + "  " + resp.age)

                    }
                })
            })

            $("#btn2").click(function () {
                $.ajax({
                    url: "doReturnJsonObjArray.do",
                    data: {
                        name: "小南",
                        age: 30
                    },
                    type: "post",
                    dataType: "json",
                    success:function (resp) {
                        $.each(resp, function (i, n){
                            alert(n.name + "  " + n.age)
                        })
                    }

                })
            })
            $("#btn3").click(function () {
                $.ajax({
                    url: "doReturnString.do",
                    data: {
                        k1: "v1",
                        k2: "v2"
                    },
                    type: "get",
                    // dataType: "json",
                    // dataType: "text/plain;charset=UTF-8",   // 使用这个也不管用哦，必须在后端RequestMapping设置produces
                    success:function (resp) {
                        alert("resp: "+resp)
                    }

                })
            })
        })
    </script>
</head>
<body>
    <button id="btn">发起ajax请求</button>
    <button id="btn2">发起ajax请求2</button>
    <button id="btn3">发起ajax请求3</button>
</body>
</html>
