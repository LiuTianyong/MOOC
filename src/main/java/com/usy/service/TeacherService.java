package com.usy.service;

import com.usy.pojo.Course;
import com.usy.pojo.Teacher;
import com.usy.pojo.User;

import java.util.List;

public interface TeacherService {

    /**
     * 注册进入数据库
     * @param teacher
     * @return boolean
     */
    public boolean instrt(Teacher teacher);

    /**
     * 注册前对账号进行校验，检测是否已被注册
     * @param teacher
     * @return boolean
     */
    public boolean getAccount(Teacher teacher);

    /**
     * 账号登陆校对
     * @param teacher
     * @return
     */
    public Teacher selectAccountPwd(Teacher teacher);

    /**
     * 认证时 数据库 更新数据
     * @param teacher
     * @return boolean 更新是否成功
     */
    public boolean identificationUpdate(Teacher teacher);

    /**
     * 根据老师ID提取老师信息
     * @param teacherId
     * @return  Teacher
     */
    public Teacher getTeacher(Integer teacherId);

    /**
     * 显示老师的密码
     * @param userId
     * @return
     */
    public User lookPassword(Integer userId);

    /**
     * 修改教师密码
     * @param user
     * @return
     */
    public User changeTeacherPw(User user);

    /**
     * 保存修改信息
     * @param teacherInfo
     * @return
     */
    Teacher SaveTeacherInfo(Teacher teacherInfo);

    /**
     * 老师查看自身的所有课程
     * @param teacherId
     * @return
     */
    List<Course> seeMyCourse(Integer teacherId);

    /**
     * 老师查看自身的一门课程
     * @param courseId
     * @return
     */
    Course queryByCourseId(Integer courseId);

    /**
     * 老师修改课程信息
     * @param course
     * @return
     */
    Boolean updateByCourseId(Course course);
}
