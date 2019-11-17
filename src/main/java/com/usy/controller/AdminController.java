package com.usy.controller;

import com.usy.pojo.Admin;
import com.usy.pojo.StudentMarkandcom;
import com.usy.pojo.StudentSubcom;
import com.usy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(Admin admin, HttpSession session) {
        System.out.println("登陆中");
        System.out.println(admin);
        admin = adminService.get(admin);
        System.out.println(admin);
        if (admin != null) {
            session.setAttribute("SESSION_USER", admin);
            return "admin/adminInterface";
        } else {
            return "redirect:/jsp/admin/login.jsp";
        }
    }

    /**
     * 显示老师所有信息老师信息
     * @param model
     * @return
     */
    @RequestMapping("/adminTeacher")
    public String teacher(Model model){
        System.out.println("teacher。。。。。。");
        List<Admin> list=adminService.queryAll();
        model.addAttribute("admin",list);
        return "admin/adminTeacher";
    }

    /**
     * 按审核状态查询老师信息0/1
     * @param teacherApprove
     * @param model
     * @return
     */
    @RequestMapping("/teacherApprove")
    public String queryInfo(String teacherApprove, Model model){
        model.addAttribute("teacherApprove",teacherApprove);
        List<Admin> list=adminService.queryInfo(teacherApprove);
        model.addAttribute("admin",list);
        return "admin/queryInfo";
    }

    /**
     * 更改老师审核状态
     * @param updateId
     * @param updateInfo
     * @param model
     * @return
     */
    @RequestMapping("/updateInfo")
    public String updateInfo(Integer updateId, Integer updateInfo, Model model){
        model.addAttribute("updateId",updateId);
        model.addAttribute("updateInfo",updateInfo);
        Integer list=adminService.updateInfo(updateId,updateInfo);
        model.addAttribute("adminTeachers",list);
        return "redirect:adminTeacher";
    }
    /**
     * 搜索后更改老师审核状态并实现刷新
     * @param updateId
     * @param updateInfo
     * @param model
     * @return
     */
    @RequestMapping("/queryUpdateInfo")
    public String updateInfo(Integer updateId, Integer updateInfo, String teacherApprove,Model model){
        adminService.updateInfo(updateId,updateInfo);
        List<Admin> list=adminService.queryInfo(teacherApprove);
        model.addAttribute("admin",list);
        return "admin/queryInfo";
    }
    /***
     * 查询所有评论信息
     * @param model
     * @return
     */
    @RequestMapping("/comstu")
    public String comstu(Model model){
        List<StudentSubcom> subList = adminService.queryStuCommentList();//查询所有信息
        model.addAttribute("subList", subList);
        return "admin/comstu";

    }
    /**
     * 通过时间段查询评论信息
     * @param startStuTime
     * @param endStuTime
     * @param model
     * @return
     */
    @RequestMapping("/queryByStuTime")
    public String queryByTimeStu(@RequestParam(value = "startStuTime",required = false) Date startStuTime,
                                 @RequestParam(value = "endStuTime",required = false) Date endStuTime,
                                 @RequestParam(value = "courseName",required = false) String courseName,
                                 Model model) {
        List<StudentSubcom> subList =  adminService.queryByStuTime(startStuTime,endStuTime,courseName);
        model.addAttribute("subList",subList);
        return "admin/comstu";
    }

    /**
     * 删除一条信息
     * @param comId
     * @return
     */

    @RequestMapping("/deleteStu")
    public String deleteStu(Integer comId){
        adminService.deleteByComId(comId);
        return "redirect:comstu";
    }

    /**
     * 查询所有课程评论信息
     * @param model
     * @return
     */

    @RequestMapping("/commark")
    public String commark(Model model){
        List<StudentMarkandcom>  markList = adminService.queryMarkCommentList();//查询所有信息
        model.addAttribute("markList", markList);
        return "admin/commark";

    }

    /**
     * 通过时间段查询课程评论信息
     * @param startMarkTime
     * @param endMarkTime
     * @param model
     * @return
     */

    @RequestMapping("/queryByTimeMark")
    public String queryByTimeMark(@RequestParam(value = "startMarkTime",required = false) Date startMarkTime,
                                  @RequestParam(value = "endMarkTime",required = false) Date endMarkTime,
                                  @RequestParam(value = "courseName",required = false) String courseName,
                                  Model model) {
        System.out.println(startMarkTime);
        List<StudentMarkandcom> markList = adminService.queryByMarkTime(startMarkTime,endMarkTime,courseName);
        model.addAttribute("markList",markList);
        return "admin/commark";
    }

    /**
     * 删除课程一条评论信息
     * @param MarkId
     * @return
     */
    @RequestMapping("/deleteMark")
    public String deleteMark(Integer MarkId){
        adminService.deleteByMark(MarkId);
        return "redirect:commark";
    }
}
