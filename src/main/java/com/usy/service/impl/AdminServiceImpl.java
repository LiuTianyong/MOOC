package com.usy.service.impl;

import com.usy.mapper.AdminMapper;
import com.usy.pojo.Admin;
import com.usy.pojo.StudentMarkandcom;
import com.usy.pojo.StudentSubcom;
import com.usy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin get(Admin admin){
        //前置检查
        return adminMapper.select(admin);
    }
    /**
     * 去库查找
     * @return
     */
    @Override
    public List<Admin> queryAll() {
        return  adminMapper.queryAll();
    }

    @Override
    public List<Admin> queryInfo(String teacherApprove) {

        return adminMapper.queryInfo(teacherApprove);
    }

    /**
     * 去库修改
     * @param updateId
     * @param updateInfo
     * @return
     */
    @Override
    public Integer updateInfo(Integer updateId, Integer updateInfo) {
        return adminMapper.updateInfo(updateId,updateInfo);
    }

    @Override
    public List<StudentSubcom> queryStuCommentList() {
        return adminMapper.queryStuCommentList();
    }

    @Override
    public int deleteByComId(Integer comId) {
        return adminMapper.deleteByComId(comId);
    }

    @Override
    public List<StudentSubcom> queryByStuTime(Date startStuTime, Date endStuTime, String courseName) {
        return adminMapper.queryByStuTime(startStuTime,endStuTime,courseName);
    }

    @Override
    public List<StudentMarkandcom> queryMarkCommentList() {
        return adminMapper.queryMarkCommentList();
    }

    @Override
    public List<StudentMarkandcom> queryByMarkTime(Date startMarkTime, Date endMarkTime, String courseName) {
        return adminMapper.queryByMarkTime(startMarkTime,endMarkTime,courseName);
    }

    @Override
    public int deleteByMark(Integer MarkId) {
        return adminMapper.deleteByMark(MarkId);
    }
}
