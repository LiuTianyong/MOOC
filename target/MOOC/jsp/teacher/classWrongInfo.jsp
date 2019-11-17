<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/8
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级错题情况</title>
</head>
<body>
<div>
    <table  border="1">
        <thead>
        <tr>
            <th colspan="2">
                <h2>班级错题信息</h2>
            </th>

        </tr>
        <tr>
            <td>错题知识点</td>
            <td>次数</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${KNOW}" var="kn">
            <tr>
                <th>${kn.wrong_know}</th>
                <th>${kn.wrong_sum}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
