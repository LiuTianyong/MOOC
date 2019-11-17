<%@ page import="com.usy.pojo.Course" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/21
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开设班级</title>

</head>
<body>
${COURSE}
<form action="${ctx}/class/openClass" method="post">
    <%--班级所属课程ID <input type="text" name="courseId" value="${COURSE.courseId}" style="display:none">--%>
        <input type="hidden" name="courseId" value="${course}">
        班级名称:<input  type="text" name="className" >
        班级人数上限:<input type="text" name="classAmount">
        <input type="submit" value="提交">
</form>

</body>
</html>
