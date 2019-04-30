package com.lgs.entity;

import java.util.Date;

public class Audit {
    private Integer id;

    private String realName;

    private Integer userId;

    private String username;

    private String cardId;

    private Integer diplomaId;

    private String diploma;

    private String city;

    private Integer age;

    private String sex;

    private String photo;

    private String auditImage;

    private Byte deleted;

    private Byte status;

    private Date accessTime;

    private String adminId;

    private String adminName;

    private Date createTime;

    private Date updateTime;

    public Audit(Integer id, String realName, Integer userId, String username, String cardId, Integer diplomaId, String diploma, String city, Integer age, String sex, String photo, String auditImage, Byte deleted, Byte status, Date accessTime, String adminId, String adminName, Date createTime, Date updateTime) {
        this.id = id;
        this.realName = realName;
        this.userId = userId;
        this.username = username;
        this.cardId = cardId;
        this.diplomaId = diplomaId;
        this.diploma = diploma;
        this.city = city;
        this.age = age;
        this.sex = sex;
        this.photo = photo;
        this.auditImage = auditImage;
        this.deleted = deleted;
        this.status = status;
        this.accessTime = accessTime;
        this.adminId = adminId;
        this.adminName = adminName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Audit() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getAuditImage() {
        return auditImage;
    }

    public void setAuditImage(String auditImage) {
        this.auditImage = auditImage == null ? null : auditImage.trim();
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
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