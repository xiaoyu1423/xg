package com.xg.mall.po;

public class XgwhAccess {
    private Integer id;

    private String title;

    private String urls;

    private Integer status;

    private Integer addTime;

    private Integer result;

    public Integer getResult() { return result; }

    public void setResult(Integer result) { this.result = result; }

    private XgwhRoleAccess xgwhRoleAccess;

    public XgwhRoleAccess getXgwhRoleAccess() { return xgwhRoleAccess; }

    public void setXgwhRoleAccess(XgwhRoleAccess xgwhRoleAccess) { this.xgwhRoleAccess = xgwhRoleAccess; }

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

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls == null ? null : urls.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }
}