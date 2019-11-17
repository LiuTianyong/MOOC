<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/8
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生错题信息</title>
</head>
<body>
        <a>选择题</a><br>
<c:forEach items="${WRONGCHOICE}" var="wr" varStatus="status">
        ${wr.paper_number}、题目:<a>${wr.choice_que}<a><br>
        A<input type="radio" name="select" >${wr.choice_a}
        B<input type="radio" name="select"  >${wr.choice_b}
        C<input type="radio" name="select" >${wr.choice_c}
        D<input type="radio" name="select" >${wr.choice_d}<br>

        学生答案:<a>${wr.answer_content1}</a><br>
        正确答案:<a>${wr.choice_answer1}</a><br>
            </c:forEach>
            <a>填空题</a><br>
            <c:forEach items="${WRONGBLANK}" var="wb" varStatus="status">
                ${wb.paper_number}、题目：<a>${wb.blank_que}<a><br>
                    学生答案:<a>${wb.answer_content1}<a><br>


                        </c:forEach>
                    <a>判断题</a><br>
                        <c:forEach items="${WRONGJUDGE}" var="wj" varStatus="status">
                        ${wj.paper_number}、判断题题目：<a>${wj.judge_que}<a><br>
                            学生答案:<a>${wj.answer_content}<a><br>
                                正确答案:<a>${wj.judge_answer}<br>
                            </c:forEach >
                                <a>简答题</a><br>
                      <c:forEach items="${WRONGDISSCUSS}" var="wd" varStatus="status">
                                    ${wd.paper_number}、简答题题目：<a>${wd.discuss_que}<a><br>
                                     学生答案:<a>${wd.answer_content}<a><br>
                                   正确答案:<a>${wd.discuss_answer}<br>
                                                </c:forEach>

</body>
</html>
