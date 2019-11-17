<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="章节开设状态" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/21
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程章节信息</title>
</head>
<body>
${COURSECLASS}
${COURSECHAP}
<a>课程章节信息</a><br>
<form action="">
    <%--章节ID--%>
    <%--章节所属课程ID--%><input type="text" name="courseId" value="${COURSECLASS.courseId}" style="display:none">
<c:forEach items="${COURSECHAP}" var="cou">
    章节名称:<input type="text" name="chapName" value="${cou.chapName}">
    <c:if test="${cou.chapOpen==1}">
    章节开设状态:<input type="text" name="chapOpen" value="开">
   </c:if>
    <c:if test="${cou.chapOpen==0}">
        章节开设状态:<input type="text" name="chapOpen" value="关">
    </c:if>
    章节开始时间:<input type="text" name="chapBegin" value="${cou.chapBegin}">
    章节结束时间<input type="text" name="chapEnd" value="${cou.chapEnd}">
</c:forEach>

</form>
</body>
</html>
