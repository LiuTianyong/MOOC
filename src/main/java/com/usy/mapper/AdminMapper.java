package com.usy.mapper;

import com.usy.pojo.Admin;
import com.usy.pojo.StudentMarkandcom;
import com.usy.pojo.StudentSubcom;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface AdminMapper {
    /**
     * 根据信息去检查数据库事都存在该用户
     * @param admin
     * @return
     */
    Admin select(Admin admin);
    /**
     * 到数据库查询老师信息
     * @param
     * @return
     */
    List<Admin> queryAll();

    /**
     * 根据状态到数据库查询信息
     * @param teacherApprove
     * @return
     */
    List<Admin> queryInfo(@Param("teacherApprove") String teacherApprove);

    /**
     * 根据状态更改数据库状态信息
     * @param updateId
     * @param updateInfo
     * @return
     */
    Integer updateInfo(@Param("updateId") Integer updateId, @Param("updateInfo") Integer updateInfo);


    /**
     * 查询所有学生评论数据
     * @return
     */

    List<StudentSubcom> queryStuCommentList();
    /**
     * 删除学生评论
     * @param comId
     * @return
     */

    int deleteByComId(Integer comId);

    /**
     * 根据时间段查询评论
     * @param startStuTime
     * @param endStuTime
     * @return
     */
    List<StudentSubcom> queryByStuTime(@Param("startStuTime") Date startStuTime, @Param("endStuTime") Date endStuTime, @Param(value = "courseName") String courseName);


    /**
     * 查询所有课程评论数据
     * @return
     */
    List<StudentMarkandcom> queryMarkCommentList();
    /**
     * 删除课程评论
     * @param markId
     * @return
     */
    int deleteByMark(Integer markId);

    /**
     * 根据时间段查询课程评论
     * @param startMarkTime
     * @param endMarkTime
     * @return
     */
    List<StudentMarkandcom> queryByMarkTime(@Param("startMarkTime") Date startMarkTime, @Param("endMarkTime") Date endMarkTime, @Param(value = "courseName") String courseName);



    //int selectCount();

    /*List<Comment> findByPage(HashMap<String,Object> map);

    List<Comment> queryByTime(@Param("commentTime") Date commentTime);*/
}
