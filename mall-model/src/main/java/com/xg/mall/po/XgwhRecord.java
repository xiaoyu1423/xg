package com.xg.mall.po;

import java.math.BigDecimal;

public class XgwhRecord {
    private Integer recordId;

    private BigDecimal recordMoney;

    private Byte recordDirect;

    private String recordDesc;

    private Byte recordType;

    private Integer memberId;

    private Integer recordTime;

    public Integer getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Integer recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public BigDecimal getRecordMoney() {
        return recordMoney;
    }

    public void setRecordMoney(BigDecimal recordMoney) {
        this.recordMoney = recordMoney;
    }

    public Byte getRecordDirect() {
        return recordDirect;
    }

    public void setRecordDirect(Byte recordDirect) {
        this.recordDirect = recordDirect;
    }

    public String getRecordDesc() {
        return recordDesc;
    }

    public void setRecordDesc(String recordDesc) {
        this.recordDesc = recordDesc == null ? null : recordDesc.trim();
    }

    public Byte getRecordType() {
        return recordType;
    }

    public void setRecordType(Byte recordType) {
        this.recordType = recordType;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}