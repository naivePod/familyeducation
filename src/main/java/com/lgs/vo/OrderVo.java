package com.lgs.vo;

import com.lgs.entity.EducationInformation;

import java.util.Date;

public class OrderVo {
    private int id;

    private String teacherName;

    private String studentName;
    private String subject;

    private Byte status;

    private String city;

    private String lessonLocation;

    private Date lessonTime;

    private Integer price;

    private Date publishTime;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLessonLocation() {
        return lessonLocation;
    }

    public void setLessonLocation(String lessonLocation) {
        this.lessonLocation = lessonLocation;
    }

    public Date getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(Date lessonTime) {
        this.lessonTime = lessonTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }



    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
