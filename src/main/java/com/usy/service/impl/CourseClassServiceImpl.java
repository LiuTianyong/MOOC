package com.usy.service.impl;

import com.usy.mapper.CourseClassMapper;
import com.usy.pojo.CourseChap;
import com.usy.pojo.CourseClass;
import com.usy.service.CourseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 开设课程时，班级行为类
 */
@Service("courseClassService")
public class CourseClassServiceImpl implements CourseClassService {

    @Autowired
    private CourseClassMapper courseClassMapper;

    /**
     * 开设班级时候，将课程班级信息插入
     *
     * @param courseClass
     * @return
     */
    @Override
    public Boolean insert(CourseClass courseClass) {

        Integer result = courseClassMapper.insert(courseClass);

        if (result > 0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 获取章节信息
     * @param courseChap
     * @return
     */
    @Override
    public List<CourseChap> queryChap(CourseChap courseChap) {

        return courseClassMapper.queryChap(courseChap);

    }

    /**
     * 获取课程班级
     * @param courseId
     * @return
     */
    @Override
    public List<CourseClass> getClass(Integer courseId) {
        return courseClassMapper.getClass(courseId);
    }
    @Override
    /**
     * 删除班级
     */
    public int deleteClass(Integer classId) {
        return courseClassMapper.deleteClass(classId);
    }

    /**
     * 查询课程信息
     * @param classId
     * @return
     */
    public CourseClass queryClass(Integer classId){
        return courseClassMapper.queryClass(classId);
    }

    /**
     * 更改班级信息
     * @param courseClass
     * @return
     */
    public Integer updateClass(CourseClass courseClass){
        return courseClassMapper.updateClass(courseClass);
    }

    /**
     * 教师查询所管理的班级信息
     * @param
     * @return
     */
    @Override
    public List<CourseClass> queryAllclass(Integer teacherId){
        return courseClassMapper.queryAllclass(teacherId);
    }
    @Override
    /**
     * 获取班级错题知识点
     * @param classId
     * @return
     */
    public List<Map> queryWrongInfo(Integer classId){return courseClassMapper.queryWrongInfo(classId);}
    @Override
    /**
     * 关闭课程删除班级
     * @param courseId
     * @return
     */
    public Integer deleteCourseClass(Integer courseId){
        return courseClassMapper.deleteCourseClass(courseId);
    }
}
