package com.usy.pojo;

public class CourseChapSub {
    private Integer subId;
    private Integer chapId;
    private String subName;
    private String subPpt;
    private String subVideo;
    private Integer subOpen;
    private String subKnow;
    private String subMaterial;

    @Override
    public String toString() {
        return "CourseChapSub{" +
                "subId=" + subId +
                ", chapId=" + chapId +
                ", subName='" + subName + '\'' +
                ", subPpt='" + subPpt + '\'' +
                ", subVideo='" + subVideo + '\'' +
                ", subOpen=" + subOpen +
                ", subKnow='" + subKnow + '\'' +
                ", subMaterial='" + subMaterial + '\'' +
                '}';
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public Integer getChapId() {
        return chapId;
    }

    public void setChapId(Integer chapId) {
        this.chapId = chapId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubPpt() {
        return subPpt;
    }

    public void setSubPpt(String subPpt) {
        this.subPpt = subPpt;
    }

    public String getSubVideo() {
        return subVideo;
    }

    public void setSubVideo(String subVideo) {
        this.subVideo = subVideo;
    }

    public Integer getSubOpen() {
        return subOpen;
    }

    public void setSubOpen(Integer subOpen) {
        this.subOpen = subOpen;
    }

    public String getSubKnow() {
        return subKnow;
    }

    public void setSubKnow(String subKnow) {
        this.subKnow = subKnow;
    }

    public String getSubMaterial() {
        return subMaterial;
    }

    public void setSubMaterial(String subMaterial) {
        this.subMaterial = subMaterial;
    }
}
