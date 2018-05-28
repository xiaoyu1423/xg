package com.xg.mall.po;

import java.math.BigDecimal;

public class XgwhShopGoods {
    private Integer goodsId;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Byte isOnline;

    private Byte isTwoCopy;

    private Integer addTime;

    private Integer updateTime;

    private String goodsCover;

    private Integer cateId;

    private String goodsDesc;

    private String startTime;

    private String strTime;

    private Integer endTime;

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Byte getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Byte isOnline) {
        this.isOnline = isOnline;
    }

    public Byte getIsTwoCopy() {
        return isTwoCopy;
    }

    public void setIsTwoCopy(Byte isTwoCopy) {
        this.isTwoCopy = isTwoCopy;
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

    public String getGoodsCover() {
        return goodsCover;
    }

    public void setGoodsCover(String goodsCover) {
        this.goodsCover = goodsCover == null ? null : goodsCover.trim();
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }
}