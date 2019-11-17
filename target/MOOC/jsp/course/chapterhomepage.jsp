<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/14
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${chapId}
<table>
    <thead>
    <tr>
        <th colspan="3">
            <h2>小节列表</h2>
        </th>
    </tr>
    <tr>
        <th>小节名称</th>
        <th>小节状态</th>
        <th>小节操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courseChapSubs}" var="obj">
        <tr>
            <td>${obj.subName}</td>
            <c:if test="${obj.subOpen == 0 }">
                <th>关</th>
                <td>
                    <a>无法操作</a>
                </td>
            </c:if>
            <c:if test="${obj.subOpen == 1 }">
                <th>开</th>
                <td>
                    <a  href="${ctx}/student/openVideo?subVideo=${obj.subVideo}">观看视屏</a>
                </td>
            </c:if>
            <td>
                <a href=""></a>
                <form action="${ctx}/course/subhomepage" method="post">
                    <input type="hidden" name="subId" value="${obj.subId}">
                    <input type="submit" value="进入小节">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="${ctx}/course/wrongChap" method="post">
    <%--提交学生id：--%>
    <input type="hidden" name = "studentId"  value="${USER.userId}">
    <%-- 提交小节id：--%>
    <input type="hidden" name = "chapId" value="${chapId}">
    <input type="submit" value="章节学习情况">
</form>
</body>
</html>
