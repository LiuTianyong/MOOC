package com.usy.pojo;

public class StudentAnswer4 {
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
    private String answerContent;
    //学生答案对错
    private Integer answerRight;
    //所得分数
    private Integer answerGrade;
    //自定义字段，简答题对应的题目编号
    private Integer paperNumber;
    //判断题对应的知识点	discuss_know 自定义字段
    private String wrongKnow;
    //学生姓名
    private String studentName;
    //简答题题目
    private String discussQue;



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

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDiscussQue() {
        return discussQue;
    }

    public void setDiscussQue(String discussQue) {
        this.discussQue = discussQue;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentAnswer4{");
        sb.append("answerId=").append(answerId);
        sb.append(", studentId=").append(studentId);
        sb.append(", paperId=").append(paperId);
        sb.append(", queType=").append(queType);
        sb.append(", queId=").append(queId);
        sb.append(", answerContent='").append(answerContent).append('\'');
        sb.append(", answerRight=").append(answerRight);
        sb.append(", answerGrade=").append(answerGrade);
        sb.append(", paperNumber=").append(paperNumber);
        sb.append(", wrongKnow='").append(wrongKnow).append('\'');
        sb.append(", studentName='").append(studentName).append('\'');
        sb.append(", discussQue='").append(discussQue).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
