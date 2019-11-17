<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/13
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师端主页</title>
</head>
<body>
    欢迎认证教师：${USER}<br>

    <a href="${ctx}/jsp/teacher/offercourses.jsp"> 去发布课程</a>
    <a href="${ctx}/jsp/teacher/personalcenter.jsp">个人中心</a>
    <a href="${ctx}/teacher/seemycourse/${USER.userId}">我的课程</a>
    <a href="${ctx}/class/queryAllClass/${TEACHER.teacherId}"> 我的班级</a>
</body>
</html>
