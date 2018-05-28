package com.xg.mall.po;

import java.math.BigDecimal;

public class XgwhMemberWallet {
    private Integer memberWalletId;

    private String memberWalletName;

    private BigDecimal memberWalletMoney;

    private Integer memberId;

    private Integer walletId;

    private Integer addTime;

    private Integer updateTime;

    private BigDecimal shopincome;

    private BigDecimal FYQ;

    private BigDecimal grain;

    private BigDecimal withdrawMoney;

    private BigDecimal surplus;

    public BigDecimal getSurplus() {
        return surplus;
    }

    public void setSurplus(BigDecimal surplus) {
        this.surplus = surplus;
    }

    public BigDecimal getWithdrawMoney() {
        return withdrawMoney;
    }

    public void setWithdrawMoney(BigDecimal withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    public BigDecimal getGrain() {
        return grain;
    }

    public void setGrain(BigDecimal grain) {
        this.grain = grain;
    }

    public BigDecimal getFYQ() {
        return FYQ;
    }

    public void setFYQ(BigDecimal FYQ) {
        this.FYQ = FYQ;
    }

    public BigDecimal getShopincome() {
        return shopincome;
    }

    public void setShopincome(BigDecimal shopincome) {
        this.shopincome = shopincome;
    }

    public Integer getMemberWalletId() {
        return memberWalletId;
    }

    public void setMemberWalletId(Integer memberWalletId) {
        this.memberWalletId = memberWalletId;
    }

    public String getMemberWalletName() {
        return memberWalletName;
    }

    public void setMemberWalletName(String memberWalletName) {
        this.memberWalletName = memberWalletName == null ? null : memberWalletName.trim();
    }

    public BigDecimal getMemberWalletMoney() {
        return memberWalletMoney;
    }

    public void setMemberWalletMoney(BigDecimal memberWalletMoney) {
        this.memberWalletMoney = memberWalletMoney;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
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