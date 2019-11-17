<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 2019/4/12
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程下的班级</title>
</head>
<body>

<form type="post" action="${ctx}/student/findclass">
    <h2>搜索框</h2>
    <input name="className" type="text" value="${courseName}"/>
    <input  type="submit" value="搜索"/>
</form>

<table border="1px">
    <div><h2>加入该课程的班级有：</h2></div>
    <tr>
        <th>班级ID</th>
        <th>班级名称</th>
        <th>容纳人数</th>
        <th>加入课程</th>
    </tr>
    <c:forEach var="classinfo" items="${courseclassinfo}">
        <tr>
            <td>${classinfo.classId}</td>
            <td>${classinfo.className}</td>
            <td>${classinfo.classAmount}</td>
            <td><a href="${ctx}/student/joinaclass?classId=${classinfo.classId}&courseId=${classinfo.courseId}&studentId=${studentId}">点击加入</a></td>
        </tr>
    </c:forEach>

    <c:forEach var="wantclass" items="${nameofclass}">
        <tr>
            <td>${wantclass.classId}</td>
            <td>${wantclass.className}</td>
            <td>${wantclass.classAmount}</td>
            <td><a href="${ctx}/student/joinaclass?classId=${wantclass.classId}&courseId=${wantclass.courseId}&studentId=${studentId}">点击加入</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
