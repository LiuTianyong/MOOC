<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/10
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生所做试卷</title></title>
</head>
<body>
<table  border="1">
    <thead>
    <tr>
        <th colspan="6">
            <h2>学生错题试卷信息</h2>
        </th>

    </tr>
    <tr>
        <td>试卷名称</td>
        <td>试卷类型</td>
        <td>试卷所属小节</td>
        <td>试卷所属章节</td>
        <td>试卷所属课程</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${WRONGPAPER}" var="wp">
    <tr>
        <th>${wp.paper_name}</th>
        <th>${wp.paper_type}</th>
        <th>${wp.sub_name}</th>
        <th>${wp.chap_name}</th>
        <th>${wp.course_name}</th>
        <th>
            <a href="${ctx}/student/wrongPaperInfo/${wp.student_id}/${wp.paper_id}">查看试卷错题</a>
        </th>
    </tr>
    </c:forEach>
</body>
</html>
