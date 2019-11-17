<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/13
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%/*获得系统时间sql.date*/
    String time=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间
    java.sql.Date comTime = java.sql.Date.valueOf(time);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/student/add" method="post">
    <input type="hidden" name="courseId" value="${courseId}">
    <input type="hidden" name="studentId" value="${studentId}">
    <input type="hidden" name="teacherId" value="${teacherId}">
    <input type="date" name = "comTime" value="<%=comTime%>" style="display:none">
    <table>
        <thead>
        <tr>
            <th colspan="2">增加评论</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>评论课程内容</td>
            <td>
                        <textarea name="comContent" rows="10" cols="40" >

                        </textarea>
            </td>
        </tr>
        <tr>
            <td>
                教师评分
            </td>
            <td>
                <input type="number" name="markTscore" >
            </td>
        </tr>
        <tr>
            <td>
                课程评分
            </td>
            <td>
                <input type="number" name="markCscore">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
                <a href="javascript:history.go(-2);">返回</a>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>