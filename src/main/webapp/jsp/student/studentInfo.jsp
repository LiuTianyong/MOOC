<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/20
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生基本资料</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">


    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
    <script type="text/javascript">
        // 控制onsubmit提交的方法，方法名是vform()
        function vform(){
            //获取下面的id值
            var ln = $("#studentName").val();
            var lp = $("#studentHp").val();
            var un = $("#studentGender").val();
            var bir = $("#studentPnum").val();
            var s1 = $("#studentOrgan").val();
            var s2 = $("#studentPrefer").val();
            alert("确定修改？")
            alert("修改成功")
            return true;
        }
    </script>
</head>
<body>
${USER}
<script src="${ctx}/static/plugins/layui/layui.js"></script>
我的头像:<a><img src="${ctx}/${STUDENT.studentHp}"/></a><br>
<form action="${ctx}/file/uploadimage" method="post" enctype="multipart/form-data">
    上传头像:<input type="file" name="file"><br>
    <input type="submit" value="修改头像"><br>
</form>
<form action="${ctx}/student/updateStudentInfo?userId=${USER.userId}" method="post" onsubmit="return vform()">
    <input type="hidden" name="studentId"  value="${STUDENT.studentId}"><br>
        学生昵称：<input type="text" name="studentName" id="studentName" value="${STUDENT.studentName}"><br>
        <%--<c:if test="${stu.studentGender==1}">
            学生性别：
            男<input type="radio" name="studentGender" id="studentGender" value="1" checked="checked">
            女<input type="radio" name="studentGender" id="studentGender" value="0"><br>
        </c:if>
        <c:if test="${stu.studentGender==0}">
            学生性别：
            男<input type="radio" name="studentGender" id="studentGender" value="${stu.studentGender==1}">
            女<input type="radio" name="studentGender" id="studentGender" value="${stu.studentGender==0}" checked="checked"><br>
            >
        </c:if>--%>
        学生性别：<input type="text" name="studentGender" id="studentGender" value="${STUDENT.studentGender}"><br>
        学生学号：<input type="text" name="studentNumber" id="studentNumber" value="${STUDENT.studentNumber}"><br>
        学生手机号：<input type="text" name="studentPnum" id="studentPmum" value="${STUDENT.studentPnum}"><br>
        学所属机构：<input type="text" name="studentOrgan" id="studentOrgan" value="${STUDENT.studentOrgan}"><br>
        学生偏好：<input type="text" name="studentPrefer" id="studentPrefer" value="${STUDENT.studentPrefer}"><br>
    <input type="submit" value="修改信息">
</form>
</body>
</html>
