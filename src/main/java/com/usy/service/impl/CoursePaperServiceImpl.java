package com.usy.service.impl;

import com.usy.mapper.CoursePaperMapper;
import com.usy.pojo.*;
import com.usy.service.CoursePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Paper;
import java.util.LinkedList;
import java.util.List;

@Service("coursePaperService")
public class CoursePaperServiceImpl implements CoursePaperService {


    @Autowired
    private CoursePaperMapper coursePaperMapper;

    /**
     * 插入一份试卷到数据库 并且返回主键
     * @param coursePaper
     * @return
     */
    @Override
    public Integer insertCoursePaper(CoursePaper coursePaper) {
        coursePaperMapper.insertCoursePaper(coursePaper);
        return null;
    }

    /**
     * 插入一份试卷的选择题入库
     *
     * @param paperChoice
     * @return
     */
    @Override
    public Integer insertPaperChoice(PaperChoice paperChoice) {
        coursePaperMapper.insertPaperChoice(paperChoice);
        return null;
    }

    /**
     * 插入一份试卷的填空题
     *
     * @param paperBlank
     * @return
     */
    @Override
    public Integer insertPaperBlank(PaperBlank paperBlank) {
        coursePaperMapper.insertPaperBlank(paperBlank);
        return null;
    }

    /**
     * 插入一份试卷的判断题
     *
     * @param paperJudge
     * @return
     */
    @Override
    public Integer insertPaperJudge(PaperJudge paperJudge) {
        coursePaperMapper.insertPaperJudge(paperJudge);
        return null;
    }

    /**
     * 插入一份试卷的简答题
     *
     * @param paperDiscuss
     * @return
     */
    @Override
    public Integer insertPaperDiscuss(PaperDiscuss paperDiscuss) {
        coursePaperMapper.insertPaperDiscuss(paperDiscuss);
        return null;
    }

    /**
     * 查询该试卷所有的选择题
     *
     * @param paperId
     * @return
     */
    @Override
    public List<PaperChoice> selectPaperChoice(Integer paperId) {
        List<PaperChoice> paperChoiceList = coursePaperMapper.selectPaperChoice(paperId);
        return paperChoiceList;
    }

    /**
     * 查询该试卷所有的判断题
     *
     * @param paperId
     * @return
     */
    @Override
    public List<PaperJudge> selectPaperJudge(Integer paperId) {
        List<PaperJudge> paperJudgeList = coursePaperMapper.selectPaperJudge(paperId);
        return paperJudgeList;
    }

    /**
     * 查询该试卷所有的填空题
     *
     * @param paperId
     * @return
     */
    @Override
    public List<PaperBlank> selectPaperBlank(Integer paperId) {
        List<PaperBlank> paperBlankList = coursePaperMapper.selectPaperBlank(paperId);
        return paperBlankList;
    }

    /**
     * 查询所有试卷的简答题
     *
     * @param paperId
     * @return
     */
    @Override
    public List<PaperDiscuss> selectPaperDiscuss(Integer paperId) {
        List<PaperDiscuss> paperDiscussList = coursePaperMapper.selectPaperDiscuss(paperId);
        return paperDiscussList;
    }

    /*学生答题部分*/
    /**
     * 插入学生选择题答案到选择题答案表
     * @param studentAnswer1
     * @return
     */
    @Override
    public boolean insertStuChoiceList(List<StudentAnswer1> studentAnswer1) {
        int result = coursePaperMapper.insertStuChoiceList(studentAnswer1);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 插入学生填空题答案到填空题答案表
     * @param studentAnswer2
     * @return
     */
    @Override
    public boolean insertStuBlankList(List<StudentAnswer2> studentAnswer2) {
        int result = coursePaperMapper.insertStuBlankList(studentAnswer2);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 插入学生简答题答案到简答题答案表
     * @param studentAnswer4
     * @return
     */
    @Override
    public boolean insertStuDiscussList(List<StudentAnswer4> studentAnswer4) {
        int result = coursePaperMapper.insertStuDiscussList(studentAnswer4);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 插入学生判断题答案到判断题答案表
     * @param studentAnswer3
     * @return
     */
    @Override
    public boolean insertStuJudgeList(List<StudentAnswer3> studentAnswer3) {
        int result = coursePaperMapper.insertStuJudgeList(studentAnswer3);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 更新学生成绩表
     * @return
     */
    @Override
    public boolean updateStuCgradeSum(Integer courseId) {
        int result = coursePaperMapper.updateStuCgradeSum(courseId);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 第一次答题，插入学生试卷得分表
     * @param paperId
     * @param studentId
     * @return
     */
    @Override
    public boolean insertStuPgrade(Integer paperId, Integer studentId) {
        int result =0;
        try {
            result =coursePaperMapper.insertStuPgrade(paperId,studentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 更新学生试卷得分表
     * @param paperId
     * @param studentId
     * @return
     */
    @Override
    public boolean updateStuPgrade(Integer paperId,Integer studentId) {
        int result =coursePaperMapper.updateStuPgrade(paperId,studentId);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 更新学生成绩表的paper部分成绩
     * @param studentId
     * @param courseId
     * @return
     */
    @Override
    public boolean updateCgradePaper(Integer studentId, Integer courseId) {
        if (coursePaperMapper.selectCgradePaper(studentId, courseId) == null) {
            coursePaperMapper.insertCgradePaper(studentId, courseId);
        }
        int result = coursePaperMapper.updateCgradePaper(studentId, courseId);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将学生错题插入错题表中
     * @param stuAnswer
     * @return
     */
    @Override
    public boolean insertStudentWrong(Object stuAnswer) {
        int result = coursePaperMapper.insertStudentWrong(stuAnswer);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 获取学生判断题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    @Override
    public List<StudentAnswer3> selectStuAnswer3(Integer paperId, Integer studentId) {
        try {
            List<StudentAnswer3> studentAnswer =coursePaperMapper.selectStuAnswer3(paperId,studentId);
            return studentAnswer;
        } catch (Exception e) {
            List<StudentAnswer3> studentAnswer= new LinkedList<>();
            return studentAnswer;
        }
    }

    /**
     * 获取学生简答题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    @Override
    public List<StudentAnswer4> selectStuAnswer4(Integer paperId, Integer studentId) {
        try {
            List<StudentAnswer4> studentAnswer =coursePaperMapper.selectStuAnswer4(paperId,studentId);
            return studentAnswer;
        } catch (Exception e) {
            List<StudentAnswer4> studentAnswer= new LinkedList<>();
            return studentAnswer;
        }
    }

    /**
     * 获取学生填空题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    @Override
    public List<StudentAnswer1> selectStuAnswer1(Integer paperId, Integer studentId) {
        try {
            List<StudentAnswer1> studentAnswer =coursePaperMapper.selectStuAnswer1(paperId,studentId);
            return studentAnswer;
        } catch (Exception e) {
            List<StudentAnswer1> studentAnswer= new LinkedList<>();
            return studentAnswer;
        }
    }

    /**
     * 获取学生填空题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    @Override
    public List<StudentAnswer2> selectStuAnswer2(Integer paperId, Integer studentId) {
        try {
            List<StudentAnswer2> studentAnswer =coursePaperMapper.selectStuAnswer2(paperId,studentId);
            return studentAnswer;
        } catch (Exception e) {
            List<StudentAnswer2> studentAnswer= new LinkedList<>();
            return studentAnswer;
        }
    }

    /**
     * 更新学生该试卷在数据库得选择题答案
     * @param studentAnswer1
     * @return
     */
    @Override
    public boolean updateStuChoiceList(List<StudentAnswer1> studentAnswer1) {
        int result = coursePaperMapper.updateStuChoiceList(studentAnswer1);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 更新学生该试卷在数据库得填空题答案
     * @param studentAnswer2
     * @return
     */
    @Override
    public boolean updateStuBlankList(List<StudentAnswer2> studentAnswer2) {
        int result = coursePaperMapper.updateStuBlankList(studentAnswer2);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 更新学生该试卷在数据库得判断题答案
     * @param studentAnswer3
     * @return
     */
    @Override
    public boolean updateStuJudgeList(List<StudentAnswer3> studentAnswer3) {
        int result = coursePaperMapper.updateStuJudgeList(studentAnswer3);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 更新学生该试卷在数据库得简答题答案
     * @param studentAnswer4
     * @return
     */
    @Override
    public boolean updateStuDiscussList(List<StudentAnswer4> studentAnswer4) {
        int result = coursePaperMapper.updateStuDiscussList(studentAnswer4);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断试卷类型
     * @param paperId
     * @return
     */
    @Override
    public CoursePaper selectBypaperId(Integer paperId) {
        return coursePaperMapper.selectBypaperId(paperId);
    }

    /**
     * 更新学生课程期末成绩
     * @param studentId
     * @param courseId
     * @return
     */
    @Override
    public boolean updateCgradeExam(Integer studentId, Integer courseId) {
        int result = coursePaperMapper.updateCgradeExam(studentId,courseId);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 通过subid查试卷id
     * @param subId
     * @return
     */
    @Override
    public Integer queryBysubIdPaperId(Integer subId) {
        return coursePaperMapper.selectBySubIdPaperId(subId);
    }

    /**
     * 获取全班简答题答案
     * @param classId
     * @return
     */
    @Override
    public List<StudentAnswer4> correctionanswer4(Integer classId){
        return coursePaperMapper.correctionanswer4(classId);
    }

    /**
     * 老师为全班简答题给分
     * @param studentAnswer4
     * @return
     */
    @Override
    public int setGradeBatch(List<StudentAnswer4> studentAnswer4) {
        return coursePaperMapper.setGradeBatch(studentAnswer4);
    }
}
