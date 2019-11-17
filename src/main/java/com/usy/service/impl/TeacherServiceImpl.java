package com.usy.service.impl;

import com.usy.mapper.TeacherMapper;
import com.usy.pojo.Course;
import com.usy.pojo.Teacher;
import com.usy.pojo.User;
import com.usy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     *  认证时插入数据库
     * @param teacher
     * @return
     */
    @Override
    public boolean instrt(Teacher teacher) {
        if (teacher != null){
            int result = teacherMapper.insert(teacher);
            if (result > 0){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * 注册时 校验账号是否已经被使用过
     * @param teacher
     * @return
     */
    @Override
    public boolean getAccount(Teacher teacher) {
        Teacher teacher1 = teacherMapper.getAccount(teacher);
        System.out.println(teacher1);
        if (teacher1 != null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 登陆时校验
     * @param teacher
     * @return
     */
    @Override
    public Teacher selectAccountPwd(Teacher teacher) {
        Teacher teacher1 = teacherMapper.selectAccountPwd(teacher);
        if (teacher1 != null){
            System.out.println("校对真确，确有此账号 且密码真确");
            return teacher1;
        }else {
            System.out.println("不真确");
            return null;
        }
    }

    /**
     * 认证时 对数据库 记录进行更新
     * @param teacher
     * @return
     */
    @Override
    public boolean identificationUpdate(Teacher teacher) {

        System.out.println("identificationUpdate方法：" + teacher);
        int result = teacherMapper.insert(teacher);
        if (result > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Teacher getTeacher(Integer teacherId) {
        System.out.println("service 已经得到该老师的id为：" + teacherId);
        Teacher teacher = teacherMapper.getTeacher(teacherId);
        System.out.println(teacher);
        return teacher;
    }
    /**
     * 显示老师密码
     * @param userId
     * @return
     */
    @Override
    public User lookPassword(Integer userId) {
        return teacherMapper.lookPassword(userId);
    }

    @Override
    public User changeTeacherPw(User user) {
        Integer integer = teacherMapper.changeTeacherPw(user);
        if(integer > 0){
            return user;
        }else{
            return null;
        }
    }

    /**
     * 修改信息后保存
     * @param teacherInfo
     * @return
     */
    @Override
    public Teacher SaveTeacherInfo(Teacher teacherInfo) {
        Integer integer =teacherMapper.SaveTeacherInfo(teacherInfo);
        if(integer > 0){
            return teacherInfo;
        }else{

            return null;
        }
    }

    /**
     * 查看自己开设的所有课程
     * @param teacherId
     * @return
     */
    @Override
    public List<Course> seeMyCourse(Integer teacherId) {
        List<Course> course2 = teacherMapper.seeMyCourse(teacherId);
        return course2;
    }

    /**
     * 查看自己开设的一门课程
     * @param courseId
     * @return
     */
    @Override
    public Course queryByCourseId(Integer courseId) {
        return teacherMapper.selectCourseInfo(courseId);
    }

    /**
     * 老师修改课程信息
     * @param course
     * @return
     */
    @Override
    public Boolean updateByCourseId(Course course) {
        int result = teacherMapper.updateByCourseId(course);
        if (result>1){
            return true;
        }else {
            return false;
        }

    }


}
