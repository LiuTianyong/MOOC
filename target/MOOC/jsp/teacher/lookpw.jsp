<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 2019/4/24
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看密码</title>
</head>
<body>
        <%--查看密码并对其修改保存--%>
    <form method="post" action="${ctx}/teacher/changepassword">
    <div><input type="hidden" name="userId" value="${user1.userId}"></div>
    <div>账号：<input type="hidden" name="userAccount" value="${user1.userAccount}"> ${user1.userAccount}
    <div>密码：<input type="text" id="userPassword" name="userPassword" value="${user1.userPassword}"/></div>
    <input type="submit" value="保存修改" />
    </form>
</body>
</html>
