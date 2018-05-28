package com.xg.mall.po;

public class XgwhArea {
    private Integer areaId;

    private Integer areaParentId;

    private String areaName;

    private Byte areaType;

    private Integer addTime;

    private Integer updateTime;

    private Integer provinceVal;

    private Integer cityVal;

    private Integer countyVal;

    public Integer getProvinceVal() {
        return provinceVal;
    }

    public void setProvinceVal(Integer provinceVal) {
        this.provinceVal = provinceVal;
    }

    public Integer getCityVal() {
        return cityVal;
    }

    public void setCityVal(Integer cityVal) {
        this.cityVal = cityVal;
    }

    public Integer getCountyVal() {
        return countyVal;
    }

    public void setCountyVal(Integer countyVal) {
        this.countyVal = countyVal;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaParentId() {
        return areaParentId;
    }

    public void setAreaParentId(Integer areaParentId) {
        this.areaParentId = areaParentId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public Byte getAreaType() {
        return areaType;
    }

    public void setAreaType(Byte areaType) {
        this.areaType = areaType;
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