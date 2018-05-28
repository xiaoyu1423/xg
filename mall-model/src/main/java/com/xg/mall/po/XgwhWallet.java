package com.xg.mall.po;

public class XgwhWallet {
    private Integer walletId;

    private String walletName;

    private Byte walletType;

    private Integer addTime;

    private Integer walletStatus;

    public Integer getWalletStatus() { return walletStatus; }

    public void setWalletStatus(Integer walletStatus) { this.walletStatus = walletStatus; }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName == null ? null : walletName.trim();
    }

    public Byte getWalletType() {
        return walletType;
    }

    public void setWalletType(Byte walletType) {
        this.walletType = walletType;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }
}