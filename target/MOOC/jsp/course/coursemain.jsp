<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/14
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th colspan="2">
            <h2>章节列表</h2>
        </th>
    </tr>
    <tr>
        <th>章节名称</th>
        <th>章节操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courseChaps}" var="obj">
        <tr>
            <td>${obj.chapName}</td>
            <td>
                <form action="${ctx}/course/chapterhomepage">
                    <input type="hidden" name="courseId" value="${obj.courseId}">
                    <input type="hidden" name="chapId" value="${obj.chapId}">
                    <input type="submit" value="进入章节">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="${ctx}/course/courseLearning" method="post">
    <%--提交学生id：--%>
    <input type="hidden" name = "studentId"  value="${USER.userId}">
    <%-- 提交小节id：--%>
    <input type="hidden" name = "courseId" value="${courseId}">
    <input type="submit" value="课程学习情况">
</form>
</body>
</html>
