package com.xg.mall.po;

public class XgwhUser {
    private Integer id;

    private String userName;

    private String userPassword;

    private Integer addTime;

    private Integer isAdmin;

    private String mobile;

    private  XgwhUserRole xgwhUserRole;

    private String strTime;

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public XgwhUserRole getXgwhUserRole() { return xgwhUserRole; }

    public void setXgwhUserRole(XgwhUserRole xgwhUserRole) { this.xgwhUserRole = xgwhUserRole; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
}