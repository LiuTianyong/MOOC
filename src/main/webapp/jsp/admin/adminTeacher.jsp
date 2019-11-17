<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>MOOC管理员系统</title>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">管理员系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <div class="layui-nav layui-layout-body">
            <marquee scrollAmount=2 width=900>数据无价，请谨慎操作！</marquee>
        </div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    管理员：${USER.userAccount}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="../jsp/login.jsp">退了</a></li>
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
        <form class="layui-form" action="${ctx}/admin/teacherApprove">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">搜索选择框</label>
                    <div class="layui-input-inline">
                        <select name="teacherApprove">
                            <option value=""></option>
                            <option value="0">未通过</option>
                            <option value="1">通过</option>
                            <option value="2">审核中</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
                    </div>
                </div>
            </div>
        </form>
        <div>
            <table class="layui-table" border="1">
                <colgroup>
                    <col width="150">
                    <col width="200">
                </colgroup>
                <thead>
                <tr>
                    <th colspan="5">
                        <h2>教师信息</h2>
                    </th>

                </tr>
                <tr>
                    <td>教师ID</td>
                    <td>教师姓名</td>
                    <td>教师身份证号</td>
                    <td>教师审核状态</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${admin}" var="obj">
                    <tr>
                        <c:if test="${obj.teacherApprove == 2 }">
                            <th>${obj.teacherId}</th>
                            <th>${obj.teacherName}</th>
                            <th>${obj.teacherUid}</th>
                            <th>审核中</th>
                            <td>
                                <a  href="updateInfo?updateId=${obj.teacherId}&amp;updateInfo=${1}" class="layui-btn" >通过</a>
                                <a  href="updateInfo?updateId=${obj.teacherId}&amp;updateInfo=${0}" class="layui-btn layui-btn-danger" >不通过</a>
                            </td>
                        </c:if>
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
<script src="${ctx}/static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
        form.render();
    });
</script>
</body>
</html>
