package com.usy.pojo;

import java.sql.Date;

/**
 * 课程评论实体类
 */
public class StudentMarkandcom {
    //课程评论id
    private Integer markId;
    //评论学生id
    private Integer studentId;
    //被评论老师id
    private Integer teacherId;
    //学生对老师评分
    private Integer markTscore;
    //课程id
    private Integer courseId;
    //学生对课程评分
    private Integer markCscore;
    //课程评论信息
    private String comContent;
    //评论时间
    private Date comTime;
    //学生所属机构
    private String studentOrgan;
    //学生学号
    private String studentNumber;
    //学生姓名
    private String studentName;
    //老师姓名
    private String teacherName;
    //课程名称
    private String courseName;



    public String getStudentOrgan() {
        return studentOrgan;
    }

    public void setStudentOrgan(String studentOrgan) {
        this.studentOrgan = studentOrgan;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getMarkTscore() {
        return markTscore;
    }

    public void setMarkTscore(Integer markTscore) {
        this.markTscore = markTscore;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getMarkCscore() {
        return markCscore;
    }

    public void setMarkCscore(Integer markCscore) {
        this.markCscore = markCscore;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Date getComTime() {
        return comTime;
    }

    public void setComTime(Date comTime) {
        this.comTime = comTime;
    }

    @Override
    public String toString() {
        return "StudentMarkandcom{" +
                "markId=" + markId +
                ", studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", markTscore=" + markTscore +
                ", courseId=" + courseId +
                ", markCscore=" + markCscore +
                ", comContent='" + comContent + '\'' +
                ", comTime=" + comTime +
                ", studentOrgan='" + studentOrgan + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
