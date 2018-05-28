package com.xg.mall.po;

public class XgwhShopCategrey {
    private Integer cateId;

    private String cateName;

    private Byte cateType;

    private Integer addTime;

    private Integer updateTime;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    public Byte getCateType() {
        return cateType;
    }

    public void setCateType(Byte cateType) {
        this.cateType = cateType;
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