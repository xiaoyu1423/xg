package com.xg.mall.po;

import java.math.BigDecimal;

public class XgwhMember {
    public String getMemberTrueName() {
        return memberTrueName;
    }

    public void setMemberTrueName(String memberTrueName) {
        this.memberTrueName = memberTrueName;
    }

    public String getMemberIdcard() {
        return memberIdcard;
    }

    public void setMemberIdcard(String memberIdcard) {
        this.memberIdcard = memberIdcard;
    }

    public String getMemberBankName() {
        return memberBankName;
    }

    public void setMemberBankName(String memberBankName) {
        this.memberBankName = memberBankName;
    }

    public String getMemberBankNo() {
        return memberBankNo;
    }

    public void setMemberBankNo(String memberBankNo) {
        this.memberBankNo = memberBankNo;
    }

    public String getMemberAliypay() {
        return memberAliypay;
    }

    public void setMemberAliypay(String memberAliypay) {
        this.memberAliypay = memberAliypay;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
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
        this.memberWalletName = memberWalletName;
    }

    public BigDecimal getMemberWalletMoney() {
        return memberWalletMoney;
    }

    public void setMemberWalletMoney(BigDecimal memberWalletMoney) {
        this.memberWalletMoney = memberWalletMoney;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    private Integer memberId;

    private String memberUsername;

    private String memberPassword;

    private Byte memberGender;

    private String memberNickname;

    private Integer addTime;

    private Integer lastTime;

    private String lastIp;

    private String memberMobile;

    private String checkCode;

    private Integer endTime;

    private String memberTrueName;

    private String memberIdcard;

    private String memberBankName;

    private String memberBankNo;

    private String memberAliypay;

    private Integer updateTime;

    private Integer memberWalletId;

    private String memberWalletName;

    private BigDecimal memberWalletMoney;

    private Integer walletId;

    private String strTime;

    private Byte memberStatus;

    private BigDecimal shopIncome;

    private BigDecimal fyq;
    private String newPassword;
    private String reNewPassword;

    private Integer page;

    private Integer pageNum;

    private Integer intTime;

    private String strAddTime;

    private String strEndTime;

    public Integer getIntTime() {
        return intTime;
    }

    public void setIntTime(Integer intTime) {
        this.intTime = intTime;
    }

    public String getStrAddTime() {
        return strAddTime;
    }

    public void setStrAddTime(String strAddTime) {
        this.strAddTime = strAddTime;
    }

    public String getStrEndTime() {
        return strEndTime;
    }

    public void setStrEndTime(String strEndTime) {
        this.strEndTime = strEndTime;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public BigDecimal getShopIncome() {
        return shopIncome;
    }

    public void setShopIncome(BigDecimal shopIncome) {
        this.shopIncome = shopIncome;
    }

    public BigDecimal getFyq() {
        return fyq;
    }

    public void setFyq(BigDecimal fyq) {
        this.fyq = fyq;
    }

    public Byte getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(Byte memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public Integer getEndTime() { return endTime; }

    public void setEndTime(Integer endTime) { this.endTime = endTime; }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername == null ? null : memberUsername.trim();
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword == null ? null : memberPassword.trim();
    }

    public Byte getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(Byte memberGender) {
        this.memberGender = memberGender;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname == null ? null : memberNickname.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getLastTime() {
        return lastTime;
    }

    public void setLastTime(Integer lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }
}