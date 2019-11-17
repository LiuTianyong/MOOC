<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/6
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改班级信息</title>
    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
    <script type="text/javascript">
        // 控制onsubmit提交的方法，方法名是vform()
        function updateClass(){
            //获取下面的id值
            alert("确定修改?");
            var ci=$("#classId").val();
            var cn = $("#className").val();
            var ca = $("#classAmount").val();

            //判断上面的变量

            if(cn==""){
                alert("班级名称不能为空！");
                return false;
            }
            if(ca==""){
                alert("班级人数不能为空！");
                return false;
            }
            if(ca<=0){
                alert("班级人数输入有误！");
                return false;
            }
            alert("修改成功");

            return true;
        }
    </script>
</head>
<body>
${CLASSINFO}
<form action="${ctx}/class/updateClass/${CLASSINFO.classId}" method="post" onsubmit="return updateClass()">
    <%--班级ID:--%><input type="hidden" name="classId" value=" ${CLASSINFO.classId}"><br>
    班级名称:<input  type="text" name="className" value="${CLASSINFO.className}" ><br>
    班级人数上限:<input type="text" name="classAmount" value="${CLASSINFO.classAmount}"><br>
    <input type="submit" value="修改">

</body>
</html>
