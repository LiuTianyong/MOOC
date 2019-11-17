<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/13
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%/*获得系统时间sql.date*/
    String time=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间
    java.sql.Date comTime = java.sql.Date.valueOf(time);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${sub}" var="sub">
    <tr>
        <td>${sub.subPpt}</td>
        <td>${sub.subVideo}</td>
        <td>${sub.subOpen}</td>
    </tr>
</c:forEach>
<div>
    <table border="1" width="800">
        <thead>
        <tr>
            <th colspan="3">
                <h2>讨论区</h2>
            </th>

        </tr>
        <tr>
            <th>账号</th>
            <th>时间</th>
            <th>评论内容</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${subList}" var="obj">
            <tr>
                <td>${obj.userAccount}</td>
                <td>${obj.comTime}</td>
                <td>${obj.comContent}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<form action="${ctx}/course/insertComment" method="post">
    <%--提交小节id：--%>
    <input type="hidden" name = "subId"  value="${subId}">
    <%--提交userid：--%>
    <input type="hidden" name = "userId"  value="${USER.userId}">
    <%--提交评论信息：--%>
    <input type="text" name="comContent" width="80" height="40" required>
    <%-- 提交评论时间：(系统生成)--%>
    <input type="date" name = "comTime" value="<%=comTime%>" style="display:none">
    <input type="submit" value="提交">
</form>
<form action="${ctx}/coursePaperController/studentTest">
    <input type="hidden"name="studentId" value="${USER.userId}">
    <input type="hidden" name="subId" value="${subId}">
    <input type="hidden" name="courseId" value="${courseId}">
    <input type="submit" value="小节测试">
</form>
<form action="${ctx}/course/wrongSub" method="post">
    <%--提交学生id：--%>
    <input type="hidden" name = "studentId"  value="${USER.userId}">
    <%-- 提交小节id：--%>
    <input type="hidden" name = "subId" value="${subId}">
    <input type="submit" value="小节学习情况">
</form>
</body>
</html>
