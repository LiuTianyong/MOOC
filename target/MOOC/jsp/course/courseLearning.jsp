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
                <h2>课程当前总体成绩</h2>
            </th>

        </tr>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>章节</th>
            <th>小节</th>
            <th>试卷分数</th>
            <th>课程成绩</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.studentCgradesList}" var="c">
            <tr>
                <td>${c.studentNumber}</td>
                <td>${c.studentName}</td>
                <td>${c.cgradeVideo}</td>
                <td>${c.cgradePaper}</td>
                <td>${c.cgradeExam}</td>
                <td>${c.cgradeSum}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div>
    <table border="1" width="800">
        <thead>
        <tr>
            <th colspan="6">
                <h2>课程总体视频进度</h2>
            </th>

        </tr>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>章节</th>
            <th>小节</th>
            <th>视频观看状态</th>
            <th>查看视频</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.videoCourseProgressList}" var="v">
            <tr>
                <td>${v.studentNumber}</td>
                <td>${v.studentName}</td>
                <td>${v.chapName}</td>
                <td>${v.subName}</td>
                <td>${v.videoToStatus}</td>
                <td><form>
                    <input type="submit" value="查看">
                </form></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>
    <table border="1" width="800">
        <thead>
        <tr>
            <th colspan="7">
                <h2>课程所有作业得分情况</h2>
            </th>

        </tr>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>章节</th>
            <th>小节</th>
            <th>试卷类型</th>
            <th>试卷分数</th>
            <th>查看试卷</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.studentPgradesList}" var="s">
            <tr>
                <td>${s.studentNumber}</td>
                <td>${s.studentName}</td>
                <td>${s.chapName}</td>
                <td>${s.subName}</td>
                <td>${s.paperToType}</td>
                <td>${s.pgradeGrade}</td>
                <td><form>
                    <input type="submit" value="查看">
                </form></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div>
    <table border="1" width="800">
        <thead>
        <tr>
            <th colspan="7">
                <h2>课程错题情况</h2>
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
        <c:forEach items="${requestScope.wrongCourseList}" var="w">
            <tr>
                <td>${w.studentNumber}</td>
                <td>${w.studentName}</td>
                <td>${w.subName}</td>
                <td>${w.queToType}</td>
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

