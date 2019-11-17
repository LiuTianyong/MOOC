<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/6
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开设小节</title>
    <meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8" />
</head>
<body>
${SUCCESS}
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
        <c:forEach items="${chapSubs}" var="obj">
            <tr>
                <td>${obj.subName}</td>
                <td>${obj.subOpen}</td>
                <td>${obj.subPpt}</td>
                <td>${obj.subVideo}</td>
                <td>${obj.subMaterial}</td>
                <td>
                    <form action="${ctx}/coursePaperController/test">
                        <input type="hidden" name="subId" value="${obj.subId}">
                        <input type="hidden" name="paperType" value="1">
                        <input type="submit" value="增加试卷">
                    </form>
                </td>
                <td>
                    <form action="${ctx}/course/alterSub">
                        <input type="hidden" name="subId" value="${obj.subId}">
                        <input type="submit" value="修改">
                    </form>
                </td>
                <td>
                    <form action="${ctx}/course/deleteSub">
                        <input type="hidden" name="subId" value="${obj.subId}">
                        <input type="submit" value="删除">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<form action="${ctx}/course/openSub" enctype="multipart/form-data" method="post">
    <%--小节ID--%>
    <%--小节所属小节ID--%>
        <input type="hidden" name="chapId" value="${chapId}"><%--${chapId}--%>
    小节名称:<input type="text" name="subName"><br>
    小节PPT:<input type="file" name="pptFile"><br>
    小节视频:<input type="file" name="VideoFile"><br>
    小节开设状态:<input type="text" name="subOpen"><br>
    小节知识点:<input type="text" name="subKnow"><br>
    小节课程资料:<input type="file" name="MaterialFile"><br>
    <input type="submit" value="提交小节">
</form>
</body>
</html>
