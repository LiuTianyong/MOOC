package com.usy.pojo;

import java.util.Date;

public class Admin {
    private String userAccount;
    private String userPassword;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private Integer teacherId;
    private String teacherName;
    private String teacherHp;
    private  Integer teacherGender;
    private  String teacherUid;
    private  String  teacherPnum;
    private String teacherOrgan;
    private  String teacherTitle;
    private String teacherDirect;
    private String teacherIntro;
    private float teacherGrade;
    private Integer teacherApprove;
    private Date createDate;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherHp() {
        return teacherHp;
    }

    public void setTeacherHp(String teacherHp) {
        this.teacherHp = teacherHp;
    }

    public Integer getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(Integer teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherUid() {
        return teacherUid;
    }

    public void setTeacherUid(String teacherUid) {
        this.teacherUid = teacherUid;
    }

    public String getTeacherPnum() {
        return teacherPnum;
    }

    public void setTeacherPnum(String teacherPnum) {
        this.teacherPnum = teacherPnum;
    }

    public String getTeacherOrgan() {
        return teacherOrgan;
    }

    public void setTeacherOrgan(String teacherOrgan) {
        this.teacherOrgan = teacherOrgan;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    public String getTeacherDirect() {
        return teacherDirect;
    }

    public void setTeacherDirect(String teacherDirect) {
        this.teacherDirect = teacherDirect;
    }

    public String getTeacherIntro() {
        return teacherIntro;
    }

    public void setTeacherIntro(String teacherIntro) {
        this.teacherIntro = teacherIntro;
    }

    public float getTeacherGrade() {
        return teacherGrade;
    }

    public void setTeacherGrade(float teacherGrade) {
        this.teacherGrade = teacherGrade;
    }

    public Integer getTeacherApprove() {
        return teacherApprove;
    }

    public void setTeacherApprove(Integer teacherApprove) {
        this.teacherApprove = teacherApprove;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
