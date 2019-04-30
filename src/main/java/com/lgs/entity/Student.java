package com.lgs.entity;

import java.util.Date;

public class Student {
    private Integer id;

    private Integer userId;

    private String snick;

    private String sname;

    private String address;

    private String city;

    private String grade;

    private String sex;

    private Integer age;

    private String rank;

    private String email;

    private String phone;

    private Byte state;

    private Date createTime;

    private Date updateTime;

    private String comment;

    public Student(Integer id, Integer userId, String snick, String sname, String address, String city, String grade, String sex, Integer age, String rank, String email, String phone, Byte state, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.snick = snick;
        this.sname = sname;
        this.address = address;
        this.city = city;
        this.grade = grade;
        this.sex = sex;
        this.age = age;
        this.rank = rank;
        this.email = email;
        this.phone = phone;
        this.state = state;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Student(Integer id, Integer userId, String snick, String sname, String address, String city, String grade, String sex, Integer age, String rank, String email, String phone, Byte state, Date createTime, Date updateTime, String comment) {
        this.id = id;
        this.userId = userId;
        this.snick = snick;
        this.sname = sname;
        this.address = address;
        this.city = city;
        this.grade = grade;
        this.sex = sex;
        this.age = age;
        this.rank = rank;
        this.email = email;
        this.phone = phone;
        this.state = state;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.comment = comment;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSnick() {
        return snick;
    }

    public void setSnick(String snick) {
        this.snick = snick == null ? null : snick.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}