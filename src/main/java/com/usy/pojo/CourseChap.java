package com.usy.pojo;

import java.sql.Date;
import java.util.List;

public class CourseChap {
    private Integer chapId;
    private Integer courseId;
    private String chapName;
    private Integer chapOpen;
    private Date chapBegin;
    private Date chapEnd;
    private List<CourseChapSub> courseChapSubs;

    public List<CourseChapSub> getCourseChapSubs() {
        return courseChapSubs;
    }

    public void setCourseChapSubs(List<CourseChapSub> courseChapSubs) {
        this.courseChapSubs = courseChapSubs;
    }

    public Integer getChapId() {
        return chapId;
    }

    public void setChapId(Integer chapId) {
        this.chapId = chapId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getChapName() {
        return chapName;
    }

    public void setChapName(String chapName) {
        this.chapName = chapName;
    }

    public Integer getChapOpen() {
        return chapOpen;
    }

    public void setChapOpen(Integer chapOpen) {
        this.chapOpen = chapOpen;
    }

    public Date getChapBegin() {
        return chapBegin;
    }

    public void setChapBegin(Date chapBegin) {
        this.chapBegin = chapBegin;
    }

    public Date getChapEnd() {
        return chapEnd;
    }

    public void setChapEnd(Date chapEnd) {
        this.chapEnd = chapEnd;
    }

    @Override
    public String toString() {
        return "CourseChap{" +
                "chapId=" + chapId +
                ", courseId=" + courseId +
                ", chapName='" + chapName + '\'' +
                ", chapOpen=" + chapOpen +
                ", chapBegin=" + chapBegin +
                ", chapEnd=" + chapEnd +
                ", courseChapSubs=" + courseChapSubs +
                '}';
    }
}
