package com.usy.service;

import com.usy.pojo.Admin;
import com.usy.pojo.StudentMarkandcom;
import com.usy.pojo.StudentSubcom;

import java.sql.Date;
import java.util.List;

public interface AdminService {
    /**
     * 根据user信息去检查数据库是否有存在该用户
     * @param admin
     * @return
     */
    Admin get(Admin admin);
    /**
     * 查询老师所有信息
     * @return
     */
    List<Admin> queryAll();
    List<Admin> queryInfo(String teacherApprove);

    /**
     * 根据Id更改老师信息
     * @param updateId
     * @param updateInfo
     * @return
     */
    Integer updateInfo(Integer updateId, Integer updateInfo);

    List<StudentSubcom> queryStuCommentList();

    List<StudentSubcom> queryByStuTime(Date startStuTime, Date endStuTime, String courseName);

    int deleteByComId(Integer comId);


    List<StudentMarkandcom> queryMarkCommentList();

    List<StudentMarkandcom> queryByMarkTime(Date startMarkTime, Date endMarkTime, String courseName);

    int deleteByMark(Integer MarkId);
}
