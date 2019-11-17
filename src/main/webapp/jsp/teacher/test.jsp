<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/29
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>
<body>

<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    layui.use(['element','jquery','layer'],function () {
        var element = layui.element;
        var jquery = layui.jquery;
        var layer = layui.layer;
    });

    $(function () {
        $('input[name=userAccount]').blur(function () {
            //获取名字
            var name = $('input[name=userAccount]').val();

            var obj = {
                userAccount:name
            };
            $.ajax({
                url:'${ctx}/user/checkaccount',
                type:'post',
                contentType:'application/json',
                data:JSON.stringify(obj),
                success:function (data) {
                    if (data.code == 200){
                        //可以用
                        layer.msg('用户名可以使用',{icon: 6})
                    }else{
                        //不可以用
                        layer.msg('用户名已经被注册',{icon: 3})
                    }
                }
            })
        })
    })
</script>

</body>
</html>
