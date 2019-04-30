package com.lgs.entity;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer teacherId;

    private Integer studentId;

    private Integer educationInformationId;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    public Order(Integer id, Integer teacherId, Integer studentId, Integer educationInformationId, Byte status, Date createTime, Date updateTime) {
        this.id = id;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.educationInformationId = educationInformationId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getEducationInformationId() {
        return educationInformationId;
    }

    public void setEducationInformationId(Integer educationInformationId) {
        this.educationInformationId = educationInformationId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}