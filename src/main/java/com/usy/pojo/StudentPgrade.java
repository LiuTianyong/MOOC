package com.usy.pojo;

public class StudentPgrade {
    //试卷得分情况id
    private  Integer pgradeId;
    //学生id
    private  Integer studentId;
    //试卷id
    private  Integer paperId;
    //试卷成绩
    private  Integer pgradeGrade;
    //学生名字
    private String studentName;
    //学生学号
    private String studentNumber;
    //小节名字
    private String subName;
    //章节名字
    private String chapName;
    //测试试卷类型
    private Integer paperType;
    //测试试卷类型判断字段
    private String paperToType;

    public Integer getPgradeId() {
        return pgradeId;
    }

    public void setPgradeId(Integer pgradeId) {
        this.pgradeId = pgradeId;
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

    public Integer getPgradeGrade() {
        return pgradeGrade;
    }

    public void setPgradeGrade(Integer pgradeGrade) {
        this.pgradeGrade = pgradeGrade;
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

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getChapName() {
        return chapName;
    }

    public void setChapName(String chapName) {
        this.chapName = chapName;
    }

    public Integer getPaperType() {
        return paperType;
    }

    public void setPaperType(Integer paperType) {
        this.paperType = paperType;
    }

    public String getPaperToType() {
        return paperToType;
    }

    public void setPaperToType(String paperToType) {
        this.paperToType = paperToType;
    }
}
