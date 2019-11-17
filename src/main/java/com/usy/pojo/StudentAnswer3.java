package com.usy.pojo;

public class StudentAnswer3 {
    //学生答案id
    private Integer answerId;
    //学生id
    private Integer studentId;
    //试卷id
    private Integer paperId;
    //题目类型
    private Integer queType;
    //题目id
    private Integer queId;
    //题目答案
    private Integer answerContent;
    //学生答案对错
    private Integer answerRight;
    //所得分数
    private Integer answerGrade;
    //自定义字段，判断对应的题目编号
    private Integer paperNumber;
    //判断题对应的知识点	judge_know 自定义字段
    private String wrongKnow;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public Integer getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(Integer answerContent) {
        this.answerContent = answerContent;
    }

    public Integer getAnswerRight() {
        return answerRight;
    }

    public void setAnswerRight(Integer answerRight) {
        this.answerRight = answerRight;
    }

    public Integer getAnswerGrade() {
        return answerGrade;
    }

    public void setAnswerGrade(Integer answerGrade) {
        this.answerGrade = answerGrade;
    }

    public Integer getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(Integer paperNumber) {
        this.paperNumber = paperNumber;
    }

    public String getWrongKnow() {
        return wrongKnow;
    }

    public void setWrongKnow(String wrongKnow) {
        this.wrongKnow = wrongKnow;
    }
}
