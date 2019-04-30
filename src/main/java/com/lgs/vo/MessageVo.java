package com.lgs.vo;

import com.lgs.entity.InsiteMessage;
import com.lgs.entity.InsiteMessageText;

import java.util.Date;

public class MessageVo {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private InsiteMessageText insiteMessageText;

    private Integer receiverId;

    private String receiverName;

    private Byte take;

    private Byte deleted;

    private Date createTime;

    private Date updateTime;

    public InsiteMessageText getInsiteMessageText() {
        return insiteMessageText;
    }

    public void setInsiteMessageText(InsiteMessageText insiteMessageText) {
        this.insiteMessageText = insiteMessageText;
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
        this.receiverName = receiverName;
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
