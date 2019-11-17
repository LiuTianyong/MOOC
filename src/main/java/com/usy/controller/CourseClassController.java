package com.usy.controller;

import com.usy.pojo.CourseChap;
import com.usy.pojo.CourseClass;
import com.usy.service.CourseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/class")
public class CourseClassController {
    /**
     * 开设班级后根据课程Id查询是否有相应的章节
     * 有显示，没有就去开设章节
     */
    @Autowired
    private CourseClassService courseClassService;
    @RequestMapping("openClass")
    public String specifiedClass(CourseClass courseClass, CourseChap courseChap, Model model){
        System.out.println(courseClass);
        List<CourseChap> list=courseClassService.queryChap(courseChap);
        if (courseClassService.insert(courseClass)){
            model.addAttribute("COURSECLASS",courseClass);
            model.addAttribute("COURSECHAP",list);
            System.out.println(list);
            if(list.size()!=0) {
                return "teacher/queryClass";
            }
            else{
                return "teacher/openingchapters";
            }
        }else {
            //重定向，重新开设
            return "redirect:/jsp/teacher/openClass.jsp";
        }
    }

    /**
     * 显示课程班级
     * @param courseId
     * @param model
     * @return
     */
    @RequestMapping("/queryClass")
    public String getClass(@RequestParam("courseId") Integer courseId, Model model){
        List<CourseClass> courseClass = courseClassService.getClass(courseId);
        model.addAttribute("CLASS",courseClass);
        return "teacher/classInfo";
    }

    /**
     * 删除课程班级
     * @param classId
     * @return
     */
    @RequestMapping("/deleteClass")
    public String deleteClass(@RequestParam("classId")Integer classId,@RequestParam("courseId")Integer courseId,Model model){
        courseClassService.deleteClass(classId);
        List<CourseClass> courseClass = courseClassService.getClass(courseId);
        model.addAttribute("CLASS",courseClass);
        return "teacher/classInfo";
    }

    /**
     * 显示班级信息
     * @param classId
     * @param model
     * @return
     */
    @RequestMapping("/classInfo")
    public String courseClass(@RequestParam("classId") Integer classId, Model model) {
        CourseClass courseClass = courseClassService.queryClass(classId);
        model.addAttribute("CLASSINFO", courseClass);
        return "teacher/updateClass";
    }

    /**
     * 更改班级信息
     * @param courseClass
     * @param model
     * @return
     */
    @RequestMapping("/updateClass")
    public String updateClassInfo(CourseClass courseClass, @PathVariable("classId") Integer classId, Model model) {
        courseClassService.updateClass(courseClass);
        CourseClass courseClass1 = courseClassService.queryClass(classId);
        model.addAttribute("CLASSINFO", courseClass1);
        return "teacher/updateClass";
    }

    //获取当前老师所管理的所有班级信息
    @RequestMapping("/queryAllClass/{teacherId}")
    public String queryAllClass(@PathVariable("teacherId")Integer teacherId,Model model){
        model.addAttribute("teacherId",teacherId);
        List<CourseClass> courseClasses =courseClassService.queryAllclass(teacherId);
        model.addAttribute("courseClasses",courseClasses);
        return "/teacher/allcourseClasses";
    }
    /**
     * 班级学生课程错题总体情况
     * @param classId
     * @param model
     * @return
     */
    @RequestMapping("classWrongInfo")
    public String classWrongInfo(@RequestParam("classId") Integer classId, Model model){
        List<Map> know=courseClassService.queryWrongInfo(classId);
        model.addAttribute("KNOW",know);
        return "teacher/classWrongInfo";
    }
}
