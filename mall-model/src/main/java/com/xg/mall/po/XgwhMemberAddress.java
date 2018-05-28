package com.xg.mall.po;

public class XgwhMemberAddress {
    private Integer id;

    private String userName;

    private String phone;

    private String province;

    private String city;

    private String county;

    private String street;

    private Byte type;

    private Integer provinceVal;

    private Integer cityVal;

    private Integer countyVal;

    private Integer addTime;

    private Integer updateTime;

    private Integer memberId;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}