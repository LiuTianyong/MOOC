<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="${ctx}/teacher/alterChap2">
    <input type="hidden" name="chapId" value="${courseChap.chapId}">
    <input type="hidden" name="courseId" value="${courseChap.courseId}">
    章节名称:<input type="text" name="chapName" value="${courseChap.chapName}">
    章节开设状态:<input type="text" name="chapOpen" value="${courseChap.chapOpen}">
    章节开始时间:<input type="date" name="chapBegin" value="${courseChap.chapBegin}">
    章节结束时间:<input type="date" name="chapEnd" value="${courseChap.chapEnd}" >
    <input type="submit" value="确定">
</form>

<div>
    <table border="1">
        <thead>
        <tr>
            <th colspan="8">
                <h2>开设的小节</h2>
            </th>

        </tr>
        <tr>
            <th>小节名</th>
            <th>开设状态</th>
            <th>PPT</th>
            <th>视频</th>
            <th>资料</th>
            <th>测试</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courseChapSub}" var="obj">
            <tr>
                <td>${obj.subName}</td>
                <td>${obj.subOpen}</td>
                <td>${obj.subPpt}</td>
                <td>${obj.subVideo}</td>
                <td>${obj.subMaterial}</td>
                <%--<td>
                    <form action="${ctx}/coursePaperController/test">
                        <input type="hidden" name="subId" value="${obj.subId}">
                        <input type="hidden" name="paperType" value="1">
                        <input type="submit" value="增加试卷">
                    </form>
                </td>--%>
                <td>
                    <form action="${ctx}/teacher/alterSub1">
                        <input type="hidden" name="subId" value="${obj.subId}">
                        <input type="submit" value="修改">
                    </form>
                </td>
                <td>
                    <form action="${ctx}/teacher/deleteSub">
                        <input type="hidden" name="subId" value="${obj.subId}">
                        <input type="submit" value="删除">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
