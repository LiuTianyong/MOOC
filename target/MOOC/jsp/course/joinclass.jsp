<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/9
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>加入班级成功</title>
</head>
<body>
班级是否关闭:${CourseOpen}<br>
学生是否在班级里面：${stuInClass}<br>
班级是否已满学生加不进去：${numberFull}<br>
班级信息：${StudentChoose}<br>
加入班级结果：${result}<br>
<a href="${ctx}/student/allclass1/${USER.userId}">返回</a>
</body>
</html>
