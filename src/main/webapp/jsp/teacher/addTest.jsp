<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/20
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <script type="text/javascript" src="${ctx}/static/plugins/jquery/jquery.js"></script>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
    <style>
        .nav--title{
            font-size: 30px;
            margin-top: 10px;

            color: white;
        }
        fieldset{padding:.35em .625em .75em;margin:0 2px;border:2px solid grey}

        legend{padding:.5em;border:0;width:auto}

        .ui_button{
            display: inline-block;
            /*background-image: linear-gradient(#fbb2d0, #e779aa);*/
            padding: 0 20px 0 20px;
            font-size: 12px;
            text-decoration: none;
            color:#4B4B4B;
            height: 22px;
            line-height: 22px;
            border: 1px solid #ccc;
        }
        .layui-btn {
            display:inline-block;
            height:28px;
            line-height:28px;
            padding:0 18px;
            background-color:#009688;
            color:#fff;
            white-space:nowrap;
            text-align:center;
            font-size:14px;
            border:none;
            border-radius:2px;
            cursor:pointer
        }
        .layui-btn-primary {
            border:1px solid #C9C9C9;
            background-color:whitesmoke;
            /*#fff*/
            color:black;
        }
        .layui-btn-primary:hover {
            border-color: #009688;
            color:black;
        }
        .fieldset--style{

        }
        .fieldset--style input{
            margin-top: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
<!--顶部吸顶-->
<div class="container-fluid">  <!--BS的样式，实现居中-->
    <div class="float-row nav">
        <div class="nav--title col-md-4">MOOC慕课平台</div>
        <div class="layui-nav .col-md-8">
            <ul>
                <li class="layui-nav-item"><a href="">首页</a></li>
                <li class="layui-nav-item">
                    <a href="javascript:;">全部课程</a>
                    <dl class="layui-nav-child"> <!-- 二级菜单 -->
                        <dd><a href="">计算机</a></dd>
                        <dd><a href="">数学</a></dd>
                        <dd><a href="">心理学</a></dd>
                        <dd><a href="">法学</a></dd>
                        <dd><a href="">经济学</a></dd>
                        <dd><a href="">哲学</a></dd>
                        <dd><a href="">工学</a></dd>
                        <dd><a href="">历史</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">我的课程</a></li>
                <li class="layui-nav-item"><a href="">发布课程</a></li>
                <li class="layui-nav-item">
                    <a href="">个人中心<span class="layui-badge-dot"></span></a>
                </li>
                <li class="layui-nav-item">
                    <a href=""><img src="../../../images/headpic.png" class="layui-nav-img">我</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">修改信息</a></dd>
                        <dd><a href="javascript:;">退出登录</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <!--后续通过js绑定layui-bage来实现改变span的内容-->
                    <a href="">消息中心<span class="layui-badge">4</span></a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="placeHolder">
    <!--简易的实现一个吸顶效果，撑开页面-->
</div>
<!--顶部吸顶-->

<div id="father">
    <form action="${ctx}/coursePaperController/addTest" method="post" name="conform" class="conform" >
        <fieldset>
            <legend>习题</legend>
            <fieldset class="fieldset--style">
                <div class="910">
                    <ul>
                        题目：<input type="text" class="1010"  name="choiceQue" id="110"><br>
                        A: <input type="text" class="1010"  name="choiceA" id="210"><br>
                        B: <input type="text" class="1010"  name="choiceB" id="310"><br>
                        C: <input type="text" class="1010"  name="choiceC" id="410"><br>
                        D: <input type="text" class="1010"    name="choiceD" id="510"><br>
                        答案：<input type="text" class="1010"  name="choiceAnswer1" id="610"><br>
                        解析：<input type="text" class="1010"  name="choiceAnaly" id="710"><br>
                        知点：<input type="text" class="1010" name="choiceKnow" id="810">
                    </ul>
                </div>
                <legend>选择题</legend>
                <div id="select__table">

                </div>
                <input type="button" value="增加选择题" id="addselection" class="layui-btn layui-btn-radius layui-btn-primary"/>
            </fieldset>
            <fieldset class="fieldset--style">
                <legend>填空题</legend>
                <div class="1110">
                    <ul>
                        题目：<input type="text"  class="1210" name="blankQue" id="1710"><br>
                        答案：<input type="text" class="1210" name="blankAnswer1" id="1810"><br>
                        解析：<input type="text" class="1210" name="blankAnaly" id="1910"><br>
                        知识点：<input type="text" class="1210" name="blankKnow" id="2010" ><br>
                    </ul>
                </div>
                <div id="blank__table">

                </div>
                <input type="button" value="增加填空题" id="addblank" class="layui-btn layui-btn-radius layui-btn-primary"/>
            </fieldset>
            <fieldset class="fieldset--style">
                <legend>判断题</legend>
                <div class="1310">
                    <ul>
                        题目：<input type="text" class="1410"  name="judgeQue" id="2110"><br>
                        答案：<input type="text" class="1410" name="judgeAnswer" id="2210"><br>
                        解析：<input type="text" class="1410" name="judgeAnaly" id="2310"><br>
                        知识点：<input type="text" class="1410" name="judgeKnow" id="2410" ><br>
                    </ul>
                </div>
                <div id="judge__table">

                </div>
                <input type="button" value="增加判断题" id="addjudge" class="layui-btn layui-btn-radius layui-btn-primary"/>
            </fieldset>
            <fieldset class="fieldset--style">
                <legend>简答题</legend>
                <div class="1510">
                    <ul>
                        题目：<input type="text" class="1610" name="discussQue" id="2510"><br>
                        答案：<input type="text" class="1610" name="discussAnswer" id="2610"><br>
                        解析：<input type="text" class="1610" name="discussAnaly" id="2710"><br>
                        知识点：<input type="text" class="1610" name="discussKnow" id="2810" ><br>
                    </ul>
                </div>
                <div id="discuss__table">

                </div>
                <input type="button" value="增加简答题" id="adddiscuss" class="layui-btn layui-btn-radius layui-btn-primary"/>
            </fieldset>
        </fieldset>
    </form>


    <input type="button" value="提交试卷" id="submitPaper" class="layui-btn layui-btn-radius layui-btn-primary"/>
    <!--<input type="button" value="添加章节" id="addChapter" class="layui-btn layui-btn-radius layui-btn-primary"/>-->
</div>
<script>
    var choice_z="1";
    var btn = document.getElementById('addselection');
    var AA='110';
    var BB='210';
    var CC='310';
    var DD='410';
    var EE='510';
    var FF='610';
    var GG='710';
    var HH='810';
    var II='910';
    var JJ='1010';
    var choice_obj = [];
    btn.onclick = function () {
        var obj = {};
        function Map() {
            this.put = function (key, value) {
                obj[key] = value;//把键值绑定到obj对象上
            }
            //size方法，获取Map容器的个数
            this.size = function () {
                var count = 0;
                for (var attr in obj) {
                    count++;
                }
                return count;
            }
            //get方法，根据key获取value的值
            this.get = function (key) {
                if (obj[key] || obj[key] === 0 || obj[key] === false) {
                    return obj[key];
                } else {
                    return null;
                }
            }
            //remove方法,删除方法
            this.remove = function (key) {
                if (obj[key] || obj[key] === 0 || obj[key] === false) {
                    delete obj[key];
                }
            }
            //each方法,遍历方法
            this.eachMap = function (callBack) {
                for (var attr in obj) {
                    callBack(attr, obj[attr]);
                }
            }
        }

        var list = document.getElementsByClassName(JJ);
        for (var i = 0; i < list.length && list[i]; i++) //对表单中所有的input进行遍历
        {
            var key = list[i].name;
            var value = list[i].value;
            console.log(value);
            var m = new Map();
            m.put('"' + key + '"', value);
        }
        var choice_paperId = "paperId";
        var choice_paperNumber = "paperNumber";
        var choice_queType = "queType";
        var choiceType = "choiceType";
        var choiceGrade = "choiceGrade";
        m.put('"' + choice_paperId + '"', "2");
        m.put('"' + choice_paperNumber + '"', choice_z);
        m.put('"' + choice_queType + '"', "0");
        m.put('"' + choiceType + '"', "0");
        m.put('"' + choiceGrade + '"', null);
        console.log(obj);
        var obj1 = obj;
        choice_obj.push(obj1);
        console.log(choice_obj);
        AA++;
        BB++;
        CC++;
        DD++;
        EE++;
        FF++;
        GG++;
        HH++;
        II++;
        JJ++;
        choice_z++;
        var oTable = document.getElementById('select__table');
        var oTr = document.createElement('tr');
        var oTd1 = document.createElement('td');
        var oTd2 = document.createElement('td');
        var oTd3 = document.createElement('td');
        var oTd4 = document.createElement('td');
        var oTd5 = document.createElement('td');
        var oTd6 = document.createElement('td');
        var oTd7 = document.createElement('td');
        var oTd8 = document.createElement('td');
        var btn1 = document.createElement('button');
        oTr.innerHTML = '<hr><div class="' + II + '">\n' +
            '                    题目：<input type="text" class="' + JJ + '" name="choiceQue" id="' + AA + '"><br>\n' +
            '                    A: <input type="text" class="' + JJ + '" name="choiceA" id="' + BB + '"><br>\n' +
            '                    B: <input type="text" class="' + JJ + '" name="choiceB" id="' + CC + '"><br>\n' +
            '                    C: <input type="text" class="' + JJ + '" name="choiceC" id="' + DD + '"><br>\n' +
            '                    D: <input type="text" class="' + JJ + '" name="choiceD" id="' + EE + '"><br>\n' +
            '                    答案：<input type="text" class="' + JJ + '" name="choiceAnswer1" id="' + FF + '"><br>\n' +
            '                    解析：<input type="text" class="' + JJ + '" name="choiceAnaly" id="' + GG + '"><br>\n' +
            '                    知识点：<input type="text" class="' + JJ + '" name="choiceKnow" id="' + HH + '">\n' +
            '                </div>';
        btn1.innerHTML = '删除';
        btn1.setAttribute('onclick', 'del(this)');
        oTd1.setAttribute('aaa', 'val');
        oTr.appendChild(oTd1);
        oTr.appendChild(oTd2);
        oTr.appendChild(oTd3);
        oTr.appendChild(oTd4);
        oTr.appendChild(oTd5);
        oTr.appendChild(oTd6);
        oTr.appendChild(oTd7);
        oTd8.appendChild(btn1);
        oTr.appendChild(oTd8);
        oTable.appendChild(oTr);

        // }

    }
    //删除某一行
    function del(obj) {
        var oParent = obj.parentNode.parentNode;
        document.getElementById('select__table').removeChild(oParent);
    }

    //删除第一行
    function delFirst(obj) {
        var oParent = obj.parentNode.parentNode;
        document.getElementsByClassName('sele__del').removeChild(oParent);

    }
</script>
<script>
    //填空题
    var KK='1110';
    var LL='1210';
    var MM='1710'; var NN='1810'; var OO = '1910'; var PP = '2010';
    var blank_z="1";
    var blank_btn = document.getElementById('addblank');
    var blank_obj = [];
    blank_btn.onclick = function () {
        var obj5 = {};
        function blankMap() {
            this.put = function (key, value) {
                obj5[key] = value;//把键值绑定到obj对象上
            }
            //size方法，获取Map容器的个数
            this.size = function () {
                var count = 0;
                for (var attr in obj5) {
                    count++;
                }
                return count;
            }
            //get方法，根据key获取value的值
            this.get = function (key) {
                if (obj5[key] || obj[key] === 0 || obj5[key] === false) {
                    return obj5[key]
                } else {
                    return null;
                }
            }
            //remove方法,删除方法
            this.remove = function (key) {
                if (obj5[key] || obj5[key] === 0 || obj5[key] === false) {
                    delete obj5[key]
                }
            }
            //each方法,遍历方法
            this.eachMap = function (callBack) {
                for (var attr in obj5) {
                    callBack(attr, obj5[attr])
                }
            }
        }

        var blank_list = document.getElementsByClassName(LL);
        for (var i = 0; i < blank_list.length && blank_list[i]; i++) //对表单中所有的input进行遍历
        {
            var blank_key = blank_list[i].name;
            var blank_value = blank_list[i].value;
            var blank_m = new blankMap();
            blank_m.put('"' + blank_key + '"', blank_value);
        }
        var blank_queId="queId"; var blank_paperId = "paperId";var blank_paperNumber = "paperNumber";var queType = "queType";var blankGrade = "blankGrade";
        blank_m.put('"' + blank_queId + '"', "1");
        blank_m.put('"' + blank_paperId + '"', "2");
        blank_m.put('"' + blank_paperNumber + '"', blank_z);
        blank_m.put('"' + queType + '"', "0");
        blank_m.put('"' + blankGrade + '"', null);
        console.log(obj5);
        var obj4 =obj5;
        blank_obj.push(obj4);
        console.log(blank_obj);
        KK++;
        LL++;
        MM++;
        NN++;
        OO++;
        PP++;
        blank_z++;
        var blank_oTable = document.getElementById('blank__table');
        var blank_oTr = document.createElement('tr');
        var blank_oTd1 = document.createElement('td');
        var blank_oTd2 = document.createElement('td');
        var blank_oTd3 = document.createElement('td');
        var blank_oTd8 = document.createElement('td');
        var blank_btn1 = document.createElement('button');
        blank_btn1.innerHTML = '删除';
        blank_btn1.setAttribute('onclick','blank_del(this)');
        blank_oTr.innerHTML='<hr><div class="'+KK+'">\n' +
            '题目：<input type="text"  class="'+LL+'"  name="blankQue" id="'+MM+'"><br>\n' +
            '                答案：<input type="text" class="'+LL+'"  name="blankAnswer1" id="'+NN+'"><br>\n' +
            '                解析：<input type="text" class="'+LL+'"  name="blankAnaly" id="'+OO+'"><br>\n' +
            '                知识点：<input type="text" class="'+LL+'"  name="blankKnow" id="'+PP+'" ><br>\n' +
            '                </div>';
        blank_oTd1.setAttribute('aaa','val');
        blank_oTr.appendChild(blank_oTd1);
        blank_oTr.appendChild(blank_oTd2);
        blank_oTr.appendChild(blank_oTd3);
        blank_oTd8.appendChild(blank_btn1);
        blank_oTr.appendChild(blank_oTd8);
        blank_oTable.appendChild(blank_oTr);

    }
    //删除某一行
    function blank_del(obj){
        var blank_oParent = obj.parentNode.parentNode;
        document.getElementById('blank__table').removeChild(blank_oParent);}

</script>
<script>
    //判断题
    var judge_AA = '1310';
    var judge_BB = '1410';
    var judge_CC = '2110';
    var judge_DD = '2210';
    var judge_EE = '2310';
    var judge_FF = '2410';
    var judge_z = "1";
    var judge_obj3 = [];
    var judge_btn = document.getElementById('addjudge');

    judge_btn.onclick = function(){
        var judge_obj1 = {};
        function judgeMap() {
            this.put = function (key, value) {
                judge_obj1[key] = value;//把键值绑定到obj对象上
            }
            //size方法，获取Map容器的个数
            this.size = function () {
                var count = 0;
                for (var attr in judge_obj1) {
                    count++;
                }
                return count;
            }
            //get方法，根据key获取value的值
            this.get = function (key) {
                if (judge_obj1[key] || judge_obj1[key] === 0 || judge_obj1[key] === false) {
                    return judge_obj1[key]
                } else {
                    return null;
                }
            }
            //remove方法,删除方法
            this.remove = function (key) {
                if (judge_obj1[key] || judge_obj1[key] === 0 || judge_obj1[key] === false) {
                    delete judge_obj1[key]
                }
            }
            //each方法,遍历方法
            this.eachMap = function (callBack) {
                for (var attr in judge_obj1) {
                    callBack(attr, judge_obj1[attr])
                }
            }
        }

        var judge_list = document.getElementsByClassName(judge_BB);
        for (var i = 0; i < judge_list.length && judge_list[i]; i++) //对表单中所有的input进行遍历
        {
            var judge_key = judge_list[i].name;
            var judge_value = judge_list[i].value;
            var judge_m = new judgeMap();
            judge_m.put('"' + judge_key + '"', judge_value);
        }
        var judge_queId="queId"; var judge_paperId = "paperId";var judge_paperNumber = "paperNumber";var queType = "queType";var judgeGrade = "judgeGrade";
        judge_m.put('"' + judge_queId + '"', "1");
        judge_m.put('"' + judge_paperId + '"', "2");
        judge_m.put('"' + judge_paperNumber + '"', judge_z);
        judge_m.put('"' + queType + '"', "0");
        judge_m.put('"' + judgeGrade + '"', null);
        console.log(judge_obj1);
        var judge_obj2 =judge_obj1;
        judge_obj3.push(judge_obj2);
        console.log(judge_obj3);
        judge_AA++;
        judge_BB++;
        judge_CC++;
        judge_DD++;
        judge_EE++;
        judge_FF++;
        judge_z++;
        var judge_oTable = document.getElementById('judge__table');
        var judge_oTr = document.createElement('tr');
        var judge_oTd1 = document.createElement('td');
        var judge_oTd2 = document.createElement('td');
        var judge_oTd3 = document.createElement('td');
        var judge_oTd8 = document.createElement('td');
        var judge_btn1 = document.createElement('button');
        judge_btn1.innerHTML = '删除';
        judge_btn1.setAttribute('onclick','judge_del(this)');
        judge_oTr.innerHTML='<hr><div class="'+judge_AA+'">\n' +
            '                    <ul>\n' +
            '                    题目：<input type="text" class="'+judge_BB+'" name="judgeQue" id="'+judge_CC+'"><br>\n' +
            '                    答案：<input type="text" class="'+judge_BB+'" name="judgeAnswer" id="'+judge_DD+'"><br>\n' +
            '                    解析：<input type="text" class="'+judge_BB+'" name="judgeAnaly" id="'+judge_EE+'"><br>\n' +
            '                    知识点：<input type="text" class="'+judge_BB+'"  name="judgeKnow" id="'+judge_FF+'" ><br>\n' +
            '                    </ul>\n' +
            '                </div>';
        judge_oTd1.setAttribute('aaa','val');
        judge_oTr.appendChild(judge_oTd1);
        judge_oTr.appendChild(judge_oTd2);
        judge_oTr.appendChild(judge_oTd3);
        judge_oTd8.appendChild(judge_btn1);
        judge_oTr.appendChild(judge_oTd8);
        judge_oTable.appendChild(judge_oTr);

    }
    //删除第一行
    function judge_delFirst(obj) {
        var blank_oParent = obj.parentNode.parentNode;
        document.getElementById('judge__del').removeChild(blank_oParent);
    }
    //删除某一行
    function judge_del(obj){
        var judge_oParent = obj.parentNode.parentNode;
        document.getElementById('judge__table').removeChild(judge_oParent);
    }
</script>
<script>
    //简答题
    var discuss_AA = '1510';
    var discuss_BB = '1610';
    var discuss_CC = '2510';
    var discuss_DD = '2610';
    var discuss_EE = '2710';
    var discuss_FF = '2810';
    var discuss_z = "1";
    var discuss_obj3 = [];
    var discuss_btn = document.getElementById('adddiscuss');

    discuss_btn.onclick = function(){
        var discuss_obj1 = {};
        function discussMap() {
            this.put = function (key, value) {
                discuss_obj1[key] = value;//把键值绑定到obj对象上
            }
            //size方法，获取Map容器的个数
            this.size = function () {
                var count = 0;
                for (var attr in discuss_obj1) {
                    count++;
                }
                return count;
            }
            //get方法，根据key获取value的值
            this.get = function (key) {
                if (discuss_obj1[key] || discuss_obj1[key] === 0 || discuss_obj1[key] === false) {
                    return discuss_obj1[key]
                } else {
                    return null;
                }
            }
            //remove方法,删除方法
            this.remove = function (key) {
                if (discuss_obj1[key] || discuss_obj1[key] === 0 || discuss_obj1[key] === false) {
                    delete discuss_obj1[key]
                }
            }
            //each方法,遍历方法
            this.eachMap = function (callBack) {
                for (var attr in discuss_obj1) {
                    callBack(attr, discuss_obj1[attr])
                }
            }
        }

        var discuss_list = document.getElementsByClassName(discuss_BB);
        for (var i = 0; i < discuss_list.length && discuss_list[i]; i++) //对表单中所有的input进行遍历
        {
            var discuss_key = discuss_list[i].name;
            var discuss_value = discuss_list[i].value;
            var discuss_m = new discussMap();
            discuss_m.put('"' + discuss_key + '"', discuss_value);
        }
        var discuss_queId="queId"; var discuss_paperId = "paperId";var discuss_paperNumber = "paperNumber";var queType = "queType";var discussGrade = "discussGrade";
        discuss_m.put('"' + discuss_queId + '"', "1");
        discuss_m.put('"' + discuss_paperId + '"', "2");
        discuss_m.put('"' + discuss_paperNumber + '"', discuss_z);
        discuss_m.put('"' + queType + '"', "0");
        discuss_m.put('"' + discussGrade + '"', null);
        console.log(discuss_obj1);
        var discuss_obj2 =discuss_obj1;
        discuss_obj3.push(discuss_obj2);
        console.log(discuss_obj3);

        discuss_AA++;
        discuss_BB++;
        discuss_CC++;
        discuss_DD++;
        discuss_EE++;
        discuss_FF++;
        discuss_z++;

        var discuss_oTable = document.getElementById('discuss__table');
        var discuss_oTr = document.createElement('tr');
        var discuss_oTd1 = document.createElement('td');
        var discuss_oTd2 = document.createElement('td');
        var discuss_oTd3 = document.createElement('td');
        var discuss_oTd8 = document.createElement('td');
        var discuss_btn1 = document.createElement('button');
        discuss_btn1.innerHTML = '删除';
        discuss_btn1.setAttribute('onclick','discuss_del(this)');
        discuss_oTr.innerHTML='<hr><div class="'+discuss_AA+'">\n' +
            '                    <ul>\n' +
            '                    题目：<input type="text" class="'+discuss_AA+'" name="discussQue" id="'+discuss_AA+'"><br>\n' +
            '                    答案：<input type="text" class="'+discuss_AA+'" name="discussAnswer" id="'+discuss_AA+'"><br>\n' +
            '                    解析：<input type="text" class="'+discuss_AA+'" name="discussAnaly" id="'+discuss_AA+'"><br>\n' +
            '                    知识点：<input type="text" class="'+discuss_AA+'" name="discussKnow" id="'+discuss_AA+'" ><br>\n' +
            '                    </ul>\n' +
            '                </div>';
        discuss_oTd1.setAttribute('aaa','val');
        discuss_oTr.appendChild(discuss_oTd1);
        discuss_oTr.appendChild(discuss_oTd2);
        discuss_oTr.appendChild(discuss_oTd3);
        discuss_oTd8.appendChild(discuss_btn1);
        discuss_oTr.appendChild(discuss_oTd8);
        discuss_oTable.appendChild(discuss_oTr);

    }
    //删除某一行
    function discuss_del(obj){
        var discuss_oParent = obj.parentNode.parentNode;
        document.getElementById('discuss__table').removeChild(discuss_oParent);
    }
</script>
<script>
    var submit_btn = document.getElementById('submitPaper');
    submit_btn.onclick=function () {

        var mylist = ['7888','5655'];

        var obj = {};
        obj['objname'] = "obj";
        obj['pid'] = 1 ;
        obj['mylist'] = mylist;

        $.ajax({
            url: '${ctx}/coursePaperController/addTest',
            method: 'post',
            contentType: 'application/json', // 这句不加出现415错误:Unsupported Media Type
            data: JSON.stringify(obj), // 以json字符串方式传递
            success: function(data) {
                console.log("success...");
            },
            error: function(data) {
                console.log("error...");
            }
        });
    }
</script>
</body>
</html>
