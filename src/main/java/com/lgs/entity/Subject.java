package com.lgs.entity;

import java.util.Date;

public class Subject {
    private Integer id;

    private String name;

    private Byte deleted;

    private Date createTime;

    private Date updateTime;

    public Subject(Integer id, String name, Byte deleted, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Subject() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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