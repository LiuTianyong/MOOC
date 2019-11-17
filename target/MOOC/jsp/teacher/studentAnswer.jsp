<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div id="Correction">
    <div>
        <table>
            <thead>
            <tr>
                <th colspan="4">
                    <h2>批改作业</h2>
                </th>
            </tr>
            <tr>
                <th>学生姓名</th>
                <th>题目</th>
                <th>答案</th>
                <th>评分</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${studentAnswer4s}" var="obj">
                    <tr class="studentAnswer">
                        <td style="display:none">${obj.answerId}</td>
                        <td>${obj.studentName}</td>
                        <td>${obj.discussQue}</td>
                        <td>${obj.answerContent}</td>

                        <td style="display:none">${obj.queId}</td>
                        <td style="display:none">${obj.studentId}</td>
                        <td style="display:none">${obj.paperId}</td>
                        <td>
                            <input type="number" name="answerGrade" value="${obj.answerGrade}">
                        </td>
                    </tr>
                </c:forEach>
                <td colspan="2">
                    <input type="button" id="batchUpdate" value="提交">
                    <a href="javascript:history.go(-2);">返回</a>
                </td>
            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/plugins/jquery/jquery.js"></script>

<script type="text/javascript">
    $("#batchUpdate").click(function () {
        //评分对象集合
        var answerArr = [];
        $(".studentAnswer").each(function (trindex, tritem) {
            //查找一行中所有的td
            var line = $(tritem).find("td");
            //查找一行中的input标签，获取标签值，我将评分放在input标签中
            var answerGrade = $(tritem).find("input").val();
            //获取一行中第0列数据
            var answerId = line.eq(0).text();
            //构建answer对象，用来保存即将上传的answerid 和 分数
            var answer = {
                answerId:answerId,
                answerGrade: answerGrade
            }
            //将answer加入集合
            answerArr.push(answer)
        });
        //参数容器，将answerArr放入容器中便于后台获取
        var data={
            answerArr:answerArr
        };
        //ajax上传数据
        $.ajax({
            type: "POST",
            url:"${ctx}/coursePaperController/Givegrade",
            data: JSON.stringify(data),
            contentType : "application/json;charsetset=UTF-8",
            success: function (message) {
                //当后台返回succes时弹出提示
                if (message == "success") {
                    alert("评分成功");
                    history.go(-2);
                }
            },error: function (XMLHttpResponse, textStatus, errorThrown) {
                alert("评分失败");
                console.log("1 异步调用返回失败,XMLHttpResponse.readyState:"+XMLHttpResponse.readyState);
                console.log("2 异步调用返回失败,XMLHttpResponse.status:"+XMLHttpResponse.status);
                console.log("3 异步调用返回失败,textStatus:"+textStatus);
                console.log("4 异步调用返回失败,errorThrown:"+errorThrown);
            }
        })
    });
</script>
</body>
</html>
