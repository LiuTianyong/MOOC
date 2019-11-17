<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>MOOC管理员系统</title>
    <link rel="stylesheet" href="../static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">管理员系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="../admin/login.jsp">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">老师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${ctx}/admin/adminTeacher">审核状态</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">学生管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${ctx}/admin/comstu" >学生评论区</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">课程管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${ctx}/admin/commark">课程评论区</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <%--<jsp:include page="../jsp/common/header.jsp"></jsp:include>--%>

    <div class="layui-body">
        <!-- 内容主体区域
        <div style="padding: 15px;">主题内容</div>-->
        <style>
            table tbody tr:nth-of-type(2n+1){
                background-color: coral;
            }
            table tbody tr:nth-of-type(2n+2){
                background-color: green;
            }
        </style>


        <div id="queryByTimeMark">
            <form action="${ctx}/admin/queryByTimeMark" name="queryByTimeMark">
               时间： <input type="date" name="startMarkTime" pattern="yyyy-MM-dd" value="<%=request.getParameter("startMarkTime")==null?"":request.getParameter("startMarkTime")%>"/>
                <input type="date" name="endMarkTime" pattern="yyyy-MM-dd" value="<%=request.getParameter("endMarkTime")==null?"":request.getParameter("endMarkTime")%>"/>
                课程名：<input type="text" name="courseName" value="<%=request.getParameter("courseName")==null?"":request.getParameter("courseName")%>"/>
                <input type="submit" value="查询" onclick="return check2(this.form)">
            </form>
            <script type="text/javascript">
                function check2(queryByTimeMark) {
                    if (queryByTimeMark.startMarkTime.value == ""){
                        alert("请输入正确的时间段");
                        return false
                    }

                    if (queryByTimeMark.endMarkTime.value == ""){
                        alert("请输入正确的时间段");
                        return false;
                    }
                    if (queryByTimeMark.courseName.value ==""){
                        return  queryByTimeMark.courseName.value=null;
                    }
                }
            </script>
        </div>

        <div>
            <table class="layui-table" border="1">
                <thead>
                <tr>
                    <th colspan="10">
                        <h2>课程评论区</h2>
                    </th>

                </tr>
                <tr>
                    <th>学生昵称</th>
                    <th>学生学号</th>
                    <th>所属机构</th>
                    <th>被评论老师账号</th>
                    <th>被评论老师名称</th>
                    <th>被评论课程</th>
                    <th>时间</th>
                    <th>评论内容</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${markList}" var="obj">
                    <tr>
                        <td>${obj.studentNumber}</td>
                        <td>${obj.studentName}</td>
                        <td>${obj.studentOrgan}</td>
                        <td>${obj.teacherId}</td>
                        <td>${obj.teacherName}</td>
                        <td>${obj.courseName}</td>
                        <td>${obj.comTime}</td>
                        <td>${obj.comContent}</td>
                        <td><a href="deleteMark?markId=${obj.markId}" onclick="return confirm('已删除')">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="../static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>
