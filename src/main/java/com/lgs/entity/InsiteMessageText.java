package com.lgs.entity;

import java.util.Date;

public class InsiteMessageText {
    private Integer id;

    private String title;

    private Date createTime;

    private Date updateTime;

    private Byte sendType;

    private Byte deleted;

    private Integer moduleId;

    private String link;

    private Integer creatorId;

    private String creatorName;

    private String content;

    public InsiteMessageText(Integer id, String title, Date createTime, Date updateTime, Byte sendType, Byte deleted, Integer moduleId, String link, Integer creatorId, String creatorName) {
        this.id = id;
        this.title = title;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sendType = sendType;
        this.deleted = deleted;
        this.moduleId = moduleId;
        this.link = link;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
    }

    public InsiteMessageText(Integer id, String title, Date createTime, Date updateTime, Byte sendType, Byte deleted, Integer moduleId, String link, Integer creatorId, String creatorName, String content) {
        this.id = id;
        this.title = title;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sendType = sendType;
        this.deleted = deleted;
        this.moduleId = moduleId;
        this.link = link;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.content = content;
    }

    public InsiteMessageText() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public Byte getSendType() {
        return sendType;
    }

    public void setSendType(Byte sendType) {
        this.sendType = sendType;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}