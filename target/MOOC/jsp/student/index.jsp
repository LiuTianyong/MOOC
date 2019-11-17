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
    <title>Title</title>
</head>
<body>
    登陆成功<br>
    欢迎：${USER}<br>
    <a href="${ctx}/student/coursemain/${USER.userId}">我的课程</a>
    <a href="${ctx}/student/allclass1/${USER.userId}">我的班级</a>
    <a href="${ctx}/student/courseinfo/${USER.userId}">查看课程</a><br>
    <a href="${ctx}/student/studentInfo?userId=${USER.userId}">修改资料</a>
    <a href="../jsp/student/updatePassword.jsp">修改密码</a>
</body>
</html>
