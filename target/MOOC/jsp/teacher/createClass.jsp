<%@ page import="com.usy.pojo.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/21
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Random" %>
<html>
<head>
    <title>自动生成班级班级</title>

</head>
<body>
${COURSE}

<%
    //产生随机班级
    Random a = new Random();
    int number=a.nextInt(100);
    String className = "未来" + number + "班";
%>
<form action="${ctx}/class/openClass" method="post">
    <%--班级所属课程ID <input type="text" name="courseId" value="${COURSE.courseId}" style="display:none">--%>
    班级名称:<input  type="text" name="className" value="<%=className%>">
    班级人数上限:<input type="text" name="classAmount" value="90">
    <input type="submit" value="提交">
</form>

</body>
</html>
