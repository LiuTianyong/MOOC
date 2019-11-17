<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 2019/5/12
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的课程</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>课程名称</td>
        <td>课程专业类型</td>
        <td>课程简介</td>
        <td>课程开始时间</td>
        <td>课程结束时间</td>
        <td>课程开设状态</td>
        <td>课程公开状态</td>
        <td>课程考核状态</td>
        <td>课程密码</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${course}" var="course">
        <tr>
            <th>${course.courseName}</th>
            <th>${course.courseType}</th>
            <th>${course.courseIntro}</th>
            <th>${course.courseBegin}</th>
            <th>${course.courseEnd}</th>
            <th>${course.courseOpen}</th>
            <th>${course.coursePublic}</th>
            <th>${course.courseCheck}</th>
            <th>${course.coursePassword}</th>
                <c:if test="${(course.coursePublic==1 and course.courseCheck==0) or (course.coursePublic==0 and course.courseCheck==0)}">
            <th>
                <form action="${ctx}/course/createClass">
                    <input type="hidden" name="courseId" value="${course.courseId}">
                    <input type="submit" value="自动生成班级">
                </form>
                <c:if test="${course.courseOpen==1}">
                    <form action="${ctx}/course/closeCourse">
                        <input type="hidden" name="courseId" value="${course.courseId}">
                        <input type="hidden" name="teacherId" value="${course.teacherId}">
                        <input type="submit" value="关闭课程">
                    </form>
                </c:if>
                <c:if test="${course.courseOpen==0}">
                    <form action="${ctx}/course/openCourse">
                        <input type="hidden" name="courseId" value="${course.courseId}">
                        <input type="hidden" name="teacherId" value="${course.teacherId}">
                        <input type="submit" value="打开课程">
                    </form>
                </c:if>
            </th>
            </c:if>
            <c:if test="${(course.coursePublic==1 and course.courseCheck==1) or (course.coursePublic==0 and course.courseCheck==1)}">
                <th>
                    <form action="${ctx}/course/course">
                        <input type="hidden" name="courseId" value="${course.courseId}">
                        <input type="submit" value="开设班级">
                    </form>

                </th>
                <th>
                    <form action="${ctx}/class/queryClass">
                        <input type="hidden" name="courseId" value="${course.courseId}">
                        <input type="submit" value="查看班级">
                    </form>

                </th>
                <th>
                    <c:if test="${course.courseOpen==1}">
                        <form action="${ctx}/course/closeCourse">
                            <input type="hidden" name="courseId" value="${course.courseId}">
                            <input type="hidden" name="teacherId" value="${course.teacherId}">
                            <input type="submit" value="关闭课程">
                        </form>
                    </c:if>
                    <c:if test="${course.courseOpen==0}">
                        <form action="${ctx}/course/openCourse">
                            <input type="hidden" name="courseId" value="${course.courseId}">
                            <input type="hidden" name="teacherId" value="${course.teacherId}">
                            <input type="submit" value="打开课程">
                        </form>
                    </c:if>
                </th>
            </c:if>
            <th>
                <form action="${ctx}/teacher/alterCourse">
                    <input type="hidden" name="courseId" value="${course.courseId}">
                    <input type="submit" value="修改课程">
                </form>
            </th>
           <th>
               <form action="${ctx}/teacher/deleteCourse">
                   <input type="hidden" name="courseId" value="${course.courseId}">
                   <input type="hidden" name="teacherId" value="${course.teacherId}">
                   <input type="submit" value="删除课程">
               </form>
           </th>

        </tr>
    </c:forEach>

</table>
</body>
</html>