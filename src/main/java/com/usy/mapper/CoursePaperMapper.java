package com.usy.mapper;

import com.usy.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CoursePaperMapper {


    /**
     * 插入一份试卷到数据库，并且返回主键，试卷ID
     * @param coursePaper
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

    /**
     * 将学生选择题答案插入学生选择题答案表
     * @param studentAnswer1
     * @return
     */
    int insertStuChoiceList(@Param("studentAnswer1") List<StudentAnswer1> studentAnswer1);

    /**
     * 将学生填空题答案插入学生填空题答案表
     * @param studentAnswer2
     * @return
     */
    int insertStuBlankList(@Param("studentAnswer2")List<StudentAnswer2> studentAnswer2);

    /**
     * 将学生简答题答案插入学生简答题答案表
     * @param studentAnswer4
     * @return
     */
    int insertStuDiscussList(@Param("studentAnswer4")List<StudentAnswer4> studentAnswer4);

    /**
     * 将学生判断题答案插入学生判断题答案表
     * @param studentAnswer3
     * @return
     */
    int insertStuJudgeList(@Param("studentAnswer3")List<StudentAnswer3> studentAnswer3);

    /**
     * 将学生测试的成绩更新到得分成绩表
     * @param paperId
     * @param studentId
     * @return
     */
    int updateStuPgrade(@Param("paperId") Integer paperId, @Param("studentId") Integer studentId);

    /**
     * 将第一次学生测试的成绩插入学生测试成绩表
     * @param paperId
     * @param studentId
     * @return
     */
    int insertStuPgrade(@Param("paperId")Integer paperId,@Param("studentId")Integer studentId);

    /**
     * 更新学生总成绩表
     * @param courseId
     * @return
     */
    int updateStuCgradeSum(@Param("courseId") Integer courseId);

    /**
     * 更新学生总成绩表的paper部分成绩
     * @param studentId
     * @param courseId
     * @return
     */
    int updateCgradePaper(@Param("studentId") Integer studentId,@Param("courseId") Integer courseId);

    /**
     * 将学生错题信息插入错题表中
     * @param stuAnswer
     * @return
     */
    int insertStudentWrong(Object stuAnswer);

    /**
     * 获取学生选择题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    List<StudentAnswer1> selectStuAnswer1(@Param("paperId") Integer paperId, @Param("studentId") Integer studentId);

    /**
     * 获取学生填空题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    List<StudentAnswer2> selectStuAnswer2(@Param("paperId") Integer paperId, @Param("studentId") Integer studentId);

    /**
     * 获取学生判断题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    List<StudentAnswer4> selectStuAnswer4(@Param("paperId") Integer paperId, @Param("studentId") Integer studentId);

    /**
     * 获取学生简答题答案List
     * @param paperId
     * @param studentId
     * @return
     */
    List<StudentAnswer3> selectStuAnswer3(@Param("paperId") Integer paperId, @Param("studentId") Integer studentId);

    /**
     * 更新该学生该试卷在数据库的选择题答案
     * @param studentAnswer1
     * @return
     */
    int updateStuChoiceList(@Param("studentAnswer1") List<StudentAnswer1> studentAnswer1);

    /**
     * 更新该学生该试卷在数据库的填空题答案
     * @param studentAnswer2
     * @return
     */
    int updateStuBlankList(@Param("studentAnswer2") List<StudentAnswer2> studentAnswer2);

    /**
     * 更新该学生该试卷在数据库的判断题答案
     * @param studentAnswer3
     * @return
     */
    int updateStuJudgeList(@Param("studentAnswer3") List<StudentAnswer3> studentAnswer3);

    /**
     * 更新该学生该试卷在数据库的简答题答案
     * @param studentAnswer4
     * @return
     */
    int updateStuDiscussList(@Param("studentAnswer4") List<StudentAnswer4> studentAnswer4);

    /**
     * 判断学生总成绩表中是否有该学生
     * @param studentId
     * @param courseId
     * @return
     */
    StudentCgrade selectCgradePaper(@Param("studentId")Integer studentId,@Param("courseId") Integer courseId);

    /**
     * 若没有该学生，则插入该学生信息，有则更新
     * @param studentId
     * @param courseId
     * @return
     */
    int insertCgradePaper(@Param("studentId")Integer studentId,@Param("courseId") Integer courseId);

    /**
     * 获取试卷类型
     * @param paperId
     * @return
     */
    CoursePaper selectBypaperId(@Param("paperId") Integer paperId);

    /**
     * 更新试卷的测试成绩（期末）
     * @param studentId
     * @param courseId
     * @return
     */
    int updateCgradeExam(@Param("studentId")Integer studentId,@Param("courseId") Integer courseId);

    /**
     * 通过小节id查试卷id
     * @param subId
     * @return
     */
    Integer selectBySubIdPaperId(@Param("subId") Integer subId);

    /**
     * 获取全班简答题答案
     * @param classId
     * @return
     */
    List<StudentAnswer4> correctionanswer4(@Param("classId")Integer classId);

    /**
     * 老师给出学生成绩
     * @param studentAnswer4
     * @return
     */
    int setGradeBatch(@Param("studentAnswers")List<StudentAnswer4> studentAnswer4);
}
