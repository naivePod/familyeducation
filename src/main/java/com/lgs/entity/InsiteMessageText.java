package com.lgs.entity;

import java.util.Date;

public class InsiteMessageText {
    private Integer id;

    private String title;

    private Date createTime;

    private Date updateTime;

    private Byte sendType;

    private Integer creatorId;

    private Byte deleted;

    private Integer moduleId;

    private String link;

    private String content;

    public InsiteMessageText(Integer id, String title, Date createTime, Date updateTime, Byte sendType, Integer creatorId, Byte deleted, Integer moduleId, String link) {
        this.id = id;
        this.title = title;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sendType = sendType;
        this.creatorId = creatorId;
        this.deleted = deleted;
        this.moduleId = moduleId;
        this.link = link;
    }

    public InsiteMessageText(Integer id, String title, Date createTime, Date updateTime, Byte sendType, Integer creatorId, Byte deleted, Integer moduleId, String link, String content) {
        this.id = id;
        this.title = title;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sendType = sendType;
        this.creatorId = creatorId;
        this.deleted = deleted;
        this.moduleId = moduleId;
        this.link = link;
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}