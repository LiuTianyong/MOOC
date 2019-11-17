package com.usy.mapper;

import com.usy.pojo.Course;
import com.usy.pojo.Teacher;
import com.usy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    /**
     * 认证账号到数据库
     */
    Integer insert(Teacher teacher);

    /**
     * 注册之前检测是否被注册
     */
    Teacher getAccount(Teacher teacher);

    /**
     * 登陆时校对
     * @param teacher
     * @return
     */
    Teacher selectAccountPwd(Teacher teacher);

    /**
     * 认证时 数据库  数据更新
     * @param teacher
     * @return
     */
    int update(Teacher teacher);

    /**
     * 个人中心修改 账户头像
     * @param teacher
     * @return
     */
    int updateUserHeadPortrait(Teacher teacher);

    /**
     * 根据老师ID提取老师信息
     * @param teacherId
     * @return
     */
    Teacher getTeacher(Integer teacherId);

    /**
     * 显示老师密码
     * @param userId
     * @return
     */
    User lookPassword(@Param("userId") Integer userId);

    /**
     * 修改教师密码
     * @param user
     * @return
     */
    Integer changeTeacherPw(User user);

    /**
     * 保存个人信息
     * @param teacherInfo
     * @return
     */
    Integer SaveTeacherInfo(Teacher teacherInfo);

    /**
     * 老师查看自身所有课程
     * @param teacherId
     * @return
     */
    List<Course> seeMyCourse(@Param("teacherId") Integer teacherId);

    /**
     * 老师查看自身一门课程
     * @param courseId
     * @return
     */
    Course selectCourseInfo(@Param("courseId")Integer courseId);

    /**
     * 老师修改一门课程
     * @param course
     * @return
     */
    int updateByCourseId(Course course);
}
