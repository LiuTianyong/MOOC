package com.usy.mapper;


import com.usy.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /**
     * 注册时插入一个学生 账号的ID 和 头像
     * @param student
     * @return
     */
    Integer instrtIdHp(Student student);

    /**
     * 查看当前用户所选的所有课程
     *
     */
    List<Course> queryAllcourse(@Param("userId") Integer userId);

    /**
     * 退选所选中的课程
     *
     */
    void deletecourse(@Param("courseId") Integer courseId, @Param("studentId") Integer studentId);

    /**
     * 根据课程ID来查找课程
     *
     */
    List<Course> queryByCourseId(@Param("courseName")String courseName,@Param("studentId")Integer studentId);

    List<StudentChoose> queryByuserIdAllcourse(Integer userId);

    /**
     * 找出所有课程数据
     *
     */
    public List<Course> selectAllCourse(@Param("course") Course course);

    /**
     * 通过课程名称查找班级
     * @param courseName
     * @return
     */
    public List<Course> searchName(@Param("courseName") String courseName);

    /**
     * 找出课程班级表中的某个课程的信息
     * @param courseId
     * @return List<CourseClass>
     */
    public List<CourseClass> lookClass(@Param("courseId") Integer courseId);

    /**
     *查找班级
     * @param className
     * @return List<CourseClass>
     */
    public List<CourseClass> findedClass(@Param("className") String className);

    /**
     * 加入班级
     * @param classChoose
     * @return
     */
    public Integer insertInfo(StudentChoose classChoose);

    /**
     * 查看是否在此班级
     * @param classChoose
     * @return
     */
    StudentChoose selectStuCourseClass(StudentChoose classChoose);

    /**
     * 要加入班级的已加入人数
     * @param classId
     * @return
     */
    Integer queryByClassId(@Param("classId") Integer classId);

    /**
     * 查询班级的人数上限
     * @param classId
     * @param courseId
     * @return
     */
    Integer queryByClassIdAndCourseId(@Param("classId") Integer classId,@Param("courseId") Integer courseId);

    /**
     *  加入的班级是否存在该学生
     * @param classId
     * @param studentId
     * @return
     */
    StudentChoose queryByClassIdAndStudentId(@Param("classId") Integer classId, @Param("studentId") Integer studentId);
    /**
     * 显示学生信息
     * @param userId
     * @return
     */
    Student select(@Param("userId") Integer userId);

    /**
     * 更改学生信息
     * @param student
     * @return
     */
    Integer update(Student student);

    /**
     * 更改学生密码
     * @param user
     * @return
     */
    Integer updatePassword(User user);
    /**
     * 根据学生ID获取信息
     * @param classId
     * @return
     */
    List<Map> queryStudent(Integer classId);

    /**
     * 删除班级学生
     * @param studentId
     * @return
     */
    Integer deleteStudent(Integer studentId);

    /**
     * 学生所做试卷
     * @param studentId
     * @return
     */
    List<Map> queryWrongPaper(Integer studentId);
    /**
     * 获取学生选择错误试题
     * @param studentId
     * @return
     */
    List<Map> queryWrongChoice(@Param("studentId")Integer studentId,@Param("paperId")Integer paperId);

    /**
     * 获取学生填空错误试题
     * @param studentId
     * @return
     */
    List<Map> queryWrongBlank(@Param("studentId")Integer studentId,@Param("paperId")Integer paperId);

    /**
     * 学生判断题
     * @param studentId
     * @param paperId
     * @return
     */
    List<Map> queryWrongJudge(@Param("studentId")Integer studentId,@Param("paperId")Integer paperId);

    /**
     * 学生简打题
     * @param studentId
     * @param paperId
     * @return
     */
    List<Map> queryWrongDiscuss(@Param("studentId")Integer studentId,@Param("paperId")Integer paperId);

    /**
     * 学生选择的课程信息
     * @param courseId
     * @return
     */
    Course queryByCourseContent(@Param("courseId") Integer courseId);
}
