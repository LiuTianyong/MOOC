<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/14
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开设章节</title>
</head>
<body>
    ${COURSECLASS}
    <div>
        <table border="1">
            <thead>
            <tr>
                <th colspan="5">
                    <h2>开设的章节</h2>
                </th>

            </tr>
            <tr>
                <th>章节名</th>
                <th>开设状态</th>
                <th>开始时间</th>
                <th>截至时间</th>
                <th>小节操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${courseChaps}" var="obj">
                <tr>
                    <td>${obj.chapName}</td>
                    <td>${obj.chapOpen}</td>
                    <td>${obj.chapBegin}</td>
                    <td>${obj.chapEnd}</td>
                    <td>
                        <form action="${ctx}/course/openSubMain">
                            <input type="hidden" name="chapId" value="${obj.chapId}">
                            <input type="submit" value="进入章节">
                        </form>
                    </td>
                    <td>
                        <form action="${ctx}/course/alterChap">
                            <input type="hidden" name="chapId" value="${obj.chapId}">
                            <input type="submit" value="修改章节">
                        </form>
                    </td>
                    <td>
                        <form action="${ctx}/course/deleteChap">
                            <input type="hidden" name="chapId" value="${obj.chapId}">
                            <input type="submit" value="删除章节">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <form action="${ctx}/course/openChap">
        <%--章节ID--%>
        <%--章节所属课程ID--%>
            <input type="text" name="classId" value="${COURSECLASS.classId}" style="display:none">
            <input type="text" name="courseId" value="${COURSECLASS.courseId}" style="display:none">
            <input type="text" name="className" value="${COURSECLASS.className}" style="display:none">
            <input type="text" name="classAmount" value="${COURSECLASS.classAmount}" style="display:none">
        章节名称:<input type="text" name="chapName">
        章节开设状态:<input type="text" name="chapOpen">
        章节开始时间:<input type="date" name="chapBegin" pattern="yyyy-MM-dd">
        章节结束时间:<input type="date" name="chapEnd" pattern="yyyy-MM-dd" >
        <input type="submit" value="增加章节">
    </form>
</body>
</html>
