package com.usy.controller;

import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
import com.usy.pojo.*;
import com.usy.service.CoursePaperService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 试卷相关操作
 */
@Controller
@RequestMapping("/coursePaperController")
public class CoursePaperController {

    @Autowired
    private CoursePaperService coursePaperService;

    @RequestMapping("/studentTest")
    public String studentTest(@RequestParam("subId") Integer subId,@RequestParam("studentId") Integer studentId,
                              @RequestParam("courseId")Integer courseId,Model model){
        Integer paperId = coursePaperService.queryBysubIdPaperId(subId);
        model.addAttribute("paperId",paperId);
        model.addAttribute("studentId",studentId);
        model.addAttribute("courseId",courseId);
        return "student/answer";
    }

    /**
     * 拉取整个试卷 按试卷ID 用于学生答题时
     * @param paperId
     * @return
     */
    @RequestMapping("/pullTest")
    @ResponseBody
    public Map<String,Object> pullTest(@RequestParam("paperId") Integer paperId){
        Map<String,Object> map = new HashMap<>();

        map.put("code","200");

        System.out.println(paperId);
        //选择题查询结果
        List<PaperChoice> paperChoiceList = coursePaperService.selectPaperChoice(paperId);
        System.out.println(paperChoiceList);
        map.put("ChoiceList",paperChoiceList);

        //填空题查询结果
        List<PaperBlank> paperBlankList = coursePaperService.selectPaperBlank(paperId);
        System.out.println(paperBlankList);
        map.put("BlankList",paperBlankList);

        //简答题查询结果
        List<PaperDiscuss> paperDiscussList = coursePaperService.selectPaperDiscuss(paperId);
        System.out.println(paperDiscussList);
        map.put("DiscussList",paperDiscussList);

        //判断题查询结果
        List<PaperJudge> paperJudgeList = coursePaperService.selectPaperJudge(paperId);
        System.out.println(paperJudgeList);
        map.put("JudgeList",paperJudgeList);

        return map;
    }

    @RequestMapping(value = "/submitPaper",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> submitPaper(@RequestBody Map map,@RequestParam("paperId")Integer paperId,
                                          @RequestParam("studentId")Integer studentId,@RequestParam("courseId")Integer courseId)throws Exception{
        CoursePaper coursePaper = coursePaperService.selectBypaperId(paperId);
        List<PaperChoice> paperChoiceList = coursePaperService.selectPaperChoice(paperId);//调出选择题答案
        List<PaperBlank> paperBlankList = coursePaperService.selectPaperBlank(paperId);//调出填空题答案
        List<PaperDiscuss> paperDiscussList = coursePaperService.selectPaperDiscuss(paperId);//调出判断题答案
        List<PaperJudge> paperJudgeList = coursePaperService.selectPaperJudge(paperId);//调出选择题答案
        List<StudentAnswer1> studentAnswer1 = coursePaperService.selectStuAnswer1(paperId,studentId);//调出学生选择答案表
        List<StudentAnswer2> studentAnswer2 = coursePaperService.selectStuAnswer2(paperId,studentId);//调出学生填空答案表
        List<StudentAnswer3> studentAnswer3 = coursePaperService.selectStuAnswer3(paperId,studentId);//调出学生判断答案表
        List<StudentAnswer4> studentAnswer4 = coursePaperService.selectStuAnswer4(paperId,studentId);//调出学生简答答案表
        Boolean firstAnswer = false;
        if (studentAnswer1.size()==0&&studentAnswer2.size()==0&&studentAnswer3.size()==0&&studentAnswer4.size()==0) {//第一次答题
            firstAnswer = true;
        }else {
            //若不是第一次答题，清空学生答案
            studentAnswer1.clear();
            studentAnswer2.clear();
            studentAnswer3.clear();
            studentAnswer4.clear();
        }
        //对jsp传过来得学生答案与数据库中存储得答案进行对比，并将学生答案存入学生答案表
        for (Object key: map.keySet()
        ) {
            int i = Integer.parseInt(key.toString());
            String str = String.valueOf(map.get(key));
            //选择题
            for (PaperChoice choice: paperChoiceList
            ) {
                if (choice.getPaperNumber().equals(i)){
                    StudentAnswer1 answer1 = new StudentAnswer1();
                    answer1.setPaperId(paperId);
                    answer1.setStudentId(studentId);
                    answer1.setQueType(choice.getQueType());
                    answer1.setQueId(choice.getQueId());
                    answer1.setAnswerContent1(str);
                    if (choice.getChoiceAnswer1().equals(str)){
                        answer1.setAnswerRight(1);
                        answer1.setAnswerGrade(choice.getChoiceGrade());
                    }
                    else if (choice.getChoiceAnswer1().contains(str)){
                        answer1.setAnswerRight(0);
                        choice.setChoiceGrade((int) Math.ceil(choice.getChoiceGrade()/2));
                        answer1.setAnswerGrade(choice.getChoiceGrade());
                        answer1.setWrongKnow(choice.getChoiceKnow());
                        coursePaperService.insertStudentWrong(answer1);
                    }else {
                        answer1.setAnswerRight(0);
                        answer1.setAnswerGrade(0);
                        answer1.setWrongKnow(choice.getChoiceKnow());
                        coursePaperService.insertStudentWrong(answer1);
                    }
                    studentAnswer1.add(answer1);
                }
            }
            //填空题
            for (PaperBlank blank: paperBlankList
            ) {
                StudentAnswer2 answer2 = new StudentAnswer2();
                if (blank.getPaperNumber().equals(i)){
                    if (blank.getBlankAnswer1()!=null) {
                        answer2.setPaperId(paperId);
                        answer2.setStudentId(studentId);
                        answer2.setQueType(blank.getQueType());
                        answer2.setQueId(blank.getQueId());
                        answer2.setAnswerContent1(str);
                        if (blank.getBlankAnswer1().equals(map.get(key))) {
                            answer2.setAnswerRight(1);
                            answer2.setAnswerGrade(blank.getBlankGrade());
                        }else{
                            answer2.setAnswerRight(0);
                            answer2.setAnswerGrade(0);
                            answer2.setWrongKnow(blank.getBlankKnow());
                            coursePaperService.insertStudentWrong(answer2);
                        }
                    }
                    studentAnswer2.add(answer2);
                }
            }
            //判断题
            for (PaperJudge judge :paperJudgeList
            ) {
                StudentAnswer3 answer3 = new StudentAnswer3();
                if (judge.getPaperNumber().equals(i)){
                    answer3.setPaperId(judge.getPaperId());
                    answer3.setStudentId(studentId);
                    answer3.setQueType(judge.getQueType());
                    answer3.setQueId(judge.getQueId());
                    answer3.setAnswerContent(Integer.parseInt(str));
                    if (judge.getJudgeAnswer().equals(Integer.parseInt(str))){
                        answer3.setAnswerRight(1);
                        answer3.setAnswerGrade(judge.getJudgeGrade());
                    }else {
                        answer3.setAnswerRight(0);
                        answer3.setAnswerGrade(0);
                        answer3.setWrongKnow(judge.getJudgeKnow());
                        coursePaperService.insertStudentWrong(answer3);
                    }
                    studentAnswer3.add(answer3);
                }
            }
            //简答题
            for (PaperDiscuss discuss: paperDiscussList
            ) {
                if (discuss.getPaperNumber().equals(i)) {
                    StudentAnswer4 answer4 = new StudentAnswer4();
                    answer4.setPaperId(discuss.getPaperId());
                    answer4.setStudentId(studentId);
                    answer4.setQueType(discuss.getQueType());
                    answer4.setQueId(discuss.getQueId());
                    answer4.setAnswerContent(str);
                    if (discuss.getDiscussAnswer().equals(str)){
                        answer4.setAnswerRight(1);
                        answer4.setAnswerGrade(discuss.getDiscussGrade());
                    }else{
                        answer4.setAnswerRight(0);
                        answer4.setAnswerGrade(0);
                        answer4.setWrongKnow(discuss.getDiscussKnow());
                        coursePaperService.insertStudentWrong(answer4);
                    }
                    studentAnswer4.add(answer4);
                }
            }
        }
        if (firstAnswer==true) {//第一次答题
            coursePaperService.insertStuChoiceList(studentAnswer1);//插入学生选择答案表
            coursePaperService.insertStuBlankList(studentAnswer2);//插入学生填空答案表
            coursePaperService.insertStuJudgeList(studentAnswer3);//插入学生判断答案表
            coursePaperService.insertStuDiscussList(studentAnswer4);//插入学生判断答案表
            coursePaperService.insertStuPgrade(paperId,studentId);//插入学生测试得分表
        } else {
            try {
                coursePaperService.updateStuChoiceList(studentAnswer1);//更新学生选择答案表
                coursePaperService.updateStuBlankList(studentAnswer2);//更新学生填空答案表
                coursePaperService.updateStuJudgeList(studentAnswer3);//更新学生判断答案表
                coursePaperService.updateStuDiscussList(studentAnswer4);//更新学生判断答案表
                coursePaperService.updateStuPgrade(paperId,studentId);//更新学生测试得分表
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (coursePaper.getPaperType()<3){//章节和小节测试
            coursePaperService.updateCgradePaper(studentId,courseId);//更新学生总成绩的paper部分成绩
        }else {
            coursePaperService.updateCgradeExam(studentId,courseId);//更新学生总成绩的Exam部分成绩
        }
        coursePaperService.updateStuCgradeSum(courseId);//更新学生总成绩表总和
        map.put("success","success");
        return map;
    }

   /* @RequestMapping("/submitPaper")
    @ResponseBody
    public Map<String,Object> submitPaper(List<StudentAnswer1> studentAnswer1,List<StudentAnswer2> studentAnswer2,List<StudentAnswer3> studentAnswer3 ,List<StudentAnswer4> studentAnswer4,
                                          @RequestParam("paperId") Integer paperId,@RequestParam("studentId") Integer studentId,@RequestParam("courseId") Integer courseId){
        Map<String,Object> map = new HashMap<>();
        List<PaperChoice> paperChoiceList = coursePaperService.selectPaperChoice(paperId);
        List<PaperBlank> paperBlankList = coursePaperService.selectPaperBlank(paperId);
        List<PaperDiscuss> paperDiscussList = coursePaperService.selectPaperDiscuss(paperId);
        List<PaperJudge> paperJudgeList = coursePaperService.selectPaperJudge(paperId);
        //选择题分数统计
        for (StudentAnswer1 stuAnswer1: studentAnswer1
        ) {
            for (PaperChoice choice: paperChoiceList
            ) {
                if (choice.getPaperNumber().equals(stuAnswer1.getPaperNumber())){
                    if (choice.getChoiceAnswer1().equals(stuAnswer1.getAnswerContent1())){
                        stuAnswer1.setAnswerRight(1);
                        stuAnswer1.setAnswerGrade(choice.getChoiceGrade());
                    }else {
                        stuAnswer1.setAnswerRight(0);
                        stuAnswer1.setAnswerGrade(0);
                        stuAnswer1.setWrongKnow(choice.getChoiceKnow());//插入错题表的题型知识点
                        coursePaperService.insertStudentWrong(stuAnswer1);//学生错题插入错题表
                    }
                }
            }
            coursePaperService.insertStuChoiceList(stuAnswer1);//将学生的选择题答案插入选择题答案表
        }
        //填空题分数统计
        for (StudentAnswer2 stuAnswer2:studentAnswer2
        ) {
            for (PaperBlank blank: paperBlankList
            ) {
                int SpaceCount = 0;//记录空格数，用来判断填空的个数
                char[] ch = blank.getBlankAnswer1().toCharArray();//字符串转数组
                for (int i=0;i<blank.getBlankAnswer1().length();i++){
                    if (Character.isSpaceChar(ch[i])){
                        SpaceCount++;
                    }
                }
                if(blank.getPaperNumber().equals(stuAnswer2.getPaperNumber())){
                    if (blank.getBlankAnswer1().equals(stuAnswer2.getAnswerContent1())){
                        stuAnswer2.setAnswerRight(1);
                        stuAnswer2.setAnswerGrade(blank.getBlankGrade());
                    }else {
                        stuAnswer2.setAnswerRight(0);
                        stuAnswer2.setAnswerGrade(0);
                        stuAnswer2.setWrongKnow(blank.getBlankKnow());//插入错题表的题型知识点
                        coursePaperService.insertStudentWrong(stuAnswer2);//学生错题插入错题表
                    }
                }
            }
            coursePaperService.insertStuBlankList(stuAnswer2);//将学生的填空题答案插入填空题答案表
        }

        //判断题分数统计
        for (StudentAnswer3 stuAnswer3: studentAnswer3
        ) {
            for (PaperJudge judge :paperJudgeList
            ) {
                if (judge.getPaperNumber().equals(stuAnswer3.getPaperNumber())){
                    if (judge.getJudgeAnswer().equals(stuAnswer3.getAnswerContent())){
                        stuAnswer3.setAnswerRight(1);
                        stuAnswer3.setAnswerGrade(judge.getJudgeGrade());
                    }else {
                        stuAnswer3.setAnswerRight(0);
                        stuAnswer3.setAnswerGrade(judge.getJudgeGrade());
                        stuAnswer3.setWrongKnow(judge.getJudgeKnow());//插入错题表的题型知识点
                        coursePaperService.insertStudentWrong(stuAnswer3);//学生错题插入错题表
                    }
                }
            }
            coursePaperService.insertStuJudgeList(stuAnswer3);//将学生的判断题答案插入判断题答案表
        }
        //简答题后台给出部分
        for (StudentAnswer4 stuAnswer4: studentAnswer4
        ) {
            for (PaperDiscuss discuss: paperDiscussList
            ) {
                if (discuss.getPaperNumber().equals(stuAnswer4.getPaperNumber())) {
                    if (discuss.getDiscussAnswer().equals(stuAnswer4.getAnswerContent())) {
                        stuAnswer4.setAnswerGrade(discuss.getDiscussGrade());
                    } else {
                        stuAnswer4.setAnswerGrade(0);
                        stuAnswer4.setWrongKnow(discuss.getDiscussKnow());//插入错题表的题型知识点
                        coursePaperService.insertStudentWrong(stuAnswer4);//学生错题插入错题表
                    }
                }
            }
            coursePaperService.insertStuDiscussList(stuAnswer4);//将学生的简答题答案插入简答题答案表
        }
        coursePaperService.updataStuCgradeSum(courseId);//更新学生总成绩表总和
        coursePaperService.updataCgradePaper(studentId,courseId);//更新学生总成绩的paper部分成绩
        coursePaperService.updataStuPgrade(paperId,studentId);//更新学生测试得分表
        return map;
    }*/

   @RequestMapping("/test")
   public String Test(@RequestParam("subId")Integer subId, @RequestParam("paperType")Integer paperType, Model model){
        model.addAttribute("subId",subId);
        model.addAttribute("paperType",paperType);
        return "/teacher/addTest";
   }

    @RequestMapping("/addTest")
    @ResponseBody
    public Map<String,CoursePaper> addTest(@RequestBody Map<String, List> map){
        System.out.println("得到的Map： " + map);
        System.out.println("得到list:" + map.get("mylist"));
        List list = map.get("mylist");
        for (Object object:list){
             System.out.println(object.toString());
        }
        System.out.println("键objname的值："+ map.get("objname"));
        System.out.println("键pid的值："+ map.get("pid"));
        CoursePaper coursePaper = new CoursePaper();
        // 模拟得到数据
        coursePaper.setPaperName("单元测试");
        coursePaper.setPaperSum(100);
        coursePaper.setPaperType(1);
        coursePaper.setPaperIntro("第六章什么玩意测试");

        //给数据库插入一份试卷 并返回其主键
        coursePaperService.insertCoursePaper(coursePaper);
        System.out.println(coursePaper.getPaperId());
        System.out.println(coursePaper);

        // 模拟一份试卷的选择题
        PaperChoice paperChoice = new PaperChoice();
        //模拟赋值
        paperChoice.setPaperId(coursePaper.getPaperId());
        paperChoice.setPaperNumber(1);
        paperChoice.setQueType(1);
        paperChoice.setChoiceQue("C#之父是谁?");
        //选择题；类型 0多选  1单选
        paperChoice.setChoiceType(1);
        paperChoice.setChoiceA("不知道");
        paperChoice.setChoiceB("11111");
        paperChoice.setChoiceC("不知111111道");
        paperChoice.setChoiceD("不知111111道");
        paperChoice.setChoiceAnswer1("A");
        paperChoice.setChoiceAnaly("解析");
        paperChoice.setChoiceKnow("知识点");
        paperChoice.setChoiceGrade(2);

        //插入到数据库 选择题
        coursePaperService.insertPaperChoice(paperChoice);

        // 模拟一份试卷的填空题 填空题
        PaperBlank paperBlank = new PaperBlank();

        coursePaperService.insertPaperBlank(paperBlank);

        //模拟一份试卷的判断题  判断题
        PaperJudge paperJudge = new PaperJudge();

        coursePaperService.insertPaperJudge(paperJudge);

        //模拟一份试卷的简答题  简答题
        PaperDiscuss paperDiscuss = new PaperDiscuss();
        coursePaperService.insertPaperDiscuss(paperDiscuss);
        return null;
    }

    //老师改试卷简答题
    //批改学生简答题答案
    @RequestMapping("/Correction/{classId}")
    public String Correction(@PathVariable("classId")Integer classId, Model model){
        model.addAttribute("classId",classId);
        List<StudentAnswer4> studentAnswer4s =coursePaperService.correctionanswer4(classId);
        model.addAttribute("studentAnswer4s",studentAnswer4s);
        return "/teacher/studentAnswer";
    }

    /**
     * 批量修改逻辑：因数据库中表student_answer4中answer_id为主键，主键是唯一的，前端只需要将主键和分数传递到后台，就可以实现评分修改
     * @param object json对象（包含student_answer4数组）
     * @return
     */
    //教师给出学生简答题分数
    @RequestMapping("/Givegrade")
    @ResponseBody
    public String Givegrade(@RequestBody JSONObject object){
        //创建StudentAnswer4集合用于保存转化后的studentAnswer对象
        List<StudentAnswer4> studentAnswerList = new ArrayList<>();
        //将json格式数据转换为json数组对象
        JSONArray jsonArray=object.getJSONArray("answerArr");

        //遍历json数组
        for(int i=0;i<jsonArray.size();i++){
            //获取jsonObject对象
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            //强转StudentAnswer4对象
            StudentAnswer4 studentAnswer = (StudentAnswer4)JSONObject.toBean(jsonObject, StudentAnswer4.class);
            //将转换过后的对象放入集合
            studentAnswerList.add(studentAnswer);
        }
        //批量修改分数
        coursePaperService.setGradeBatch(studentAnswerList);
        return "success";
    }
}
