package com.xg.mall.po;

import java.math.BigDecimal;

public class XgwhRedDayConfig {
    private Integer id;

    private BigDecimal redRate;

    private Integer addTime;

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

    public BigDecimal getRedRate() {
        return redRate;
    }

    public void setRedRate(BigDecimal redRate) {
        this.redRate = redRate;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }
}