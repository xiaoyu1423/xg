package com.xg.mall.po;

public class XgwhMemberClosure {
    private Integer ancestor;

    private Integer descendant;

    private Integer distance;

    private Integer memberId;

    private String memberUsername;

    private String memberNickname;

    public Integer getMemberId() { return memberId; }

    public void setMemberId(Integer memberId) { this.memberId = memberId; }

    public String getMemberUsername() { return memberUsername; }

    public void setMemberUsername(String memberUsername) { this.memberUsername = memberUsername; }

    public String getMemberNickname() { return memberNickname; }

    public void setMemberNickname(String memberNickname) { this.memberNickname = memberNickname; }

    public Integer getAncestor() {
        return ancestor;
    }

    public void setAncestor(Integer ancestor) {
        this.ancestor = ancestor;
    }

    public Integer getDescendant() {
        return descendant;
    }

    public void setDescendant(Integer descendant) {
        this.descendant = descendant;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}