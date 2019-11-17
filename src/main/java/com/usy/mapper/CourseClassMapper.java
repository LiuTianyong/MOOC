package com.usy.mapper;

import com.usy.pojo.CourseChap;
import com.usy.pojo.CourseClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CourseClassMapper {




    /**
     * 开设班级时候，插入信息并返回主键
     * @param courseClass
     * @return
     */
    public Integer insert(CourseClass courseClass);
    List<CourseChap> queryChap(CourseChap courseClass);

    /**
     * 根据课程id获取相应的班级
     *
     * @param courseId
     * @return
     */
    List<CourseClass> getClass(Integer courseId);

    /**
     * 删除课程班级
     * @param classId
     * @return
     */
    Integer deleteClass(Integer classId);

    /**
     * 显示班级信息
     * @param classId
     * @return
     */
    CourseClass queryClass(Integer classId);

    /**、
     * 更改班级信息
     * @param courseClass
     * @return
     */
    Integer updateClass(CourseClass courseClass);

    /**、
     * 获取班级信息
     *
     *
     */
    List<CourseClass> queryAllclass(@Param("teacherId") Integer teacherId);
    /**
     * 班级错题
     * @param classId
     * @return
     */
    List<Map> queryWrongInfo(Integer classId);
    /**
     * 关闭课程删除班级
     * @param courseId
     * @return
     */
    Integer deleteCourseClass(Integer courseId);
}
