package com.lgs.entity;

import java.util.Date;

public class TeachInformation {
    private Integer id;

    private Integer teacherId;

    private String teacherName;

    private Integer userId;

    private String userName;

    private String photo;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    private String introduce;

    public TeachInformation(Integer id, Integer teacherId, String teacherName, Integer userId, String userName, String photo, Byte status, Date createTime, Date updateTime) {
        this.id = id;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.userId = userId;
        this.userName = userName;
        this.photo = photo;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TeachInformation(Integer id, Integer teacherId, String teacherName, Integer userId, String userName, String photo, Byte status, Date createTime, Date updateTime, String introduce) {
        this.id = id;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.userId = userId;
        this.userName = userName;
        this.photo = photo;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.introduce = introduce;
    }

    public TeachInformation() {
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}