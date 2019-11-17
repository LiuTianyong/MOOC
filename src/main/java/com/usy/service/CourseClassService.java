package com.usy.service;

import com.usy.pojo.CourseChap;
import com.usy.pojo.CourseClass;

import java.util.List;
import java.util.Map;

public interface CourseClassService {

    /**
     * 开设班级时候，将课程班级信息插入
     * @param courseClass
     * @return
     */
    public Boolean insert(CourseClass courseClass);
    /**
     * 获取章节信息
     * @param courseChap
     * @return
     */
    List<CourseChap> queryChap(CourseChap courseChap);

    /**
     * 获取课程班级
     * @param courseId
     * @return
     */
    public List<CourseClass> getClass(Integer courseId);

    /**
     * 删除课程班级
     * @param classId
     * @return
     */
    int deleteClass(Integer classId);

    /**
     * 显示班级信息
     * @param classId
     * @return
     */
    CourseClass queryClass(Integer classId);

    /**
     *更改班级信息
     * @param courseClass
     * @return
     */
    public Integer  updateClass(CourseClass courseClass);

    /**
     *获取班级信息
     *
     *
     */
    List<CourseClass> queryAllclass(Integer teacherId);
    /**
     * 班级总体错题情况
     * @param classId
     * @return
     */
    List<Map> queryWrongInfo(Integer classId);

    /**
     * 关闭课程删除课程班级
     * @param courseId
     * @return
     */
    Integer deleteCourseClass(Integer courseId);

}
