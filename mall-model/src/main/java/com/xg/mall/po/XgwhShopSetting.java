package com.xg.mall.po;

public class XgwhShopSetting {
    private Integer id;

    private String shopName;

    private String shopKeyword;

    private String shopDesc;

    private String shopSetting;

    private Integer addTime;

    private Integer updateTime;

    private String strTime;

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopKeyword() {
        return shopKeyword;
    }

    public void setShopKeyword(String shopKeyword) {
        this.shopKeyword = shopKeyword == null ? null : shopKeyword.trim();
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc == null ? null : shopDesc.trim();
    }

    public String getShopSetting() {
        return shopSetting;
    }

    public void setShopSetting(String shopSetting) {
        this.shopSetting = shopSetting == null ? null : shopSetting.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }
}