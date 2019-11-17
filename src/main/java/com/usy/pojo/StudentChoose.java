package com.usy.pojo;

import java.util.List;

public class StudentChoose {
    private Integer chooseId;
    private Integer studentId;
    private Integer courseId;
    private Integer classId;
    private List<StudentMarkandcom> studentMarkandcoms;
    private String  courseName;

    @Override
    public String toString() {
        return "StudentChoose{" +
                "chooseId=" + chooseId +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", classId=" + classId +
                '}';
    }

    public Integer getChooseId() {
        return chooseId;
    }

    public void setChooseId(Integer chooseId) {
        this.chooseId = chooseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public List<StudentMarkandcom> getStudentMarkandcoms() {
        return studentMarkandcoms;
    }

    public void setStudentMarkandcoms(List<StudentMarkandcom> studentMarkandcoms) {
        this.studentMarkandcoms = studentMarkandcoms;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
