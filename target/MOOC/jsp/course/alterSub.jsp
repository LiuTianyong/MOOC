<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/13
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改小节</title>
</head>
<body>
<form action="${ctx}/course/openSub" enctype="multipart/form-data" method="post">
    <%--小节ID--%>
    <%--小节所属小节ID--%>
        ${courseChapSub.subId}
    <input type="hidden" name="subId" value="${courseChapSub.subId}">
    <input type="hidden" name="chapId" value="${courseChapSub.chapId}">
    小节名称:<input type="text" name="subName" value="${courseChapSub.subName}"><br>
        小节PPT地址:<input type="hidden" name="subPpt" value="${courseChapSub.subPpt}">${courseChapSub.subPpt}<br>
    小节PPT:<input type="file" name="pptFile"><br>
        小节视频：<input type="hidden" name="subVideo" value="${courseChapSub.subVideo}">${courseChapSub.subVideo}<br>
    小节视频:<input type="file" name="VideoFile"><br>
    小节开设状态:<input type="text" name="subOpen" value="${courseChapSub.subOpen}"><br>
    小节知识点:<input type="text" name="subKnow" value="${courseChapSub.subKnow}"><br>
        小节资料地址：<input type="hidden" name="subMaterial" value="${courseChapSub.subMaterial}">${courseChapSub.subMaterial}<br>
    小节课程资料:<input type="file" name="MaterialFile"><br>
    <input type="submit" value="提交小节">
</form>
</body>
</html>
