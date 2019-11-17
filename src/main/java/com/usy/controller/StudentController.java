package com.usy.controller;

import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
import com.usy.pojo.*;
import com.usy.service.CourseService;
import com.usy.service.StudentMarkandcomService;
import com.usy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //列出当前登录用户所选课程（根据USER.userId查找）
    @RequestMapping("/allclass1/{userId}")
    public String allclass(@PathVariable("userId")Integer userId, Model model){
        model.addAttribute("userId",userId);
        List<Course> courses =studentService.queryAllcourse(userId);
        model.addAttribute("courses",courses);
        return "/student/allclass";
    }

    @RequestMapping("/deleteclass/{courseId}&{studentId}")//退出班级（根据USER.userId查找）
    public String deleteCourse(@PathVariable("courseId")Integer courseId,@PathVariable("studentId")Integer studentId){

        boolean suc=studentService.deletecourse(courseId,studentId);
        return "/student/index";
    }

    @RequestMapping("/query/courseId")//筛选课程（根据USER.userId查找）
    public String queryByCourseName(@RequestParam("courseName")String courseName,@RequestParam("studentId")Integer studentId,Model model){
        model.addAttribute("courseId",courseName);
        List<Course> Course=studentService.queryByCourseId(courseName,studentId);
        model.addAttribute("courses",Course);
        return "/student/allclass";
    }

    @Autowired
    private StudentMarkandcomService studentMarkandcomService;
    @RequestMapping("/addcomments/{courseId}&{studentId}&{teacherId}")//添加评论1，课程列表（allclass.jsp）跳转到此处
    public String addComments(@PathVariable("courseId")Integer courseId, @PathVariable("studentId")Integer studentId,@PathVariable("teacherId")Integer teacherId,Model model){
        model.addAttribute("teacherId",teacherId);
        model.addAttribute("courseId",courseId);
        model.addAttribute("studentId",studentId);
        return "/student/addcomment";
    }

    @RequestMapping("/add")//添加评论2，添加评论（addcomment.jsp）跳转到此处
    public String add(StudentMarkandcom studentMarkandcom,@ProbeParam("studentId")Integer studentId, Model model){
        boolean suc=studentMarkandcomService.add(studentMarkandcom);
        model.addAttribute("SUCCESS",suc);
        model.addAttribute("studentId",studentId);
        List<Course> courses =studentService.queryAllcourse(studentId);
        model.addAttribute("courses",courses);
        return "/student/allclass";
    }

    @RequestMapping("/coursemain/{userId}")
    public String allCourse(@PathVariable("userId") Integer userId,Model model){
        List<StudentChoose> studentChooses =studentService.queryByuserIdAllcourse(userId);
        model.addAttribute("courseList",studentChooses);
        return "/student/coursemain";
    }

    /**
     * 查看课程信息
     * @param course
     * @param model
     * @return
     */
    @RequestMapping("/courseinfo/{userId}")
    public String findInfo(@PathVariable("userId") Integer userId, Course course, Model model){
        model.addAttribute("studentId",userId);
        model.addAttribute("course",course);
        List<Course> list =  studentService.selectAllCourse(course);
        model.addAttribute("infocourse",list);
        return "course/infoofcourse";
    }

    /**
     * 查找特定课程
     * @param courseName
     * @param model
     * @return
     */
    @RequestMapping("/searchname")
    public String searchName(@RequestParam("studentId") Integer studentId,String courseName,Model model){
        model.addAttribute("studentId",studentId);
        model.addAttribute("courseName",courseName);
        List<Course> list = studentService.searchName(courseName);
        model.addAttribute("nameofcourse",list);
        return "course/infoofcourse";
    }

    /**
     * 找出课程拥有的班级
     * @param courseId
     * @param model
     * @return
     */
    @RequestMapping("/courseclass")
    public String findClass(Integer studentId,Integer courseId , Model model){
        model.addAttribute("studentId",studentId);
        model.addAttribute("courseId",courseId);
        List<CourseClass> list = studentService.lookClass(courseId);
        model.addAttribute("courseclassinfo",list);
        return "course/courseclassinfo";
    }

    /**
     * 查找出指定的班级
     * @param className
     * @param model
     * @return
     */
    @RequestMapping("/findclass")
    public String findClass(Integer studentId,String className,Model model){
        model.addAttribute("studentId",studentId);
        model.addAttribute("className",className);
        List<CourseClass> list = studentService.findedClass(className);
        model.addAttribute("nameofclass",list);
        return "course/courseclassinfo";
    }

    /**
     * 加入班级
     * @param classChoose
     * @return
     */
    @RequestMapping("/joinaclass")
    public String enterClass(StudentChoose classChoose,Model model){
        Course course = studentService.queryByCourseContent(classChoose.getCourseId());
        Integer classPeopleNumber = studentService.queryByClassId(classChoose.getClassId());
        Integer classNumber = studentService.queryByClassIdAndCourseId(classChoose.getClassId(),classChoose.getCourseId());
        if (course.getCourseOpen()==1){
            Boolean stuInClass = studentService.queryByClassIdAndStudentId(classChoose.getClassId(),classChoose.getStudentId());
            model.addAttribute("stuInClass",stuInClass);
            model.addAttribute("CourseOpen",true);
        }else {
            model.addAttribute("CourseOpen",false);
        }
        model.addAttribute("StudentChoose",classChoose);
        model.addAttribute("CourseOpen",true);
        if (classPeopleNumber<classNumber){
            Boolean result =studentService.insertInfo(classChoose);
            model.addAttribute("result",result);
            model.addAttribute("numberFull",false);
            System.out.println(classPeopleNumber);
        }
        model.addAttribute("result",false);
        model.addAttribute("numberFull",true);


        return "course/joinclass";
    }
    /**
     * 显示学生个人信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/studentInfo")
    public String student( Integer userId, Model model) {
        Student student = studentService.select(userId);
        model.addAttribute("STUDENT", student);
        System.out.println(student);
        return "student/studentInfo";
    }
    /**
     * 更改学生信息并实现刷新
     *
     * @param model
     * @return
     */
    @RequestMapping("/updateStudentInfo")
    public String updateStudentInfo(Student student,Integer userId,Model model) {
        studentService.update(student);
        Student student1 = studentService.select(userId);
        model.addAttribute("STUDENT", student1);
        return "student/studentInfo";
    }
    /**
     * 修改密码后返回登录界面
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("/updatePassword")
    public String updatePassword(User user, HttpServletRequest request) {
        String updatePassword = studentService.updatePassword(user);
        request.setAttribute("student", updatePassword);
        return "../jsp/login";
    }
    /**
     * 根据班级ID找对应的学生
     * @param classId
     * @param model
     * @return
     */
    @RequestMapping("/queryStudent")
    public String getStudent(@RequestParam("classId") Integer classId, Model model){
        List<Map> student = studentService.queryStudent(classId);
        System.out.println("我走到这里了");
        System.out.println(student);
        model.addAttribute("CLASSSTUDENT", student);
        return "teacher/classStudent";

    }
    /**
     * 传入视频地址
     * @param subVideo
     * @param model
     * @return
     */
    @RequestMapping("/openVideo")
    public String openVideo(String subVideo,Model model){
        model.addAttribute("subVideo",subVideo);
        return "student/video";
    }
   /**
            * 老师删除班级学生
     * @param studentId
     * @return
             */
    @RequestMapping("/deleteStudent/{studentId}/{classId}")
    public String deleteStudent(@PathVariable("studentId") Integer studentId,@PathVariable("classId") Integer classId,Model model){
        System.out.println(studentId);
        studentService.deleteStudent(studentId);
        List<Map> student = studentService.queryStudent(classId);
        model.addAttribute("CLASSSTUDENT", student);
        return "teacher/classStudent";
    }
    /**
     * 获取学生错误习题
     * @param studentId
     * @param model
     * @return
     */
    @RequestMapping("wrongPaper/{studentId}")
    public String queryWrongPaper(@PathVariable("studentId") Integer studentId,Model model){
        List<Map> map=studentService.queryWrongPaper(studentId);
        System.out.println(map);
        model.addAttribute("WRONGPAPER",map);
        return "student/studentPaper";
    }
    /**
     * 老师获取学生试卷错误习题
     * @param studentId
     * @param model
     * @return
     */
    @RequestMapping("wrongPaperInfo/{studentId}/{paperId}")
    public String wrongPaper(@PathVariable("studentId") Integer studentId,@PathVariable("paperId")Integer paperId,Model model){
        System.out.println(studentId);
        System.out.println(paperId);
        List<Map> map=studentService.queryWrongChoice(studentId,paperId);
        System.out.println(map);
        List<Map> map1=studentService.queryWrongBlank(studentId,paperId);
        List<Map> map2=studentService.queryWrongJudge(studentId,paperId);
        List<Map> map3=studentService.queryWrongDiscuss(studentId,paperId);
        model.addAttribute("WRONGCHOICE",map);
        model.addAttribute("WRONGBLANK",map1);
        model.addAttribute("WRONGJUDGE",map2);
        model.addAttribute("WRONGDISSCUSS",map3);
        return "student/studentWrongPaper";
    }
}
