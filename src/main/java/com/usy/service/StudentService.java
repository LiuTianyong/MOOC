package com.usy.service;

import com.usy.pojo.*;

import java.util.List;
import java.util.Map;


public interface StudentService {

    /**
     * 注册进入数据库
     * @param student
     * @return Integer
     */
    public boolean instrt(Student student);

    /**
     * 查看当前用户所选的所有课程
     *
     */
    List<Course> queryAllcourse(Integer userId);

    /**
     * 退选所选中的课程
     *
     */
    boolean deletecourse(Integer courseId, Integer studentId);

    /**
     * 根据课程ID来查找课程
     *
     */
    List<Course> queryByCourseId(String courseName,Integer studentId);

    /**
     * 通过学生id查询学生的所有课程
     * @param userId
     * @return
     */
    List<StudentChoose> queryByuserIdAllcourse(Integer userId);

    /**
     * 学生查找课程
     * @param   course
     * @return List<Course_info>
     */
    public List<Course> selectAllCourse(Course course);

    /**
     * 通过课程名称搜索符合条件的课程
     * @param courseName
     * @return List<Course_info>
     */
    public List<Course> searchName(String courseName);

    /**
     * 学生查找课程
     * @param   courseId
     * @return List<CourseClass>
     */

    public List<CourseClass> lookClass(Integer courseId);
    /**
     * 学生查找班级
     * @param   className
     */
    public List<CourseClass> findedClass(String className);

    /**
     * 加入班级
     * @param classChoose
     * @return
     */
    public boolean insertInfo(StudentChoose classChoose);

    /**
     * 要加入班级的已加入人数
     * @param classId
     * @return
     */
    Integer queryByClassId(Integer classId);

    /**
     * 查询班级的人数上限
     * @param classId
     * @param courseId
     * @return
     */
    Integer queryByClassIdAndCourseId(Integer classId, Integer courseId);

    /**
     * 加入的班级是否存在该学生
     * @param classId
     * @param studentId
     * @return
     */
    Boolean queryByClassIdAndStudentId(Integer classId, Integer studentId);
    /**
     * 显示学生信息
     * @param userId
     * @return
     */
    Student select(Integer userId);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public String update(Student student);

    /**
     * 修改学生密码
     * @param user
     * @return
     */
    public String updatePassword(User user);
    /**
     * 多表查询获取学生信息
     * @param classId
     * @return
     */
    List<Map> queryStudent(Integer classId);

    /**
     * 删除班级学生
     * @param studentId
     * @return
     */
    int deleteStudent(Integer studentId);

    /**
     * 获取学生所做试卷
     * @param studentId
     * @return
     */
    List<Map> queryWrongPaper(Integer studentId);
    /**
     * 获取学生选择错误试题
     * @param studentId
     * @return
     */
    List<Map> queryWrongChoice(Integer studentId,Integer paperId);
    /**
     * 获取学生填空错误试题
     * @param studentId
     * @return
     */
    List<Map> queryWrongBlank(Integer studentId,Integer paperId);

    /**
     * 获取学生判断错题
     * @param studentId
     * @return
     */


    List<Map> queryWrongJudge(Integer studentId, Integer paperId);

    /**
     * 获取学生简答错题
     * @param studentId
     * @param paperId
     * @return
     */
    List<Map> queryWrongDiscuss(Integer studentId, Integer paperId);

    /**
     * 获取学生所选课程治疗
     * @param courseId
     * @return
     */
    Course queryByCourseContent(Integer courseId);
}
