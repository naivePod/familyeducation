package com.lgs.entity;

import java.util.Date;

public class InsiteMessage {
    private Integer id;

    private Integer messageTextId;

    private Integer receiverId;

    private Byte take;

    private Byte deleted;

    private Date createTime;

    private Date updateTime;

    public InsiteMessage(Integer id, Integer messageTextId, Integer receiverId, Byte take, Byte deleted, Date createTime, Date updateTime) {
        this.id = id;
        this.messageTextId = messageTextId;
        this.receiverId = receiverId;
        this.take = take;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public InsiteMessage() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageTextId() {
        return messageTextId;
    }

    public void setMessageTextId(Integer messageTextId) {
        this.messageTextId = messageTextId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Byte getTake() {
        return take;
    }

    public void setTake(Byte take) {
        this.take = take;
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