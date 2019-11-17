<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/5
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th colspan="2">
                <h2>课程列表</h2>
            </th>
        </tr>
        <tr>
            <th>课程名</th>
            <th>课程操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courseList}" var="obj">
            <tr>
                <td>${obj.courseName}</td>
                <td>
                    <%--<a href="${ctx}/course/coursemain/${obj.courseId}&amp;${obj.studentId}">进入课程</a>--%>
                    <form action="${ctx}/course/coursemain">
                        <input type="hidden" name="courseId" value="${obj.courseId}">
                        <input type="hidden" name="studentId" value="${obj.studentId}">
                        <input type="submit" value="进入课程">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
