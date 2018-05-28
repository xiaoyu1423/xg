package com.xg.mall.po;

import java.math.BigDecimal;

public class XgwhShopOrder {
    public String getTodayMoney() {
        return todayMoney;
    }

    public void setTodayMoney(String todayMoney) {
        this.todayMoney = todayMoney;
    }

    public String getYesterdayMoney() {
        return yesterdayMoney;
    }

    public void setYesterdayMoney(String yesterdayMoney) {
        this.yesterdayMoney = yesterdayMoney;
    }

    public String getTodayWithdraw() {
        return todayWithdraw;
    }

    public void setTodayWithdraw(String todayWithdraw) {
        this.todayWithdraw = todayWithdraw;
    }

    public String getTodayAlipayBuy() {
        return todayAlipayBuy;
    }

    public void setTodayAlipayBuy(String todayAlipayBuy) {
        this.todayAlipayBuy = todayAlipayBuy;
    }

    private Integer orderId;

    private String orderSn;

    private BigDecimal totalPrice;

    private Integer memberId;

    private Byte payType;

    private Integer addressId;

    private String contactName;

    private String mobile;

    private String address;

    private Byte orderStatus;

    private Integer addTime;

    private String strTime;
    private String goodsName;
    private Integer goodsId;

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    private  Integer endTime;

    private String totalMoney;

    private String countMembers;

    private String countOrders;

    private String todayMoney;

    private String yesterdayMoney;

    private String todayWithdraw;

    private String todayAlipayBuy;
    private String goodsCover;

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    private Integer page;

    private String strOrderTime;

    private String strOrderEndTime;

    private Integer intOrderEndTime;

    private Integer pageNum;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getIntOrderEndTime() {
        return intOrderEndTime;
    }

    public void setIntOrderEndTime(Integer intOrderEndTime) {
        this.intOrderEndTime = intOrderEndTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getStrOrderTime() {
        return strOrderTime;
    }

    public void setStrOrderTime(String strOrderTime) {
        this.strOrderTime = strOrderTime;
    }

    public String getStrOrderEndTime() {
        return strOrderEndTime;
    }

    public void setStrOrderEndTime(String strOrderEndTime) {
        this.strOrderEndTime = strOrderEndTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCover() {
        return goodsCover;
    }

    public void setGoodsCover(String goodsCover) {
        this.goodsCover = goodsCover;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getCountMembers() {
        return countMembers;
    }

    public void setCountMembers(String countMembers) {
        this.countMembers = countMembers;
    }

    public String getCountOrders() {
        return countOrders;
    }

    public void setCountOrders(String countOrders) {
        this.countOrders = countOrders;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }
}