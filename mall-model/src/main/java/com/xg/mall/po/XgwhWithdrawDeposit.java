package com.xg.mall.po;

import java.math.BigDecimal;

public class XgwhWithdrawDeposit {
    private Integer withdrawId;

    private BigDecimal withdrawMoney;

    private Integer addTime;

    private Integer updateTime;

    private Byte withdrawStatus;

    private String withdrawAlipay;

    private Integer memberId;

    private String outTradeNo;

    private Integer endTime;

    private String strAddTime;

    private String strUpdateTime;

    private Integer page;

    private Integer pageNum;

    private String strEndTime;

    private Integer intEndTime;

    public Integer getIntEndTime() {
        return intEndTime;
    }

    public void setIntEndTime(Integer intEndTime) {
        this.intEndTime = intEndTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getStrEndTime() {
        return strEndTime;
    }

    public void setStrEndTime(String strEndTime) {
        this.strEndTime = strEndTime;
    }

    public String getStrAddTime() {
        return strAddTime;
    }

    public void setStrAddTime(String strAddTime) {
        this.strAddTime = strAddTime;
    }

    public String getStrUpdateTime() {
        return strUpdateTime;
    }

    public void setStrUpdateTime(String strUpdateTime) {
        this.strUpdateTime = strUpdateTime;
    }

    public Integer getEndTime() { return endTime; }

    public void setEndTime(Integer endTime) { this.endTime = endTime; }

    public Integer getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(Integer withdrawId) {
        this.withdrawId = withdrawId;
    }

    public BigDecimal getWithdrawMoney() {
        return withdrawMoney;
    }

    public void setWithdrawMoney(BigDecimal withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
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

    public Byte getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(Byte withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    public String getWithdrawAlipay() {
        return withdrawAlipay;
    }

    public void setWithdrawAlipay(String withdrawAlipay) {
        this.withdrawAlipay = withdrawAlipay == null ? null : withdrawAlipay.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }
}