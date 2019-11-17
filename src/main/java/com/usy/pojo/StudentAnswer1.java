package com.usy.pojo;

public class StudentAnswer1 {
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
    //题目答案1
    private String answerContent1;
    //题目答案2
    private String answerContent2;
    //题目答案3
    private String answerContent3;
    //题目答案4
    private String answerContent4;
    //题目答案5
    private String answerContent5;
    //题目答案6
    private String answerContent6;
    //题目答案7
    private String answerContent7;
    //题目答案8
    private String answerContent8;
    //题目答案9
    private String answerContent9;
    //题目答案10
    private String answerContent10;
    //学生答案对错
    private Integer answerRight;
    //所得分数
    private Integer answerGrade;
    //自定义字段(临时增加)，选择题对应的题目编号
    private Integer paperNumber;
    //选择题对应的知识点(临时增加)choice_know
    private String wrongKnow;

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

    public String getAnswerContent1() {
        return answerContent1;
    }

    public void setAnswerContent1(String answerContent1) {
        this.answerContent1 = answerContent1;
    }

    public String getAnswerContent2() {
        return answerContent2;
    }

    public void setAnswerContent2(String answerContent2) {
        this.answerContent2 = answerContent2;
    }

    public String getAnswerContent3() {
        return answerContent3;
    }

    public void setAnswerContent3(String answerContent3) {
        this.answerContent3 = answerContent3;
    }

    public String getAnswerContent4() {
        return answerContent4;
    }

    public void setAnswerContent4(String answerContent4) {
        this.answerContent4 = answerContent4;
    }

    public String getAnswerContent5() {
        return answerContent5;
    }

    public void setAnswerContent5(String answerContent5) {
        this.answerContent5 = answerContent5;
    }

    public String getAnswerContent6() {
        return answerContent6;
    }

    public void setAnswerContent6(String answerContent6) {
        this.answerContent6 = answerContent6;
    }

    public String getAnswerContent7() {
        return answerContent7;
    }

    public void setAnswerContent7(String answerContent7) {
        this.answerContent7 = answerContent7;
    }

    public String getAnswerContent8() {
        return answerContent8;
    }

    public void setAnswerContent8(String answerContent8) {
        this.answerContent8 = answerContent8;
    }

    public String getAnswerContent9() {
        return answerContent9;
    }

    public void setAnswerContent9(String answerContent9) {
        this.answerContent9 = answerContent9;
    }

    public String getAnswerContent10() {
        return answerContent10;
    }

    public void setAnswerContent10(String answerContent10) {
        this.answerContent10 = answerContent10;
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
}
