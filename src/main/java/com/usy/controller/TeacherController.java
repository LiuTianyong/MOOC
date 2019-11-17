package com.usy.controller;


import com.usy.constant.ResponseCode;
import com.usy.constant.SystemConstant;
import com.usy.pojo.*;
import com.usy.service.CourseService;
import com.usy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 老师行为类
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;

/*    *//**
     *  该注册方法遗弃 改为UserController类中实现
     * @param teacher
     * @return
     *//*
    @RequestMapping("/signin")
    public String signIn(Teacher teacher){
        teacher.setTeacherHp(SystemConstant.SYSTEMHEADPICTURE);
        if(teacherService.instrt(teacher)){
            return "teacher/success";
        }else {
            return "404";
        }
    }*/

    /**
     * 该登陆方法遗弃
     * @param teacher
     * @param session
     * @return
     *//*
    @RequestMapping("/login")
    public String login(Teacher teacher,HttpSession session){

        teacher = teacherService.selectAccountPwd(teacher);

        if (teacher != null){
            //将登陆信息注入 session
            session.setAttribute("SESSION_USER",teacher);
            session.setAttribute("IDEENTIFICATION",teacher);
            return "teacher/loginsuccess";
        }else {
            return "redirect:/jsp/teacher/login.jsp";
        }
    }*/

/*    *//**
     * 该方法已经遗弃
     * @param teacher
     * @return
     *//*
    @RequestMapping("/checkaccount")
    @ResponseBody
    public Map<String,Integer> checkAccount(@RequestBody Teacher teacher){

        Map<String,Integer> map = new HashMap<>();

        int code = ResponseCode.HAS_USE;                //默认为400即  该账号已经被注册

        if (teacherService.getAccount(teacher)){
            code = ResponseCode.CAN_USE;
            map.put(ResponseCode.CODE,code);
            return map;
        }else{
            map.put(ResponseCode.CODE,code);
            return map;
        }
    }*/

    /**
     *  老师认证方法
     * @param teacher
     * @param model
     * @return
     */
    @RequestMapping("/identification")
    public String identification(Teacher teacher, Model model){

        teacher.setTeacherHp(SystemConstant.SYSTEMHEADPICTURE);
        teacher.setTeacherApprove(2);

        if (teacherService.instrt(teacher)){
            model.addAttribute("TEACHER",teacher);
            return "teacher/idfsuccess";
        }else {
            return "redirect:/jsp/teacher/identification.jsp";
        }
    }

    /**
     *  老师个人信息提取方法，主要用于个人中心信息展示
     * @param teacherId
     * @param model
     * @return 跳转到个人中心
     */
    @RequestMapping("/personalcenter/{userId}")
    public String personalcenter(@PathVariable("userId") Integer teacherId, Model model){
        Teacher teacher = teacherService.getTeacher(teacherId);
        System.out.println("已经得到该老师信息： "  + teacher);
        model.addAttribute("TEACHER",teacher);
        return "teacher/personalcenter";
    }

    /**
     * 显示出个人信息并修改
     * @param teacherId
     * @param model
     * @return
     */
    @RequestMapping("teacherinfomodify")
    public String modify(Integer teacherId, Model model){
        model.addAttribute("teacherInfo",teacherId);
        return "teacher/modifyinfo";
    }

    /**
     * 保存修改后的个人信息
     * @return
     */
    @RequestMapping("/saveinfom")
    public String saveInfo(Teacher teacherInfo,Model model){
        Teacher teacherInfo1 = teacherService.SaveTeacherInfo(teacherInfo);
        if(teacherInfo1 != null){
            model.addAttribute("teacherInfo1",teacherInfo1);
            return "teacher/saveinfo";
        }else{
            return "teacher/savefailed";
        }
    }

    /**
     * 查看账号密码
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("lookpassword")
    public String lookPw(Integer userId, Model model){
        User user1 = teacherService.lookPassword(userId);
        model.addAttribute("user1",user1);
        return "teacher/lookpw";
    }

    /**
     * 修改密码之后保存
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("changepassword")
    public String changePw(User user, Model model){
        User user2 = teacherService.changeTeacherPw(user);
        if(user2 != null){
            model.addAttribute("user1",user2);
            return "teacher/lookpw";
        }else{
            return null;
        }

    }

    /**
     * 查看老师开设的所有开设的课程
     * @param teacherId
     * @param model
     * @return
     */
    @RequestMapping("/seemycourse/{userId}")
    public String seemycourse(@PathVariable("userId") Integer teacherId,Model model){
        List<Course> course = teacherService.seeMyCourse(teacherId);
        model.addAttribute("course",course);
        return "teacher/seemycourse";
    }


    /**
     * 老师查看和修改老师一门课程的信息
     * @param course
     * @param model
     * @return
     */
    @RequestMapping("/alterCourse")
    public String alterCourse(Model model,Course course){
            course = teacherService.queryByCourseId(course.getCourseId());
            List<CourseChap> courseChaps = courseService.queryByCourseIdAllChap(course.getCourseId());
            model.addAttribute("courseChaps",courseChaps);
            model.addAttribute("course",course);
        return "teacher/alterCourse";
    }
    @RequestMapping("/alterCourse2")
    public String alterCourse2(Model model,Course course){
        teacherService.updateByCourseId(course);
        System.out.println(course);
        model.addAttribute("course",course);
        return "teacher/alterCourse";
    }

    /**
     * 删除课程
     * @param courseId
     * @param model
     * @return
     */
    @RequestMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") Integer courseId,@RequestParam("teacherId") Integer teacherId,Model model){
        List<CourseChap> courseChaps = courseService.queryByCourseIdAllChap(courseId);
        for (CourseChap chap:courseChaps
             ) {
            List<CourseChapSub> courseChapSubs = courseService.queryByCourseIdAllSub(chap.getChapId());
            for (CourseChapSub sub : courseChapSubs
            ) {
               courseService.deleteBySubId(sub.getSubId());
                if (sub.getSubPpt() != null) {
                    File pptFileDelete = new File(sub.getSubPpt());
                    pptFileDelete.delete();
                }
                if (sub.getSubVideo() != null) {
                    File videoFileDelete = new File(sub.getSubVideo());
                    videoFileDelete.delete();
                }
                if (sub.getSubMaterial() != null) {
                    File materialFileDelete = new File(sub.getSubMaterial());
                    materialFileDelete.delete();
                }

            }
            courseService.deleteByChapId(chap.getChapId());
        }
        Boolean result = courseService.deleteByCourseId(courseId);
        List<Course> course = teacherService.seeMyCourse(teacherId);
        model.addAttribute("course",course);
        return "teacher/seemycourse";
    }

    @RequestMapping("/alterChap1")
    public String alterChap1(CourseChap courseChap,Model model){
        courseChap = courseService.queryByChapIdContent(courseChap.getChapId());
        model.addAttribute("courseChap",courseChap);
        List<CourseChapSub> courseChapSub = courseService.queryByCourseIdAllSub(courseChap.getChapId());
        model.addAttribute("courseChapSub",courseChapSub);
        return "teacher/alterChap";

    }
    @RequestMapping("/alterChap2")
    public String alterChap2(CourseChap courseChap,Model model){
        Boolean result = courseService.updateChap(courseChap);
        model.addAttribute("result",result);
        List<CourseChap> courseChaps = courseService.queryByCourseIdAllChap(courseChap.getCourseId());
        model.addAttribute("courseChaps",courseChaps);
        Course course = teacherService.queryByCourseId(courseChap.getCourseId());
        model.addAttribute("course",course);
            return "teacher/alterCourse";

    }

    /**
     * 删除章节
     * @param courseChap
     * @param model
     * @return
     */
    @RequestMapping("/deleteChap")
    public String deletechap(CourseChap courseChap,Model model){
            courseChap = courseService.queryByChapIdContent(courseChap.getChapId());
            List<CourseChapSub> courseChapSubs = courseService.queryByCourseIdAllSub(courseChap.getChapId());
            for (CourseChapSub sub : courseChapSubs
            ) {
                courseService.deleteBySubId(sub.getSubId());
                if (sub.getSubPpt() != null) {
                    File pptFileDelete = new File(sub.getSubPpt());
                    pptFileDelete.delete();
                }
                if (sub.getSubVideo() != null) {
                    File videoFileDelete = new File(sub.getSubVideo());
                    videoFileDelete.delete();
                }
                if (sub.getSubMaterial() != null) {
                    File materialFileDelete = new File(sub.getSubMaterial());
                    materialFileDelete.delete();
                }
        }
            Boolean result =  courseService.deleteByChapId(courseChap.getChapId());
            List<CourseChap> courseChaps = courseService.queryByCourseIdAllChap(courseChap.getCourseId());
            Course course = teacherService.queryByCourseId(courseChap.getCourseId());
            model.addAttribute("course",course);
            model.addAttribute("courseChaps",courseChaps);
            model.addAttribute("DELETECHAP",result);
        return "teacher/alterCourse";
    }

    @RequestMapping("/alterSub1")
    public String alterSub1(CourseChapSub courseChapSub,Model model){
        courseChapSub = courseService.queryBySubIdContent(courseChapSub.getSubId());
        model.addAttribute("courseChapSub",courseChapSub);
        return "teacher/alterSub";

    }
    @RequestMapping("/alterSub2")
    public String alterSub2(@RequestParam("VideoFile") MultipartFile videoFile, @RequestParam("pptFile")MultipartFile pptFile,
                          @RequestParam("MaterialFile") MultipartFile materialFile, CourseChapSub courseChapSub,
                          HttpServletRequest request, Model model)throws IOException {
        String pptFileUrl=null,videoFileUrl = null,materialFileUrl=null;//定义存入数据库的文件地址
        //判断是否有文件上传
        Boolean judgmentVideo = videoFile.isEmpty();
        Boolean judgmentPpt = pptFile.isEmpty();
        Boolean judgmentMaterial = materialFile.isEmpty();
            if (!judgmentPpt){
                File pptFileDelete =new File(courseChapSub.getSubPpt());
                pptFileDelete.delete();
            }else {pptFileUrl = courseChapSub.getSubPpt();}
            if (!judgmentVideo){
                File videoFileDelete =new File(courseChapSub.getSubVideo());
                videoFileDelete.delete();
            }else {videoFileUrl = courseChapSub.getSubVideo();}
            if (!judgmentMaterial){
                File materialFileDelete =new File(courseChapSub.getSubMaterial());
                materialFileDelete.delete();
            }else {materialFileUrl = courseChapSub.getSubMaterial();}
        //上传ppt
        if (!judgmentPpt){
            //小节文件夹位置
            String rootPptPath = request.getSession().getServletContext().getRealPath("/MOOCCourseware/");
            pptFileUrl = saveFile(pptFile,rootPptPath);
        }
        //上传视频
        if (!judgmentVideo){
            String rootVideoPath = request.getSession().getServletContext().getRealPath("/MOOCVideo/");
            videoFileUrl = saveFile(videoFile,rootVideoPath);
        }

        if (!judgmentMaterial){
            String rootMaterialPath = request.getSession().getServletContext().getRealPath("/MOOCData/");
            materialFileUrl = saveFile(materialFile,rootMaterialPath);
        }

        courseChapSub.setSubVideo(videoFileUrl);
        courseChapSub.setSubPpt(pptFileUrl);
        courseChapSub.setSubMaterial(materialFileUrl);
        Boolean result = courseService.updateSub(courseChapSub);
        //绑定章节id
        model.addAttribute("chapId",courseChapSub.getChapId());
        //返回结果
        model.addAttribute("SUCCESS",result);
        //返回插入记录
        List<CourseChapSub> chapSubs = courseService.queryByCourseIdAllSub(courseChapSub.getChapId());
        model.addAttribute("courseChapSub",chapSubs);
        return "teacher/alterChap";
    }

    //文件上传静态方法
    public  static String saveFile(MultipartFile file,String rootPath)throws IOException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String res = sdf.format(new Date());
        // 创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));
        //原始文件名称
        String originalFileName = file.getOriginalFilename();
        //新文件名
        String newFileName =res+originalFileName;

        // 新文件
        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
        // 判断目标文件所在目录是否存在
        if( !newFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        //获取文件路径
        // 将内存中的数据写入磁盘
        file.transferTo(newFile);
        return newFile.toString();
    }

    @RequestMapping("/deleteSub")
    public String deleteSub(@RequestParam("subId") Integer subId,Model model) {
        CourseChapSub courseChapSub = courseService.queryBySubIdContent(subId);
        Boolean deleteResult = courseService.deleteBySubId(subId);
        System.out.println(courseChapSub);
        if (courseChapSub.getSubPpt() != null) {
            File pptFileDelete = new File(courseChapSub.getSubPpt());
            pptFileDelete.delete();
        }
        if (courseChapSub.getSubVideo() != null) {
            File videoFileDelete = new File(courseChapSub.getSubVideo());
            videoFileDelete.delete();
        }
        if (courseChapSub.getSubMaterial() != null) {
            File materialFileDelete = new File(courseChapSub.getSubMaterial());
            materialFileDelete.delete();
        }
        model.addAttribute("chapId", courseChapSub.getChapId());
        //返回结果
        model.addAttribute("SUCCESS", deleteResult);
        //返回插入记录
        List<CourseChapSub> chapSubs = courseService.queryByCourseIdAllSub(courseChapSub.getChapId());
        model.addAttribute("courseChapSub", chapSubs);
        return "teacher/alterChap";
    }
}
