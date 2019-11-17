<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/15
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table border="1" width="800">
        <thead>
        <tr>
            <th colspan="7">
                <h2>学习情况</h2>
            </th>

        </tr>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>小节</th>
            <th>题目类型</th>
            <th>知识点</th>
            <th>错误次数</th>
            <th>查看题目</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${wrongChapList}" var="w">
            <tr>
                <td>${w.studentNumber}</td>
                <td>${w.studentName}</td>
                <td>${w.subName}</td>
                <td>${w.queType}</td>
                <td>${w.wrongKnow}</td>
                <td>${w.wrongSum}</td>
                <td><form>
                    <input type="submit" value="查看">
                </form></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
