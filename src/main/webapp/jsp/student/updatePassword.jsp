<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/12
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生修改密码</title>
    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
    <script type="text/javascript">
        // 控制onsubmit提交的方法，方法名是vform()
        function updatePassword(){
            //获取下面的id值
            alert("确定修改?");
            var ne = $("#userPassword").val();
            var ol = $("#oldPassword").val();
            var ua = $("#userAccount").val();
            //判断上面的变量
            //账号是否相同
            if(ua != ${USER.userAccount}){
                alert("账户不正确！请重新输入");
                return false;
            }
            if(ol != ${USER.userPassword}){
                alert("旧密码和新密码不相同！请重新输入");
                return false;
            }
            if(ol ==""){
                alert("旧密码不能为空！请重新输入");
                return false;
            }
            if(ne.length <=6){
                alert("密码小于六位请重新输入！");
                return false;
            }
            if(ne.length >11){
                alert("密码大于十一位请重新输入！");
                return false;
            }
            if(ne==""){
                alert("新密码不能为空请重新输入！");
                return false;
            }
            alert("修改成功,请重新登录");

            return true;
        }
    </script>
</head>
<body>
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<form action="${ctx}/student/updatePassword" method="post" onsubmit="return updatePassword()">
    <%--根据条件更改密码--%>
                    <input type="hidden" name="userId" value="${USER.userId}"><br>
    请输入你的账号：<input type="text" name="userAccount" id="userAccount"><br>
    请输入原始密码：<input type="password" name="oldPassword" id="oldPassword"><br>
    请输入新密码：<input type="password" name="userPassword" id="userPassword"><br>
    <input type="submit" value="修改密码">
</form>
</body>
</html>
