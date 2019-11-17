package com.usy.mapper;

import com.usy.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    /**
     * 根据老师id查课程
     * @param teacherId
     * @return
     */
    List<Course> getCourse(Integer teacherId);
    /**
     * 插入课程信息到数据库
     * @param course
     * @return
     */
    public int insertCourse(Course course);

    /**
     * 插入数据 并返回该条记录
     * @param course
     * @return
     */
    public Integer insert(Course course);

    int insertChap(CourseChap courseChap);

    int insertSub(CourseChapSub courseChapSub);


    /*学生操作课程部分*/
    /*=================================================================*/
    /**
     * 查询评论信息
     * @return
     * @param subId
     */
    List<StudentSubcom> queryStuCommentList(@Param("subId") Integer subId);

    /**
     * 插入用户评论信息
     * @param studentSubcom
     * @return
     */
    int insertComment(StudentSubcom studentSubcom);

    /**
     * 查询小节错题信息
     * @param studentId
     * @param subId
     * @return
     */
    List<Studentwrong> queryWrongList(@Param("studentId") Integer studentId, @Param("subId") Integer subId);

    /**
     * 查询章节错题信息
     * @param studentId
     * @param chapId
     * @return
     */
    List<Studentwrong> queryWrongListByChap(@Param("studentId") Integer studentId, @Param("chapId") Integer chapId);

    /**
     * 查询课程错题信息
     * @param studentId
     * @param courseId
     * @return
     */
    List<Studentwrong> queryWrongListByCourse(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    /**
     * 查询总的视频进度
     * @param studentId
     * @param courseId
     * @return
     */
    List<StudentVideo> queryVideoAllProgress(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    /**
     * 查询学生测试成绩
     * @param studentId
     * @param courseId
     * @return
     */
    List<StudentPgrade> queryStudentPgradesList(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    /**
     * 查询学生总成绩
     * @param studentId
     * @param courseId
     * @return
     */
    List<StudentCgrade> queryStudentCgradesList(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    List<CourseChap> queryByCourseIdAllChap(Integer courseId);

    List<CourseChapSub> queryByCourseIdAllSub(Integer chapId);

    CourseChapSub queryBySubIdContent(@Param("subId")Integer subId);

    Boolean updateSub(CourseChapSub courseChapSub);

    Boolean deleteBySub(@Param("subId")Integer subId);

    int updateChap(CourseChap chap);

    CourseChap queryByChapIdContent(@Param("chapId") Integer chapId);

    /**
     * 删除章节
     * @param chapId
     * @return
     */
    int deleteByChapId(@Param("chapId") Integer chapId);

    /**
     * 删除课程
     * @param courseId
     * @return
     */
    int deleteByCourseId(@Param("courseId") Integer courseId);
    /**
     * 修改课程状态 打开课程
     * @param courseId
     * @return
     */
    Integer updateOpenCourse(Integer courseId);
    /**
     * 修改课程状态 关闭课程
     * @param courseId
     * @return
     */
    Integer updateCloseCourse(Integer courseId);
}
