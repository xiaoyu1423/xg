package com.xg.mall.po;

public class XgwhRole {
    private Integer id;

    private String title;

    private Integer addTime;

    private Integer status;

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

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

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }
}