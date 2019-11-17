<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/18
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改课程</title>
</head>
<body>
        <form action="${ctx}/teacher/alterCourse2">
            <input type="hidden" name="courseId" value="${course.courseId}">
            <input type="hidden" name="teacherId" value="${course.teacherId}">
            课程名称:<input type="text"  name="courseName" value="${course.courseName}"><br>
            课程类型:<input type="text" name="courseType" value="${course.courseType}"><br>
            课程简介:<input type="text" name="courseIntro" value="${course.courseIntro}"><br>
            开设时间:<input type="date" name="courseBegin" value="${course.courseBegin}"><br>
            结束时间:<input type="date" name="courseEnd" value="${course.courseEnd}"><br>
            开设状态:<input type="text" name="courseOpen" value="${course.courseOpen}"><br>
            公开状态:<input type="text" name="coursePublic" value="${course.coursePublic}"><br>
            考核状态:<input type="text" name="courseCheck" value="${course.courseCheck}"><br>
           <%-- 课程密码:<input type="text" name="coursePassword" value="${course.coursePassword}"><br>--%>
            <input type="submit" value="提交">
        </form>
        <div>
            <table border="1">
                <thead>
                <tr>
                    <th colspan="5">
                        <h2>课程章节</h2>
                    </th>

                </tr>
                <tr>
                    <th>章节名</th>
                    <th>开设状态</th>
                    <th>开始时间</th>
                    <th>截至时间</th>
                    <th>小节操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${courseChaps}" var="obj">
                    <tr>
                        <td>${obj.chapName}</td>
                        <td>${obj.chapOpen}</td>
                        <td>${obj.chapBegin}</td>
                        <td>${obj.chapEnd}</td>
                        <td>
                            <form action="${ctx}/teacher/alterChap1">
                                <input type="hidden" name="chapId" value="${obj.chapId}">
                                <input type="submit" value="修改章节">
                            </form>
                        </td>
                        <td>
                            <form action="${ctx}/teacher/deleteChap">
                                <input type="hidden" name="chapId" value="${obj.chapId}">
                                <input type="submit" value="删除章节">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</body>
</html>
