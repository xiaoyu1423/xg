package com.xg.mall.po;

public class XgwhDistributionConfig {
    private Integer id;

    private String rule;

    private Byte type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule == null ? null : rule.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}