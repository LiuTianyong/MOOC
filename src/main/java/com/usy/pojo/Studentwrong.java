package com.usy.pojo;

public class Studentwrong {
    //错题id
    private Integer wrongId;
    //学生id
    private Integer studentId;
    //学生名字
    private  String studentName;
    //学生学号
    private  String studentNumber;
    //试卷id
    private Integer paperId;
    //题目类型
    private Integer queType;
    //题目id
    private Integer queId;
    //错题知识点
    private String wrongKnow;
    //小节名
    private String subName;
    //错误次数
    private Integer wrongSum;
    //题目类型字段
    private String queToType;

    public Integer getWrongId() {
        return wrongId;
    }

    public void setWrongId(Integer wrongId) {
        this.wrongId = wrongId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getQueType() {
        return queType;
    }

    public void setQueType(Integer queType) {
        this.queType = queType;
    }

    public Integer getQueId() {
        return queId;
    }

    public void setQueId(Integer queId) {
        this.queId = queId;
    }

    public String getWrongKnow() {
        return wrongKnow;
    }

    public void setWrongKnow(String wrongKnow) {
        this.wrongKnow = wrongKnow;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Integer getWrongSum() {
        return wrongSum;
    }

    public void setWrongSum(Integer wrongSum) {
        this.wrongSum = wrongSum;
    }

    public String getQueToType() {
        return queToType;
    }

    public void setQueToType(String queToType) {
        this.queToType = queToType;
    }
}
