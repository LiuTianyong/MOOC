<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sun.javafx.collections.MappingChange" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>答题</title>
    <script src="${ctx}/static/plugins/jquery/jquery.js"></script>
</head>
<body>

<script src="${ctx}/static/plugins/layui/layui.js"></script>

<input type="hidden" value="${paperId}" name="id" readonly="readonly">
<button onclick="displayDate()">开始答题</button>
<div>
    <div class="header">
        <span>题目</span>
    </div>
    <div class="select">
        <p>| 选择题</p>
        <div id="table">
            <span id="1000"></span>
            <span id="0"></span>
            <div class="font-size">
                A<input type="radio" name="select" value="A" title="" ><span id="100"></span> <br>
                B<input type="radio" name="select" value="B" title="" ><span id="200"></span> <br>
                C<input type="radio" name="select" value="C" title="" ><span id="300"></span> <br>
                D<input type="radio" name="select" value="D" title="" ><span id="400"></span> <br>
            </div>
        </div>
        <div class="blank">
            <p>| 填空题</p>
            <div id="table1">
                <span id="2000"></span>
                <span id="500"></span><br>
                <input type="text">
            </div>
        </div>


        <div class="judge">
            <p>| 判断题</p>
            <div id="table2">
                <span id="3000"></span>
                <span id="600"></span><br>
                对<input type="radio" name="judge" value="0" title="" ><br>
                错<input type="radio" name="judge" value="1" title="" ><br>
            </div>
        </div>


        <div class="discuss">
            <p>| 简答题</p>
            <div id="table3">
                <span id="4000"></span>
                <span id="700"></span><br>
                <input type="text">
            </div>
        </div>
    </div>

    <input type="hidden" value="${paperId}" name="paperId" readonly="readonly">
    <input type="hidden" value="${studentId}" name="studentId" readonly="readonly">
    <input type="hidden" value="${courseId}" name="courseId" readonly ="readonly">
    <button onclick="SummitTest()" >提交试卷</button>
</div>

<script>
    var timu=0;
    var A=100;
    var B=200;
    var C=300;
    var D=400;
    var E=500;
    var F=600;
    var G=700;
    var id1=1000;
    var id2=2000;
    var id3=3000;
    var id4=4000;

    layui.use(['element','jquery','layer'],function () {
        var element = layui.element;
        var jquery = layui.jquery;
        var layer = layui.layer;

    });
    function displayDate()
    {
        //获取名字
        var paperId = $('input[name=id]').val();

        $.ajax({
            url:'${ctx}/coursePaperController/pullTest?paperId='+ paperId,
            type:'get',
            success:function (data) {

                var choicelist = data.ChoiceList;
                var discusslist = data.DiscussList;
                var blanklist = data.BlankList;
                var judgelist = data.JudgeList;
                /*获取选择题*/
                document.getElementById(id1++).innerHTML =1+'.';
                document.getElementById(timu++).innerHTML = choicelist[0].choiceQue;
                document.getElementById(A++).innerHTML = choicelist[0].choiceA;
                document.getElementById(B++).innerHTML = choicelist[0].choiceB;
                document.getElementById(C++).innerHTML = choicelist[0].choiceC;
                document.getElementById(D++).innerHTML = choicelist[0].choiceD;
                for (i = 1; i < choicelist.length; i++){
                    myfunc();
                    document.getElementById(id1++).innerHTML =i+1+'.';
                    document.getElementById(timu++).innerHTML = choicelist[i].choiceQue;
                    document.getElementById(A++).innerHTML = choicelist[i].choiceA;
                    document.getElementById(B++).innerHTML = choicelist[i].choiceB;
                    document.getElementById(C++).innerHTML = choicelist[i].choiceC;
                    document.getElementById(D++).innerHTML = choicelist[i].choiceD;

                }
                var j=i+1;
                /*获取填空题*/
                document.getElementById(id2++).innerHTML =j+'.';
                document.getElementById(E++).innerHTML = blanklist[0].blankQue;
                for(i = 1; i < blanklist.length; i++){
                    myfunc1();
                    document.getElementById(id2++).innerHTML =(++j)+'.';
                    document.getElementById(E++).innerHTML = blanklist[i].blankQue;
                }

                /*获取判断题*/
                j++;
                document.getElementById(id3++).innerHTML =j+'.';
                document.getElementById(F++).innerHTML = judgelist[0].judgeQue;
                for(i = 1; i < judgelist.length; i++){
                    myfunc2();
                    document.getElementById(id3++).innerHTML =((++j))+'.';
                    document.getElementById(F++).innerHTML = judgelist[i].judgeQue;
                }
                /*获取简答题*/
                j++;
                document.getElementById(id4++).innerHTML =j+'.';
                document.getElementById(G++).innerHTML = discusslist[0].discussQue;
                for(i = 1; i < judgelist.length; i++){
                    myfunc3();
                    document.getElementById(id4++).innerHTML =(++j)+'.';
                    document.getElementById(G++).innerHTML =discusslist[i].discussQue;
                }
                /*document.getElementsByClassName("1A").innerHTML=data.code;*/
                /*       document.getElementById("demo3").innerHTML = data.DiscussList;
                       document.getElementById("demo4").innerHTML = data.BlankList;
                       document.getElementById("demo5").innerHTML = data.JudgeList;*/
            }
        })
    }

    function SummitTest() {
        //获取学生题型答案

        var paperId = $('input[name=paperId]').val();
        var studentId = $('input[name=studentId]').val();
        var courseId = $('input[name=courseId]').val();
        /* function Objdata() {
             this.key = key;
             this.value = value;
         }
         var list = document.getElementById("test").getElementsByTagName("input");
         var data = [];
         data["paperId"] = paperId;
         data["studentId"] = studentId;
         data["courseId"] = courseId;
         for (var i=0;i<list.length&&list[i];i++)
         {
             var key = list[i].name;
             var value = list[i].value;
             var s = new Objdata(key,value)
             data.push(s);
         }*/
        var map = '{"1":"'+"C"+'","2":"'+"B"+'","3":"'+"B"+'","4":"'+"D"+'","5":"'+"ABC"+'","6":"'+"C+"+'","7":"'+"Java"+'","8":"'+"1"+'","9":"'+"不知道啊"+'"}';
        console.log(map);
        $.ajax({
            url:'${ctx}/coursePaperController/submitPaper?paperId='+paperId+'&studentId='+studentId+'&courseId='+courseId,
            type : "POST",
            dataType:"json",
            data:map,
            contentType : "application/json;charset=UTF-8",
            <!-- 向后端传输的数据 -->
            success:function(data) {
                <!-- 处理后端返回的数据 -->
                $("info").html(data.success);
                alert("提交成功");
            },
            error:function(data){
                $("error").html(data.error);
                alert("提交失败");
            }

        })
    }


    /*<a href="${ctx}/coursePaperController/pullTest/2">下拉试卷</a>*/
    function myfunc3() {
        var oTable = document.getElementById('table3');
        var oTr = document.createElement('tr');
        var oTd1 = document.createElement('td');
        var oTd2 = document.createElement('td');
        oTr.innerHTML='<span id="'+id4+'"></span>' +
            '<span id="'+G+'"></span> <br>\n' +
            '                <input type="text">';
        oTd1.setAttribute('aaa','val');
        oTr.appendChild(oTd1);
        oTr.appendChild(oTd2);
        oTable.appendChild(oTr);
    }
    function myfunc2() {
        var oTable = document.getElementById('table2');
        var oTr = document.createElement('tr');
        var oTd1 = document.createElement('td');
        var oTd2 = document.createElement('td');
        var oTd3 = document.createElement('td');
        var oTd4 = document.createElement('td');
        oTr.innerHTML='<span id="'+id3+'"></span>' +
            '<span id="'+F+'"></span> <br>\n' +
            '                   对<input type="radio" name="sex" value="" title="" ><br>\n' +
            '                   错<input type="radio" name="sex" value="" title="" ><br>';
        oTd1.setAttribute('aaa','val');
        oTr.appendChild(oTd1);
        oTr.appendChild(oTd2);
        oTr.appendChild(oTd3);
        oTr.appendChild(oTd4);
        oTable.appendChild(oTr);
    }
    function myfunc1() {
        var oTable = document.getElementById('table1');
        var oTr = document.createElement('tr');
        var oTd1 = document.createElement('td');
        var oTd2 = document.createElement('td');
        var oTd3 = document.createElement('td');
        oTr.innerHTML='<span id="'+id2+'"></span>' +
            '<span id="'+E+'"></span> <br>\n' +
            '                <input type="text">';
        oTd1.setAttribute('aaa','val');
        oTr.appendChild(oTd1);
        oTr.appendChild(oTd2);
        oTr.appendChild(oTd3);
        oTable.appendChild(oTr);
    }
    function myfunc(){
        var oTable = document.getElementById('table');
        var oTr = document.createElement('tr');
        var oTd1 = document.createElement('td');
        var oTd2 = document.createElement('td');
        var oTd3 = document.createElement('td');
        var oTd4 = document.createElement('td');
        var oTd5 = document.createElement('td');
        var oTd6 = document.createElement('td');
        oTr.innerHTML='<br><span id="'+id1+'"></span>' +
            '<span id="'+timu+'"></span>\n' +
            '                <div class="font-size">\n' +
            '                    A<input type="radio" name="sex" value="" title="" checked><span id="'+A+'"></span> <br>\n' +
            '                    B<input type="radio" name="sex" value="" title="" ><span id="'+B+'"></span> <br>\n' +
            '                    C<input type="radio" name="sex" value="" title="" ><span id="'+C+'"></span> <br>\n' +
            '                    D<input type="radio" name="sex" value="" title="" ><span id="'+D+'"></span> <br>\n' +
            '                </div>';
        oTd1.setAttribute('aaa','val');
        oTr.appendChild(oTd1);
        oTr.appendChild(oTd2);
        oTr.appendChild(oTd3);
        oTr.appendChild(oTd4);
        oTr.appendChild(oTd5);
        oTr.appendChild(oTd6);
        oTable.appendChild(oTr);
    }
</script>

</form>

<script>
    // jquery
    $('input:radio').click(function(){
        var $radio = $(this);
        // if this was previously checked
        if ($radio.data('waschecked') === true){
            $radio.prop('checked', false);
            $radio.data('waschecked', false);
        } else {
            $radio.prop('checked', true);
            $radio.data('waschecked', true);
        }
    });
</script>
</body>
</html>
