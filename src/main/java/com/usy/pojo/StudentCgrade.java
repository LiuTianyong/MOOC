package com.usy.pojo;

public class StudentCgrade {
    //学生课程成绩id
    private Integer cgradeId;
    //学生id
    private Integer studentId;
    //学生所选课程id
    private Integer courseId;
    //学生视频观看成绩
    private Integer cgradeVideo;
    //学生平时测试成绩
    private Integer cgradePaper;
    //学生考试成绩
    private Integer cgradeExam;
    //学生总成绩
    private Integer cgradeSum;
    //学生名字
    private String studentName;
    //学生学号
    private String studentNumber;

    public Integer getCgradeId() {
        return cgradeId;
    }

    public void setCgradeId(Integer cgradeId) {
        this.cgradeId = cgradeId;
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

    public Integer getCgradeVideo() {
        return cgradeVideo;
    }

    public void setCgradeVideo(Integer cgradeVideo) {
        this.cgradeVideo = cgradeVideo;
    }

    public Integer getCgradePaper() {
        return cgradePaper;
    }

    public void setCgradePaper(Integer cgradePaper) {
        this.cgradePaper = cgradePaper;
    }

    public Integer getCgradeExam() {
        return cgradeExam;
    }

    public void setCgradeExam(Integer cgradeExam) {
        this.cgradeExam = cgradeExam;
    }

    public Integer getCgradeSum() {
        return cgradeSum;
    }

    public void setCgradeSum(Integer cgradeSum) {
        this.cgradeSum = cgradeSum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
