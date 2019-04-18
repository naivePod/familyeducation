package com.lgs.entity;

public class User {
    private Integer id;

    private String name;

    private String psw;

    private Integer label;

    public User(Integer id, String name, String psw, Integer label) {
        this.id = id;
        this.name = name;
        this.psw = psw;
        this.label = label;
    }

    public User() {
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

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw == null ? null : psw.trim();
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }
}