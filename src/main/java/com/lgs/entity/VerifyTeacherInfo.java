package com.lgs.entity;

public class VerifyTeacherInfo {
    private Integer id;

    private String realName;

    private Integer userId;

    private String username;

    private String cardId;

    private Integer qualificationId;

    private String qualification;

    private String city;

    private String date;

    private String verifiedImage;

    private Byte deleted;

    private Byte status;

    private String accessTime;

    private String adminId;

    private String adminName;

    private String createTime;

    private String updateTime;

    public VerifyTeacherInfo(Integer id, String realName, Integer userId, String username, String cardId, Integer qualificationId, String qualification, String city, String date, String verifiedImage, Byte deleted, Byte status, String accessTime, String adminId, String adminName, String createTime, String updateTime) {
        this.id = id;
        this.realName = realName;
        this.userId = userId;
        this.username = username;
        this.cardId = cardId;
        this.qualificationId = qualificationId;
        this.qualification = qualification;
        this.city = city;
        this.date = date;
        this.verifiedImage = verifiedImage;
        this.deleted = deleted;
        this.status = status;
        this.accessTime = accessTime;
        this.adminId = adminId;
        this.adminName = adminName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public VerifyTeacherInfo() {
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime == null ? null : accessTime.trim();
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}