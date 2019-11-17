package com.usy.pojo;

public class CourseClass {
    // 班级ID
    private Integer classId;
    // 课程ID
    private Integer courseId;
    // 班级名称
    private String className;
    // 课程人数上限
    private Integer classAmount;
    //班级信息
    private CourseClass courseClass;
    //课程名
    private String courseName;
    //班级人数
    private Integer classnumberSum;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassAmount() {
        return classAmount;
    }

    public void setClassAmount(Integer classAmount) {
        this.classAmount = classAmount;
    }

    public CourseClass getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getClassnumberSum() {
        return classnumberSum;
    }

    public void setClassnumberSum(Integer classnumberSum) {
        this.classnumberSum = classnumberSum;
    }



    @Override
    public String toString() {
        return "CourseClass{" +
                "classId=" + classId +
                ", courseId=" + courseId +
                ", className='" + className + '\'' +
                ", classAmount=" + classAmount +
                '}';
    }
}
