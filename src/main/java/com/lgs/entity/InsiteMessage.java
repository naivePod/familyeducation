package com.lgs.entity;

import java.util.Date;

public class InsiteMessage {
    private Integer id;

    private Integer messageTextId;

    private Byte take;

    private Byte deleted;

    private Date createTime;

    private Date updateTime;

    private Integer receiverId;

    private String receiverName;

    public InsiteMessage(Integer id, Integer messageTextId, Byte take, Byte deleted, Date createTime, Date updateTime, Integer receiverId, String receiverName) {
        this.id = id;
        this.messageTextId = messageTextId;
        this.take = take;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.receiverId = receiverId;
        this.receiverName = receiverName;
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

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }
}