package com.xg.mall.po;

public class XgwhMemberSecrecy {
    private Integer id;

    private String memberTrueName;

    private String memberMobile;

    private String memberIdcard;

    private String memberBankName;

    private String memberBankNo;

    private String memberAliypay;

    private Integer memberId;

    private Integer addTime;

    private Integer updateTime;

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberTrueName() {
        return memberTrueName;
    }

    public void setMemberTrueName(String memberTrueName) {
        this.memberTrueName = memberTrueName == null ? null : memberTrueName.trim();
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile == null ? null : memberMobile.trim();
    }

    public String getMemberIdcard() {
        return memberIdcard;
    }

    public void setMemberIdcard(String memberIdcard) {
        this.memberIdcard = memberIdcard == null ? null : memberIdcard.trim();
    }

    public String getMemberBankName() {
        return memberBankName;
    }

    public void setMemberBankName(String memberBankName) {
        this.memberBankName = memberBankName == null ? null : memberBankName.trim();
    }

    public String getMemberBankNo() {
        return memberBankNo;
    }

    public void setMemberBankNo(String memberBankNo) {
        this.memberBankNo = memberBankNo == null ? null : memberBankNo.trim();
    }

    public String getMemberAliypay() {
        return memberAliypay;
    }

    public void setMemberAliypay(String memberAliypay) {
        this.memberAliypay = memberAliypay == null ? null : memberAliypay.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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