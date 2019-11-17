<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
${SUCCESS}
<div id="allclass1">
    <div>
        <form action="${ctx}/student/query/courseId" >
            <span style="font-size: 24px">按课程名称查找</span>
            <input type="text" name="courseName" >
            <input type="hidden" name="studentId" value="${USER.userId}">
            <input type="submit" value="查询">
        </form>

    </div>

    <div>
        <table>

            <thead>
            <tr>
                <th colspan="4">
                    <h2>课程列表</h2>
                </th>

            </tr>
            <tr>
                <th>课程名称</th>
                <th>班级名称</th>
                <th>课程专业类型</th>
                <th>课程简介</th>
                <th>讲师名</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${courses}" var="obj">
                <tr>
                    <td>${obj.courseName}</td>
                    <td>${obj.className}</td>
                    <td>${obj.courseType}</td>
                    <td>${obj.courseIntro}</td>
                    <td>${obj.teacherName}</td>
                    <td>
                        <a href="${ctx}/student/addcomments/${obj.courseId}&amp;${USER.userId}&amp;${obj.teacherId}">评论</a>
                        <a href="${ctx}/student/deleteclass/${obj.courseId}&amp;${USER.userId}">退班</a>
                    </td>
                </tr>

            </c:forEach>
            </tbody>


        </table>
    </div>
</div>
</body>
</html>
