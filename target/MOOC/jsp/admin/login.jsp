<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/5
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<form action="${ctx}/admin/login" method="post">
    <div class="content">
        <div class="panel">
            <div class="group">
                <ul>
                    <li><label>账号</label></li>
                    <li><input type="text" name="userAccount" placeholder=" 请输入账号" /></li>
                </ul>
                <ul>
                    <li><label>密码</label></li>
                    <li><input type="password" name="userPassword" placeholder=" 请输入密码" /></li>
                </ul>
            </div>
            <div class="login">
                <button type="submit">登录</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
<style type="text/css">
    *{
        margin:0 auto;
        padding:0;
    }
    /*添加一个浅灰色背景*/
    body{
        background-color:#eee;
    }

    .content{
        /*border:1px solid red;*/
        width:300px;
        margin-top:50px;
    }

    .content .panel{
        border:1px solid #ccc;
        border-radius:5px;
        height:220px;
        background-color:#fff;
    }
    .content .panel .group{
        margin:30px 10px 10px 20px;
    }
    .content .panel .group ul{
        list-style: none;
        margin-top:15px;
    }

    .content .panel .group ul li{
        margin-top:2px;
    }

    .content .panel .group ul li input{
        line-height:22px;
        width:250px;
        font-size: 14px;
        font-family: "微软雅黑","宋体";
    }
    .content .panel .group ul li label{
        font-size: 14px;
        font-family: "黑体","微软雅黑","宋体";
        font-weight: bold;
    }

    .content .panel .login{
        text-align: center;
        /*border:1px solid red;*/
        margin-top:20px;

    }
    .content button{
        width:255px;
        height:30px;
        background-color:#008000;
        border:none;
        color:#fff;
        font-size:16px;
        font-weight: bold;
        cursor:pointer;
    }

    .content .register button {
        width: 80px;
        height: 30px;
        border: none;
        font-size: 14px;
        background-color: #4c6bb2;
        color: #fff;
        font-family: "微软雅黑";
        text-align: center;
        margin-left: 30px;
    }
</style>



