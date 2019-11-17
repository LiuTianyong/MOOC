<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 2019/4/11
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看课程</title>
</head>
<body>
<%--<div><input type="radio" name="courseName" pattern="\D\S\W" type="text" value="${courseName}"/>按课程名查找</div>--%>
<%--<div><input type="radio" name="courseType" pattern="\D\S\W" type="text" value="${courseType}"/>按课程</div>--%>
<%--<div><input type="radio" name="teacherName" pattern="\D\S\W" type="text" value="${courseName}"/>按课程名查找</div>--%>
    <form type="post" action="${ctx}/student/searchname">
        <div><h2>搜索框</h2></div>
        <input name="courseName" type="text" value="${courseName}" />
        <input type="hidden" name="studentId" value="${studentId}">
        <input  type="submit" value="搜索" />
    </form>

    <table border="1px">
        <tr>
            <th>课程ID</th>
            <th>老师姓名</th>
            <th>课程名称</th>
            <th>课程专业类型</th>
            <th>课程简介</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>课程开放状态</th>
            <th>查看课程班级</th>
        </tr>
    <c:forEach items="${infocourse}" var="course">
        <tr>
            <td>${course.courseId}</td>
            <td>${course.teacherInfo.teacherName}</td>
            <td>${course.courseName}</td>
            <td>${course.courseType}</td>
            <td>${course.courseIntro}</td>
            <td>${course.courseBegin}</td>
            <td>${course.courseEnd}</td>
            <c:if test="${course.courseOpen == 1}">
                <td>开放</td>
            </c:if>
            <c:if test="${course.courseOpen == 0}">
                <td>关闭</td>
            </c:if>
            <td><a href="${ctx}/student/courseclass?courseId=${course.courseId}&studentId=${studentId}">点击进入</a></td>
        </tr>
    </c:forEach>

            <c:forEach items="${nameofcourse}" var="name">
                <tr>
                    <td>${name.courseId}</td>
                    <td>${name.teacherInfo.teacherName}</td>
                    <td>${name.courseName}</td>
                    <td>${name.courseType}</td>
                    <td>${name.courseIntro}</td>
                    <td>${name.courseBegin}</td>
                    <td>${name.courseEnd}</td>
                    <c:if test="${name.courseOpen == 1}">
                        <td>开放</td>
                    </c:if>
                    <c:if test="${name.courseOpen == 0}">
                        <td>关闭</td>
                    </c:if>
                    <td><a href="${ctx}/student/courseclass?courseId=${name.courseId}&studentId=${studentId}">点击进入</a></td>
                </tr>
            </c:forEach>
    </table>
</body>
</html>
