package com.usy.service;

import com.usy.pojo.*;

import java.awt.print.Paper;
import java.util.List;

public interface CoursePaperService {


    /**
     * 插入一份试卷到数据库 并且返回主键
     * @return
     */
    public Integer insertCoursePaper(CoursePaper coursePaper);

    /**
     * 插入一份试卷的选择题入库
     * @param paperChoice
     * @return
     */
    public Integer insertPaperChoice(PaperChoice paperChoice);

    /**
     * 插入一份试卷的填空题
     * @param paperBlank
     * @return
     */
    public Integer insertPaperBlank(PaperBlank paperBlank);

    /**
     * 插入一份试卷的判断题
     * @param paperJudge
     * @return
     */
    public Integer insertPaperJudge(PaperJudge paperJudge);

    /**
     * 插入一份试卷的简答题
     * @param paperDiscuss
     * @return
     */
    public Integer insertPaperDiscuss(PaperDiscuss paperDiscuss);

    /**
     * 查询该试卷所有的选择题
     * @return
     */
    public List<PaperChoice> selectPaperChoice(Integer paperId);

    /**
     * 查询该试卷所有的判断题
     * @param paperId
     * @return
     */
    public List<PaperJudge> selectPaperJudge(Integer paperId);

    /**
     * 查询该试卷所有的填空题
     * @param paperId
     * @return
     */
    public List<PaperBlank> selectPaperBlank(Integer paperId);

    /**
     * 查询所有试卷的简答题
     * @param paperId
     * @return
     */
    public List<PaperDiscuss> selectPaperDiscuss(Integer paperId);


    /*学生答题部分*/
    /**
     * 将学生选择题答案插入学生选择题答案表
     * @param studentAnswer1
     * @return
     */
    boolean insertStuChoiceList(List<StudentAnswer1> studentAnswer1);

    /**
     * 将学生填空题答案插入学生填空题答案表
     * @param studentAnswer2
     * @return
     */
    boolean insertStuBlankList(List<StudentAnswer2> studentAnswer2);

    /**
     * 将学生简答题答案插入学生简答题答案表
     * @param studentAnswer4
     * @return
     */
    boolean insertStuDiscussList(List<StudentAnswer4> studentAnswer4);

    /**
     * 将学生判断题答案插入学生判断题答案表
     * @param studentAnswer3
     * @return
     */
    boolean insertStuJudgeList(List<StudentAnswer3> studentAnswer3);

    /**
     * 将学生测试的成绩插入得分成绩表
     * @param courseId
     * @return
     */
    boolean updateStuCgradeSum(Integer courseId);

    /**
     * 将学生测试的成绩插入课程成绩表
     * @param paperId
     * @param studentId
     * @return
     */
    boolean insertStuPgrade(Integer paperId, Integer studentId);

    /**
     * 更新学生测试的成绩到得分成绩表
     * @param paperId
     * @param studentId
     * @return
     */
    boolean updateStuPgrade(Integer paperId,Integer studentId);

    /**
     * 更新学生总成绩表的paper部分
     * @param studentId
     * @param courseId
     * @return
     */
    boolean updateCgradePaper(Integer studentId, Integer courseId);

    /**
     * 学生错题插入学生错题表
     * @param stuAnswer
     * @return
     */
    boolean insertStudentWrong(Object stuAnswer);

    /**
     * 获取学生选择题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    List<StudentAnswer3> selectStuAnswer3(Integer paperId, Integer studentId);

    /**
     * 获取学生填空题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    List<StudentAnswer4> selectStuAnswer4(Integer paperId, Integer studentId);

    /**
     * 获取学生判断题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    List<StudentAnswer1> selectStuAnswer1(Integer paperId, Integer studentId);

    /**
     * 获取学生填空题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    List<StudentAnswer2> selectStuAnswer2(Integer paperId, Integer studentId);

    /**
     * 更新学生该试卷在数据库得选择题答案
     * @param studentAnswer1
     * @return
     */
    boolean updateStuChoiceList(List<StudentAnswer1> studentAnswer1);
    /**
     * 更新学生该试卷在数据库得填空题答案
     * @param studentAnswer2
     * @return
     */

    boolean updateStuBlankList(List<StudentAnswer2> studentAnswer2);
    /**
     * 更新学生该试卷在数据库得判断题答案
     * @param studentAnswer3
     * @return
     */

    boolean updateStuJudgeList(List<StudentAnswer3> studentAnswer3);
    /**
     * 更新学生该试卷在数据库得简答题答案
     * @param studentAnswer4
     * @return
     */

    boolean updateStuDiscussList(List<StudentAnswer4> studentAnswer4);

    /**
     * 判断试卷类型
     * @param paperId
     * @return
     */
    CoursePaper selectBypaperId(Integer paperId);

    /**
     * 更新学生课程期末成绩
     * @param studentId
     * @param courseId
     * @return
     */
    boolean updateCgradeExam(Integer studentId, Integer courseId);

    /**
     * 通过小节id查试卷id
     * @param subId
     * @return
     */
    Integer queryBysubIdPaperId(Integer subId);

    //老师改试卷

    /**
     * 获取学生简答题题目和答案
     *
     *
     */
    List<StudentAnswer4> correctionanswer4(Integer classId);


    /**
     * 批量修改答案分数
     * @param studentAnswer4
     * @return
     */
    int setGradeBatch(List<StudentAnswer4> studentAnswer4);
}
