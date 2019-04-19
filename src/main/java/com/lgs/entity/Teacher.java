package com.lgs.entity;

import java.util.Date;

public class Teacher {
    private Integer id;

    private String realName;

    private Integer userId;

    private String username;

    private String cardId;

    private Integer qualificationId;

    private String qualification;

    private String city;

    private String date;

    private String photo;

    private String verifiedImage;

    private Byte deleted;

    private Date createTime;

    private Date updateTime;

    public Teacher(Integer id, String realName, Integer userId, String username, String cardId, Integer qualificationId, String qualification, String city, String date, String photo, String verifiedImage, Byte deleted, Date createTime, Date updateTime) {
        this.id = id;
        this.realName = realName;
        this.userId = userId;
        this.username = username;
        this.cardId = cardId;
        this.qualificationId = qualificationId;
        this.qualification = qualification;
        this.city = city;
        this.date = date;
        this.photo = photo;
        this.verifiedImage = verifiedImage;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Teacher() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Integer getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Integer qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification == null ? null : qualification.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getVerifiedImage() {
        return verifiedImage;
    }

    public void setVerifiedImage(String verifiedImage) {
        this.verifiedImage = verifiedImage == null ? null : verifiedImage.trim();
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
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