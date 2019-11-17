package com.usy.pojo;

public class StudentVideo {
    // 视频完成状态记录ID
    private Integer videoId;
    //观看视频的学生ID
    private Integer studentId;
    //学生所看视频所属小节ID
    private Integer subId;
    //学生小节视频完成状态
    private Integer videoStatus;
    //观看视频学生名字
    private String studentName;
    //观看视频学生学号
    private String studentNumber;
    //观看视频小节名字
    private String subName;
    //观看视频章节名字
    private String chapName;
    //存判断观看视频状态判断
    private String videoToStatus;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public Integer getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(Integer videoStatus) {
        this.videoStatus = videoStatus;
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

    public String getVideoToStatus() {
        return videoToStatus;
    }

    public void setVideoToStatus(String videoToStatus) {
        this.videoToStatus = videoToStatus;
    }
}
