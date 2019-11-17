<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 2019/4/20
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人中心信息修改</title>
</head>
<body>
    <form method="post" action="${ctx}/teacher/saveinfom">
    <div>ID：<input type="hidden" name="teacherId" value="${TEACHER.teacherId}"></div>
    <div>姓名：<input type="text" name="teacherName" value="${TEACHER.teacherName}"></div>
    <div>性别:<input type="text" id="teacherGender" name="teacherGender" value="${TEACHER.teacherGender}"/></div>
    <div>身份证：<input type="text" id="teacherUid" name="teacherUid" value="${TEACHER.teacherUid}"/></div>
    <div>手机号码：<input type="text" id="teacherPnum" name="teacherPnum" value="${TEACHER.teacherPnum}"/></div>
<div>所属机构：<input type="text" id="teacherOrgan" name="teacherOrgan" value="${TEACHER.teacherOrgan}"/></div>
<div>职称：<input type="text" id="teacherTitle" name="teacherTitle" value="${TEACHER.teacherTitle}"/></div>
<div>主攻方向：<input type="text" id="teacherDirect" name="teacherDirect" value="${TEACHER.teacherDirect}"/></div>
<div>简介：<input type="text" id="teacherIntro" name="teacherIntro" value="${TEACHER.teacherIntro}"/></div>
<div>审核状态：
    <c:if test="${TEACHER.teacherApprove == 1}">
        已通过
    </c:if>
    <c:if test="${TEACHER.teacherApprove == 0}">
        未通过
    </c:if>
</div>
<div><input type="submit" value="保存"/></div>
</form>
    <%--?userId=${lastermodify.teacherId}--%>
</body>
</html>
