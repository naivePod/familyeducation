package com.lgs.entity;

import java.util.Date;

public class Teacher {
    private Integer id;

    private String realName;

    private Integer userId;

    private String username;

    private String cardId;

    private Integer diplomaId;

    private String diploma;

    private String city;

    private String birth;

    private String photo;

    private String verifiedImage;

    private Byte deleted;

    private Date createTime;

    private Date updateTime;

    private Integer subject1Id;

    private String subject1;

    private Integer subject2Id;

    private String subject2;

    private String sex;

    private String phone;

    private String profession;

    private Integer status;

    private String comment;

    public Teacher(Integer id, String realName, Integer userId, String username, String cardId, Integer diplomaId, String diploma, String city, String birth, String photo, String verifiedImage, Byte deleted, Date createTime, Date updateTime, Integer subject1Id, String subject1, Integer subject2Id, String subject2, String sex, String phone, String profession, Integer status) {
        this.id = id;
        this.realName = realName;
        this.userId = userId;
        this.username = username;
        this.cardId = cardId;
        this.diplomaId = diplomaId;
        this.diploma = diploma;
        this.city = city;
        this.birth = birth;
        this.photo = photo;
        this.verifiedImage = verifiedImage;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.subject1Id = subject1Id;
        this.subject1 = subject1;
        this.subject2Id = subject2Id;
        this.subject2 = subject2;
        this.sex = sex;
        this.phone = phone;
        this.profession = profession;
        this.status = status;
    }

    public Teacher(Integer id, String realName, Integer userId, String username, String cardId, Integer diplomaId, String diploma, String city, String birth, String photo, String verifiedImage, Byte deleted, Date createTime, Date updateTime, Integer subject1Id, String subject1, Integer subject2Id, String subject2, String sex, String phone, String profession, Integer status, String comment) {
        this.id = id;
        this.realName = realName;
        this.userId = userId;
        this.username = username;
        this.cardId = cardId;
        this.diplomaId = diplomaId;
        this.diploma = diploma;
        this.city = city;
        this.birth = birth;
        this.photo = photo;
        this.verifiedImage = verifiedImage;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.subject1Id = subject1Id;
        this.subject1 = subject1;
        this.subject2Id = subject2Id;
        this.subject2 = subject2;
        this.sex = sex;
        this.phone = phone;
        this.profession = profession;
        this.status = status;
        this.comment = comment;
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

    public Integer getDiplomaId() {
        return diplomaId;
    }

    public void setDiplomaId(Integer diplomaId) {
        this.diplomaId = diplomaId;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma == null ? null : diploma.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
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

    public Integer getSubject1Id() {
        return subject1Id;
    }

    public void setSubject1Id(Integer subject1Id) {
        this.subject1Id = subject1Id;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1 == null ? null : subject1.trim();
    }

    public Integer getSubject2Id() {
        return subject2Id;
    }

    public void setSubject2Id(Integer subject2Id) {
        this.subject2Id = subject2Id;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2 == null ? null : subject2.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setPerfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}