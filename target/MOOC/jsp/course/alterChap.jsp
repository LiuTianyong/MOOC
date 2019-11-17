<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/18
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改章节</title>
</head>
<body>
<form action="${ctx}/course/openChap">
    <input type="hidden" name="chapId" value="${courseChap.chapId}">
    章节名称:<input type="text" name="chapName" value="${courseChap.chapName}">
    章节开设状态:<input type="text" name="chapOpen" value="${courseChap.chapOpen}">
    章节开始时间:<input type="date" name="chapBegin" value="${courseChap.chapBegin}">
    章节结束时间:<input type="date" name="chapEnd" value="${courseChap.chapEnd}" >
    <input type="submit" value="确定">
</form>
</body>
</html>
