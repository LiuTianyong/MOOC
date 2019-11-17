package com.usy.service;


import com.usy.pojo.*;

import java.util.List;

public interface CourseService {

        /**
         * 根据老师ID获取课程信息
         * @param teacherId
         * @return
         */
        public List<Course> getCourse(Integer teacherId);
    /**
     * 插入课程基本信息 用于课程开设时
     * @param course
     * @return boolean
     */
    public boolean insertCourse(Course course);


    /**
     * 插入数据
     * @param course
     * @return
     */
    public Boolean insert(Course course);



    /*学生操作课程部分*/
    /*=============================================================*/
    /**
     * 查询评论信息
     * @return
     * @param subId
     */
    List<StudentSubcom> queryStuCommentList(Integer subId);

    /**
     * 插入学生评论信息
     * @param studentSubcom
     * @param subId
     * @return
     */
    boolean insertComment(StudentSubcom studentSubcom);

    /**
     * 查询小节错题情况
     * @param studentId
     * @param subId
     * @return
     */
    List<Studentwrong> queryWrongList(Integer studentId, Integer subId);

    /**
     * 查询章节错题情况
     * @param studentId
     * @param chapId
     * @return
     */
    List<Studentwrong> queryWrongListByChap(Integer studentId, Integer chapId);

    /**
     * 查询课程错题情况
     * @param studentId
     * @param courseId
     * @return
     */
    List<Studentwrong> queryWrongListByCourse(Integer studentId, Integer courseId);

    /**
     * 查询课程总体视频观看情况
     * @param studentId
     * @param courseId
     * @return
     */
    List<StudentVideo> queryVideoAllProgress(Integer studentId, Integer courseId);

    /**
     * 查询学生课程试卷得分情况
     * @param studentId
     * @param courseId
     * @return
     */
    List<StudentPgrade> queryStudentPgradesList(Integer studentId, Integer courseId);

    /**
     * 查询学生总成绩
     * @param studentId
     * @param courseId
     * @return
     */
    List<StudentCgrade> queryStudentCgradesList(Integer studentId, Integer courseId);

    /**
     * 查询课程id下的所有章节
     * @param courseId
     * @return
     */
    List<CourseChap> queryByCourseIdAllChap(Integer courseId);

    /**
     * 查询课程对应的所有小节
     * @param chapId
     * @return
     */
    List<CourseChapSub> queryByCourseIdAllSub(Integer chapId);

    /**
     * 通过小节id获取所有小节信息
     * @param subId
     * @return
     */
    CourseChapSub queryBySubIdContent(Integer subId);

    /**
     * 开设章节
     * @param courseChap
     * @return
     */
    Boolean insertChap(CourseChap courseChap);

    /**
     * 开设小节
     * @param courseChapSub
     * @return
     */
    Boolean insertSub(CourseChapSub courseChapSub);

    /**
     * 修改小节
     * @param courseChapSub
     * @return
     */
    Boolean updateSub(CourseChapSub courseChapSub);

    /**
     * 删除小节
     * @param subId
     * @return
     */
    Boolean deleteBySubId(Integer subId);

    /**
     * 更新章节
     * @param chap
     * @return
     */
    Boolean updateChap(CourseChap chap);

    /**
     *  获取章节信息
     * @param chapId
     * @return
     */
    CourseChap queryByChapIdContent(Integer chapId);

    /**
     *  删除章节信息
     * @param chapId
     * @return
     */
    Boolean deleteByChapId(Integer chapId);

    /**
     * 删除课程信息
     * @param courseId
     * @return
     */
    Boolean deleteByCourseId(Integer courseId);
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
