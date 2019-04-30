package com.lgs.entity;

import java.util.Date;

public class EducationInformation {
    private Integer id;

    private Integer teacherId;

    private String name;

    private Integer userId;

    private String nick;

    private Integer subjectId;

    private String subject;

    private String photo;

    private Byte status;

    private String city;

    private String lessonLocation;

    private Date lessonTime;

    private Integer price;

    private Date createTime;

    private Date updateTime;

    private String comment;

    public EducationInformation(Integer id, Integer teacherId, String name, Integer userId, String nick, Integer subjectId, String subject, String photo, Byte status, String city, String lessonLocation, Date lessonTime, Integer price, Date createTime, Date updateTime) {
        this.id = id;
        this.teacherId = teacherId;
        this.name = name;
        this.userId = userId;
        this.nick = nick;
        this.subjectId = subjectId;
        this.subject = subject;
        this.photo = photo;
        this.status = status;
        this.city = city;
        this.lessonLocation = lessonLocation;
        this.lessonTime = lessonTime;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public EducationInformation(Integer id, Integer teacherId, String name, Integer userId, String nick, Integer subjectId, String subject, String photo, Byte status, String city, String lessonLocation, Date lessonTime, Integer price, Date createTime, Date updateTime, String comment) {
        this.id = id;
        this.teacherId = teacherId;
        this.name = name;
        this.userId = userId;
        this.nick = nick;
        this.subjectId = subjectId;
        this.subject = subject;
        this.photo = photo;
        this.status = status;
        this.city = city;
        this.lessonLocation = lessonLocation;
        this.lessonTime = lessonTime;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.comment = comment;
    }

    public EducationInformation() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLessonLocation() {
        return lessonLocation;
    }

    public void setLessonLocation(String lessonLocation) {
        this.lessonLocation = lessonLocation == null ? null : lessonLocation.trim();
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}