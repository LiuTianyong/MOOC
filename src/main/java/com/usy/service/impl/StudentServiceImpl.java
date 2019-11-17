package com.usy.service.impl;

import com.usy.mapper.StudentMapper;
import com.usy.pojo.*;
import com.usy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean instrt(Student student) {
        Integer result = studentMapper.instrtIdHp(student);
        if (result > 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 查看当前用户所选的所有课程
     *
     */
    @Override
    public List<Course> queryAllcourse(Integer userId){
        return studentMapper.queryAllcourse(userId);
    }

    /**
     * 退选所选中的课程
     *
     */
    @Override
    public boolean deletecourse(Integer courseId, Integer studentId){
        studentMapper.deletecourse(courseId,studentId);
        return false;
    }

    /**
     * 根据课程ID来查找课程
     *
     */
    @Override
    public List<Course> queryByCourseId(String courseName,Integer studentId) {
        return studentMapper.queryByCourseId(courseName,studentId);
    }

    @Override
    public List<StudentChoose> queryByuserIdAllcourse(Integer userId) {
        return studentMapper.queryByuserIdAllcourse(userId);
    }

    @Override
    public List<Course> selectAllCourse(Course course) {
        return studentMapper.selectAllCourse(course);
    }

    @Override
    public List<Course> searchName(String courseName) {
        return studentMapper.searchName(courseName);
    }

    @Override
    public List<CourseClass> lookClass(Integer courseId) {
        return studentMapper.lookClass(courseId);
    }

    @Override
    public List<CourseClass> findedClass(String className) {
        return studentMapper.findedClass(className);
    }

    @Override
    public boolean insertInfo(StudentChoose classChoose) {
        int result =0;
        StudentChoose studentChoose =studentMapper.selectStuCourseClass(classChoose);
        if (studentChoose!=null){
        }else {
            studentMapper.insertInfo(classChoose);
            result=1;
        }
        if (result>0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 要加入班级的已加入人数
     * @param classId
     * @return
     */
    @Override
    public Integer queryByClassId(Integer classId) {
        return studentMapper.queryByClassId(classId);
    }

    /**
     * 查询班级的人数上限
     * @param classId
     * @param courseId
     * @return
     */
    @Override
    public Integer queryByClassIdAndCourseId(Integer classId, Integer courseId) {
        return studentMapper.queryByClassIdAndCourseId(classId,courseId);
    }

    /**
     *  加入的班级是否存在该学生
     * @param classId
     * @param studentId
     * @return
     */
    @Override
    public Boolean queryByClassIdAndStudentId(Integer classId, Integer studentId) {
        StudentChoose studentChoose=studentMapper.queryByClassIdAndStudentId(classId,studentId);
        if (studentChoose==null){
            return false;
        }else {
            return true;
        }
    }
    /**
            * 获取学生信息
     * @param userId
     * @return
             */
    @Override
    public Student select(Integer userId) {
        return studentMapper.select(userId);
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Override
    public String update(Student student) {

        int u=studentMapper.update(student);
        String message="";
        //数据库会返回一个int类型的数据，根据影响条数来判断操作是否成功
        if(u > 0){
            message = "修改成功";
        }else{
            message = "修改失败";
        }
        return message;
    }

    /**
     * 修改学生密码
     * @param user
     * @return
     */
    @Override
    public String updatePassword(User user){
        int u=studentMapper.updatePassword(user);
        String message="";
        //数据库会返回一个int类型的数据，根据影响条数来判断操作是否成功
        if(u > 0){
            message = "修改成功";
        }else{
            message = "修改失败";
        }
        return message;
    }
    /**
     * 多表查询获取班级学生
     * @param classId
     * @return
     */
    @Override
    public List<Map> queryStudent(Integer classId) {
        return studentMapper.queryStudent(classId);
    }
    /**
     * 删除班级学生
     */
    @Override
    public int deleteStudent(Integer studentId) {
        return studentMapper.deleteStudent(studentId);
    }

    /**
     * 学生所做试卷信息
     * @param studentId
     * @return
     */
    @Override
    public List<Map> queryWrongPaper(Integer studentId) {
        return studentMapper.queryWrongPaper(studentId);
    }

    /**
     * 查询学生选择错误信息
     * @param studentId
     * @return
     */
    @Override
    public List<Map> queryWrongChoice(Integer studentId,Integer paperId) {
        return studentMapper.queryWrongChoice(studentId,paperId);
    }
    /**
     * 查询学生填空题错误信息
     * @param studentId
     * @return
     */
    @Override
    public List<Map> queryWrongBlank(Integer studentId,Integer paperId) {
        return studentMapper.queryWrongBlank(studentId,paperId);
    }

    /**
     * 学生判断题错题
     * @param studentId
     * @param paperId
     * @return
     */
    @Override
    public List<Map> queryWrongJudge(Integer studentId,Integer paperId) {
        return studentMapper.queryWrongJudge(studentId,paperId);
    }

    /**
     * 学生简答题错题
     * @param studentId
     * @param paperId
     * @return
     */
    @Override
    public List<Map> queryWrongDiscuss(Integer studentId,Integer paperId) {
        return studentMapper.queryWrongDiscuss(studentId,paperId);
    }

    /**
     * 获取学生选择课程的信息
     * @param courseId
     * @return
     */
    @Override
    public Course queryByCourseContent(Integer courseId) {
        return studentMapper.queryByCourseContent(courseId);
    }
}
