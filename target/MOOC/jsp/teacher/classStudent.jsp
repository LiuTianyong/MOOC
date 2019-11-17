<%@ page import="com.usy.pojo.Course" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/26
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师课程班级信息</title>
</head>
<body>
${CLASSSTUDENT}
<c:if test="${CLASSSTUDENT.size()==0}">
    <script type="text/javascript">
        alert("该班级没有学生");
    </script>
</c:if>
<div>
    <table  border="1">
        <thead>
        <tr>
            <th colspan="7">
                <h2>班级学生信息</h2>
            </th>

        </tr>
        <tr>
            <td>学生名字</td>
            <td>学生学号</td>
            <td>学生视频总成绩</td>
            <td>学生试卷总成绩</td>
            <td>学生考试总成绩</td>
            <td>学生总成绩</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${CLASSSTUDENT}" var="cs" varStatus="status">
            <tr>
                <th>${cs.student_name}</th>
                <th>${cs.student_number}</th>
                <th>${cs.cgrade_video}</th>
                <th>${cs.cgrade_paper}</th>
                <th>${cs.cgrade_exam}</th>
                <th>${cs.cgrade_sum}</th>
                <th>
                    <a href="${ctx}/student/wrongPaper/${cs.student_id}">学生错题情况</a>
                    <a href="${ctx}/student/deleteStudent/ ${cs.student_id}/${cs.class_id}">删除学生</a>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
