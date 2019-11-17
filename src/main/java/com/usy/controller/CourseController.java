package com.usy.controller;

import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
import com.usy.pojo.*;
import com.usy.service.CourseClassService;
import com.usy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 课程行为类 课程相关操作
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseClassService courseClassService;
    /**
     * 开设班级获取课程Id
     * @param courseId
     * @param model
     * @return
     */
    @RequestMapping("/course")
    public String course(@RequestParam("courseId") Integer courseId, Model model){
        System.out.println("已经得到courseId： "  + courseId);
        model.addAttribute("course",courseId);
        return "teacher/openClass";
    }
    /**
     * 自动生成班级获取课程Id
     * @param courseId
     * @param model
     * @return
     */
    @RequestMapping("/createClass")
    public String course1(@RequestParam("courseId") Integer courseId, Model model){
        System.out.println("已经得到courseId： "  + courseId);
        model.addAttribute("course",courseId);
        return "teacher/createClass";
    }
    /**
     * 修改课程开设状态打开课程
     * @param courseId
     * @return
     */
    @RequestMapping("/openCourse")
    public String openCourse(@RequestParam("courseId")Integer courseId,@RequestParam("teacherId")Integer teacherId,Model model){
        courseService.updateOpenCourse(courseId);
        List<Course> course = courseService.getCourse(teacherId);
        model.addAttribute("course",course);
        return "teacher/seemycourse";
    }
    /**
     * 修改课程开设状态关闭课程
     * @param courseId
     * @return
     */
    @RequestMapping("/closeCourse")
    public String closeCourse(@RequestParam("courseId")Integer courseId,@RequestParam("teacherId")Integer teacherId,Model model){
        courseService.updateCloseCourse(courseId);
        System.out.println("我到这了");
        courseClassService.deleteCourseClass(courseId);
        List<Course> course = courseService.getCourse(teacherId);
        model.addAttribute("course",course);
        return "teacher/seemycourse";
    }
    /**
     * 开设课程，将基本信息入库
     * @param course
     * @return
     */
    @RequestMapping("/opencourse")
    public String openCourse(Course course,@ProbeParam("istolead") Integer istolead,Model model){
        // coursePublic公开状态 ：0 不公开 1 公开   courseClick 考核状态 ：0 不考核 1 考核
        System.out.println(istolead);


        if (istolead == 1){
            // 老师上传学生名单的情况,并且后台自动生成班级号

            // 不公开 考核 ——> 需要班级密码  ——> 上传名单 ——>自动完成设置班级
            if (course.getCoursePublic() == 0 && course.getCourseCheck() == 1){

                Boolean result = courseService.insert(course);
                //将课程信息传入model
                model.addAttribute("COURSE",course);

                if (result){
                    //跳转设置班级

                    return "teacher/uploadstudent";
                }
            }

        }else {
            // 老师不上传学生名单  只管开设班级
            // 不公开不考核 ——> 需要班级密码 && 自动生成系统班级一个
            if (course.getCoursePublic() == 0 && course.getCourseClick() == 0){

                Boolean result = courseService.insert(course);
                //将课程信息传入model
                model.addAttribute("COURSE",course);
                if (result){
                    //跳转设置班级
                    return "teacher/specifiedclass";
                }else {
                    //跳回
                    return "";
                }
            }


            // 公开不考核 ——> 不需要班级密码 ——> 自动生成系统班级
            if (course.getCoursePublic() == 1 && course.getCourseCheck() == 0){
                if (courseService.insertCourse(course)){
                    //跳转设置班级
                    return "";
                }
            }

            // 公开考核 ——> 不需要班级密码 ——> 跳转到设置班级页面
            System.out.println(course);
            if (course.getCoursePublic() == 1 && course.getCourseCheck() == 1){
                // 插入数据
                Boolean result = courseService.insert(course);
                //将课程信息传入model
                model.addAttribute("COURSE",course);
                if (result){
                    //跳转设置班级
                    return "teacher/specifiedclass";
                }
            }
        }
        return "";
    }

    @RequestMapping("/specifiedclass")
    public String specifiedClass(CourseClass courseClass, Model model){
        System.out.println(courseClass);
        if (courseClassService.insert(courseClass)){
            model.addAttribute("COURSECLASS",courseClass);
            return "teacher/openingchapters";
        }else {
            //重定向，重新开设
            return "redirect:/jsp/teacher/specifiedclass.jsp";
        }
    }

    @RequestMapping("/openChap")
    public String openChap(CourseChap courseChap,Model model,CourseClass courseClass){
        boolean judge = false;//判断是修改章节还是开设章节 false 为修改章节 true 为开设章节
        if (courseChap.getChapId()!=null){
            judge = true;
            System.out.println("开设章节");
        }else {
            judge = false;
            System.out.println("修改章节");
        }
        Boolean result = false;
        if (judge){
            //将小节资料插入数据库
            result = courseService.insertChap(courseChap);
        }else {
            result = courseService.updateChap(courseChap);
        }
        model.addAttribute("courseChap",courseChap);
        List<CourseChap> courseChaps = courseService.queryByCourseIdAllChap(courseChap.getCourseId());
        model.addAttribute("courseChaps",courseChaps);
        if (result){
            //跳转原页面
            return "teacher/openingchapters";
        }else {
            //跳回
            return "";
        }
    }
    @RequestMapping("/openSubMain")
    public  String openSubMain(@RequestParam("chapId")Integer chapId,Model model){
        model.addAttribute("chapId",chapId);
        return "teacher/openingchapsub";
    }

    @RequestMapping("/openSub")
    public String openSub(@RequestParam("VideoFile")MultipartFile videoFile,@RequestParam("pptFile")MultipartFile pptFile,
                          @RequestParam("MaterialFile") MultipartFile materialFile,CourseChapSub courseChapSub,
                          HttpServletRequest request,Model model)throws IOException {
        String pptFileUrl=null,videoFileUrl = null,materialFileUrl=null;//定义存入数据库的文件地址
        //判断是否有文件上传
        Boolean judgmentVideo = videoFile.isEmpty();
        Boolean judgmentPpt = pptFile.isEmpty();
        Boolean judgmentMaterial = materialFile.isEmpty();
        boolean judgmentModify;//判断是修改小节还是开设小节 false 为修改小节 true 为开设小节
        if (courseChapSub.getSubId()==null){
             judgmentModify = true;
            System.out.println("开设小节------------------");
        }else {
            judgmentModify = false;
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
            System.out.println("更新小节------------------");
        }
        //上传ppt
        if (!judgmentPpt){
            //小节文件夹位置
            String rootPptPath = request.getSession().getServletContext().getRealPath("/MOOCCourseware/");
            pptFileUrl = saveFile(pptFile,rootPptPath);
            System.out.println(pptFileUrl);
        }
        //上传视频
       if (!judgmentVideo){
           String rootVideoPath = request.getSession().getServletContext().getRealPath("/MOOCVideo/");
           videoFileUrl = saveFile(videoFile,rootVideoPath);
           System.out.println(videoFileUrl);
       }

       if (!judgmentMaterial){
           String rootMaterialPath = request.getSession().getServletContext().getRealPath("/MOOCData/");
           materialFileUrl = saveFile(materialFile,rootMaterialPath);
           System.out.println(materialFileUrl);
       }

        courseChapSub.setSubVideo(videoFileUrl);
        courseChapSub.setSubPpt(pptFileUrl);
        courseChapSub.setSubMaterial(materialFileUrl);
        Boolean result;//开设/更新小节结果
        if (judgmentModify){
            //将小节资料插入数据库
             result= courseService.insertSub(courseChapSub);
            System.out.println(courseChapSub);
        }else {
            result = courseService.updateSub(courseChapSub);
            System.out.println(courseChapSub);
        }

        //绑定章节id
        model.addAttribute("chapId",courseChapSub.getChapId());
        //返回结果
        model.addAttribute("SUCCESS",result);
        //返回插入记录
        List<CourseChapSub> chapSubs = courseService.queryByCourseIdAllSub(courseChapSub.getChapId());
        model.addAttribute("chapSubs",chapSubs);
        if (result){
            //跳转原页面
            return "teacher/openingchapsub";
        }else {
            //跳回
            return "";
        }
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

    @RequestMapping("/alterChap")
    public String alterChap(@RequestParam("chapId") Integer chapId,Model model){
        //获取章节信息
        CourseChap courseChap = courseService.queryByChapIdContent(chapId);
        model.addAttribute("courseChap",courseChap);
        return "course/alterChap";
    }

    @RequestMapping("/alterSub")
    public String alterSub(@RequestParam("subId") Integer subId,Model model){
        //获取小节信息
        CourseChapSub courseChapSub = courseService.queryBySubIdContent(subId);
        model.addAttribute("courseChapSub",courseChapSub);
        //修改试卷
        return "course/alterSub";
    }

    @RequestMapping("/deleteSub")
    public String deleteSub(@RequestParam("subId") Integer subId,Model model){
        CourseChapSub courseChapSub = courseService.queryBySubIdContent(subId);
        Boolean deleteResult = courseService.deleteBySubId(subId);
        System.out.println(courseChapSub);
        if (courseChapSub.getSubPpt()!=null){
            File pptFileDelete =new File(courseChapSub.getSubPpt());
            pptFileDelete.delete();
        }
        if (courseChapSub.getSubVideo()!=null){
            File videoFileDelete =new File(courseChapSub.getSubVideo());
            videoFileDelete.delete();
        }
        if (courseChapSub.getSubMaterial()!=null){
            File materialFileDelete =new File(courseChapSub.getSubMaterial());
            materialFileDelete.delete();
        }
        List<CourseChapSub> chapSubs = courseService.queryByCourseIdAllSub(courseChapSub.getChapId());
        //删除试卷

        //绑定章节id
        model.addAttribute("chapId",courseChapSub.getChapId());
        model.addAttribute("chapSubs",chapSubs);
        model.addAttribute("deleteResult",deleteResult);

        return "teacher/openingchapsub";
    }


    /*学生操作课程部分*/
    /*======================================================================================*/

    /**
     * 显示课程主题
     * @param model
     * @param studentId
     * @param courseId
     * @return
     */
    @RequestMapping("/coursemain")
    public String coursemain(Model model, @RequestParam("studentId")Integer studentId,@RequestParam("courseId")Integer courseId){
        List<CourseChap> courseChaps = courseService.queryByCourseIdAllChap(courseId);
        model.addAttribute("courseChaps",courseChaps);
        model.addAttribute("studentId",studentId);
        model.addAttribute("courseId",courseId);
        return "course/coursemain";
    }

    /**
     * 根据章节id显示小节
     * @param model
     * @param chapId
     * @return
     */
    @RequestMapping("/chapterhomepage")
    public String chapterhomepage(Model model,@RequestParam("chapId")Integer chapId,@RequestParam("courseId")Integer courseId){
        List<CourseChapSub> courseChapSubs = courseService.queryByCourseIdAllSub(chapId);
        model.addAttribute("chapId",chapId);
        model.addAttribute("courseId",courseId);
        model.addAttribute("courseChapSubs",courseChapSubs);
        return "course/chapterhomepage";
    }

    @RequestMapping("/subhomepage")
    public String subhomepage(Model model,@RequestParam("subId")Integer subId,@RequestParam("courseId")Integer courseId){
        model.addAttribute("subId",subId);
        model.addAttribute("courseId",courseId);
        CourseChapSub sub = courseService.queryBySubIdContent(subId);//显示小节信息
        System.out.println(sub);
        List<StudentSubcom> stuList =courseService.queryStuCommentList(subId);//显示用户评论
        model.addAttribute("subList", stuList);
        model.addAttribute("sub",sub);
        return "course/subhomepage";
    }

    /**
     * 用户评论信息插入语句
     * @param studentSubcom
     * @return
     */
    @RequestMapping("/insertComment")
    public String insertComment(StudentSubcom studentSubcom,Model model){
        model.addAttribute("subId",studentSubcom.getSubId());
        courseService.insertComment(studentSubcom);
        return "redirect:subhomepage";
    }

    /**
     * 查询小节错误信息
     * @param studentId
     * @param subId
     * @param model
     * @return
     */
    @RequestMapping("/wrongSub")
    public String wrongSub(@RequestParam("studentId") Integer studentId,@RequestParam("subId") Integer subId, Model model){
        List<Studentwrong> wrongList =courseService.queryWrongList(studentId,subId);//显示小节错题情况
        model.addAttribute("wrongList",wrongList);
        return "course/wrongSub";
    }

    /**
     * 查询章节错题信息
     * @param studentId
     * @param chapId
     * @param model
     * @return
     */
    @RequestMapping("/wrongChap")
    public String wrongChap(@RequestParam("studentId")Integer studentId,@RequestParam("chapId") Integer chapId, Model model){
        List<Studentwrong> wrongChapList =courseService.queryWrongListByChap(studentId,chapId);//显示章节错题情况
        model.addAttribute("wrongChapList",wrongChapList);
        return "course/wrongChap";
    }

    /**
     * 课程学习情况查询，包括课程错题，视频，成绩及总成绩
     * @param studentId
     * @param courseId
     * @param map
     * @return
     */
    @RequestMapping("/courseLearning")
    public String courseLearning(Integer studentId, Integer courseId, Map<String,Object> map){
        List<Studentwrong> wrongCourseList =courseService.queryWrongListByCourse(studentId,courseId);//显示课程错题情况
        List<StudentVideo> videoCourseProgressList =courseService.queryVideoAllProgress(studentId,courseId);//显示视频观看总情况
        List<StudentPgrade> studentPgradesList = courseService.queryStudentPgradesList(studentId,courseId);//显示测试成绩
        List<StudentCgrade> studentCgradesList = courseService.queryStudentCgradesList(studentId,courseId);//显示课程总成绩
        //视频观看状态判断
        for (StudentVideo stu:videoCourseProgressList
        ) {
            if (stu.getVideoStatus()==0){
                stu.setVideoToStatus("未观看");
            }else {
                stu.setVideoToStatus("已观看");
            }
        }
        //试卷的题型状态判断
        for (Studentwrong wrong:wrongCourseList
        ) {
            if (wrong.getQueType()==1){
                wrong.setQueToType("选择题");
            }else if (wrong.getQueType()==2){
                wrong.setQueToType("填空题");
            }else if(wrong.getQueType()==3){
                wrong.setQueToType("判断题");
            }else{
                wrong.setQueToType("填空题");
            }
        }
        //试卷类型状态判断
        for (StudentPgrade pgrade: studentPgradesList
        ) {
            if (pgrade.getPaperType()==1){
                pgrade.setPaperToType("小节测试");
            }else if(pgrade.getPaperType()==2){
                pgrade.setPaperToType("章节测试");
            }else{
                pgrade.setPaperToType("课程测试");
            }
        }
        map.put("wrongCourseList",wrongCourseList);
        map.put("videoCourseProgressList",videoCourseProgressList);
        map.put("studentPgradesList",studentPgradesList);
        map.put("studentCgradesList",studentCgradesList);
        return "course/courseLearning";
    }

}
