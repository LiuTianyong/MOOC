package com.usy.service.impl;

import com.usy.mapper.CourseMapper;
import com.usy.pojo.*;
import com.usy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    /**
     * 获取根据老师ID课程信息
     * @param teacherId
     * @return
     */
    @Override
    public List<Course> getCourse(Integer teacherId) {
        System.out.println("service 已经得到该老师的id为：" + teacherId);
        List<Course> course = courseMapper.getCourse(teacherId);
        System.out.println(course);
        return course;
    }

    /**
     * 开设课程时将课程基本信息写入数据库
     * @param course
     * @return
     */
    @Override
    public boolean insertCourse(Course course) {

        Integer result = courseMapper.insertCourse(course);

        if (result > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean insert(Course course) {
        Integer result = courseMapper.insert(course);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean insertChap(CourseChap courseChap) {
        int result = courseMapper.insertChap(courseChap);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean insertSub(CourseChapSub courseChapSub) {
        int result = courseMapper.insertSub(courseChapSub);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateSub(CourseChapSub courseChapSub) {
        return courseMapper.updateSub(courseChapSub);
    }

    @Override
    public Boolean deleteBySubId(Integer subId) {
        return courseMapper.deleteBySub(subId);
    }

    @Override
    public Boolean updateChap(CourseChap chap) {
        int result = courseMapper.updateChap(chap);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public CourseChap queryByChapIdContent(Integer chapId) {
        return courseMapper.queryByChapIdContent(chapId);
    }

    /**
     * 删除章节
     * @param chapId
     * @return
     */
    @Override
    public Boolean deleteByChapId(Integer chapId) {
        int result = courseMapper.deleteByChapId(chapId);
        if(result > 0){
            return true;
        }
        return false;
    }

    /**
     * 删除课程
     * @param courseId
     * @return
     */
    @Override
    public Boolean deleteByCourseId(Integer courseId) {
        int result = courseMapper.deleteByCourseId(courseId);
        if(result > 0){
            return true;
        }
        return false;
    }

    /*学生操作课程部分*/
    /*========================================================================*/
    /**
     * 查询小节评论区信息
     * @return
     * @param subId
     */
    @Override
    public List<StudentSubcom> queryStuCommentList(Integer subId) {
        return courseMapper.queryStuCommentList(subId);
    }

    /**
     * 插入用户评论信息
     * @param studentSubcom
     * @return
     */
    @Override
    public boolean insertComment(StudentSubcom studentSubcom) {
        try {
            courseMapper.insertComment(studentSubcom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 查询小节错题情况
     * @param studentId
     * @param subId
     * @return
     */
    @Override
    public List<Studentwrong> queryWrongList(Integer studentId, Integer  subId) {
        return courseMapper.queryWrongList(studentId,subId);
    }

    /**
     * 查询章节错题情况
     * @param studentId
     * @param chapId
     * @return
     */
    @Override
    public List<Studentwrong> queryWrongListByChap(Integer studentId, Integer chapId) {
        return courseMapper.queryWrongListByChap(studentId,chapId);
    }

    /**
     * 查询课程错题情况
     * @param studentId
     * @param courseId
     * @return
     */
    @Override
    public List<Studentwrong> queryWrongListByCourse(Integer studentId, Integer courseId) {
        return courseMapper.queryWrongListByCourse(studentId,courseId);
    }

    /**
     * 查询课程视频观看总进度
     * @param studentId
     * @param courseId
     * @return
     */
    @Override
    public List<StudentVideo> queryVideoAllProgress(Integer studentId, Integer courseId) {
        return courseMapper.queryVideoAllProgress(studentId,courseId);
    }

    /**
     * 查询学生课程试卷得分情况
     * @param studentId
     * @param courseId
     * @return
     */
    @Override
    public List<StudentPgrade> queryStudentPgradesList(Integer studentId, Integer courseId) {
        return courseMapper.queryStudentPgradesList(studentId,courseId);
    }

    /**
     * 查询学生总成绩
     * @param studentId
     * @param courseId
     * @return
     */
    @Override
    public List<StudentCgrade> queryStudentCgradesList(Integer studentId, Integer courseId) {
        return courseMapper.queryStudentCgradesList(studentId,courseId);
    }

    @Override
    public List<CourseChap> queryByCourseIdAllChap(Integer courseId) {
        return courseMapper.queryByCourseIdAllChap(courseId);
    }

    @Override
    public List<CourseChapSub> queryByCourseIdAllSub(Integer chapId) {
        return courseMapper.queryByCourseIdAllSub(chapId);
    }

    @Override
    public CourseChapSub queryBySubIdContent(Integer subId) {
        return courseMapper.queryBySubIdContent(subId);
    }
    /**
     * 修改课程状态打开课程
     * @param courseId
     * @return
     */
    @Override
    public Integer updateOpenCourse(Integer courseId){
        return courseMapper.updateOpenCourse(courseId);
    }
    /**
     * 修改课程状态关闭课程
     * @param courseId
     * @return
     */
    @Override
    public Integer updateCloseCourse(Integer courseId){
        return courseMapper.updateCloseCourse(courseId);
    }
}
