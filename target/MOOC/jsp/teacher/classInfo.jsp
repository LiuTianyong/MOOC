<%@ page import="com.usy.pojo.Course" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/26
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师课程班级信息</title>
</head>
<body>
<c:if test="${CLASS.size()==0}">
    <script type="text/javascript">
        alert("该课程没有班级");
    </script>
</c:if>
<div>
    <table  border="1">
        <thead>
        <tr>
            <th colspan="3">
                <h2>教师课程班级信息</h2>
            </th>

        </tr>
        <tr>
            <td>班级名称</td>
            <td>班级人数</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${CLASS}" var="cl">
            <tr>
                <th>${cl.className}</th>
                <th>${cl.classAmount}</th>
                    <th>
                        <form action="${ctx}/student/queryStudent">
                            <input type="hidden" name="classId" value="${cl.classId}">
                            <input type="submit" value="班级学生名单">
                        </form>
                        <form action="${ctx}/class/classWrongInfo">
                            <input type="hidden" name="classId" value="${cl.classId}">
                            <input type="submit" value="班级错题情况">
                        </form>
                        <form action="${ctx}/class/classInfo">
                            <input type="hidden" name="classId" value="${cl.classId}">
                            <input type="submit" value="修改班级信息">
                        </form>
                        <form action="${ctx}/class/deleteClass">
                            <input type="hidden" name="classId" value="${cl.classId}">
                            <input type="hidden" name="courseId" value="${cl.courseId}">
                            <input type="submit" value="解散班级">
                        </form>
                    </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
