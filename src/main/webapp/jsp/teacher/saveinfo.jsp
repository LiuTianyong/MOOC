<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 2019/4/20
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成功保存</title>
</head>
<body>

    <div>姓名：${teacherInfo1.teacherName}</div>
    <div>性别:
        <c:if test="${teacherInfo1.teacherGender == 1}">
            男
        </c:if>
        <c:if test="${teacherInfo1.teacherGender == 0}">
            女
        </c:if>
        </div>
    <div>身份证：${teacherInfo1.teacherUid}</div>
    <div>手机号码：${teacherInfo1.teacherPnum}</div>
    <div>所属机构：${teacherInfo1.teacherOrgan}</div>
    <div>职称：${teacherInfo1.teacherTitle}</div>
    <div>主攻方向：${teacherInfo1.teacherDirect}</div>
    <div>简介：${teacherInfo1.teacherIntro}</div>
</body>
</html>
