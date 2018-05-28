package com.xg.mall.po;

import java.math.BigDecimal;

public class XgwhTwoCopyConfig {
    private Integer id;

    private Integer level;

    private BigDecimal money;

    private Integer addTime;

    private Integer updateTime;

    private BigDecimal serviceCharge;

    private BigDecimal buyAgainMoney;

    private BigDecimal otherCharge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getBuyAgainMoney() {
        return buyAgainMoney;
    }

    public void setBuyAgainMoney(BigDecimal buyAgainMoney) {
        this.buyAgainMoney = buyAgainMoney;
    }

    public BigDecimal getOtherCharge() {
        return otherCharge;
    }

    public void setOtherCharge(BigDecimal otherCharge) {
        this.otherCharge = otherCharge;
    }
}