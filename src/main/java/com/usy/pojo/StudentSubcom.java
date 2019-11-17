package com.usy.pojo;

import java.sql.Date;

/**
 * 小节评论区实体类
 */
public class StudentSubcom extends User {
    //评论ID
    private  Integer comId;
    //小节ID
    private  Integer subId;
    //用户id
    private  Integer userId;
    //评论内容
    private String comContent;
    //评论时间
    private Date comTime;
    //课程名称
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
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
        return "StudentSubcom{" +
                "comId=" + comId +
                ", subId=" + subId +
                ", userId='" + userId + '\'' +
                ", comContent='" + comContent + '\'' +
                ", comTime=" + comTime +
                '}';
    }
}
