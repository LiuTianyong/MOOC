package com.usy.mapper;

import com.usy.pojo.StudentMarkandcom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMarkandcomMapper {
    int add(StudentMarkandcom studentMarkandcom);

    List<StudentMarkandcom> queryCourseInfoByCourseId(@Param("courseId") Integer courseId);
}
