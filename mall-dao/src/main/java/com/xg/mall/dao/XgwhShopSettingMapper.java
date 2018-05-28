package com.xg.mall.dao;

import com.xg.mall.po.XgwhShopSetting;

import java.util.List;

public interface XgwhShopSettingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhShopSetting record);

    int insertSelective(XgwhShopSetting record);

    XgwhShopSetting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XgwhShopSetting record);

    int updateByPrimaryKey(XgwhShopSetting record);

    List<XgwhShopSetting> selectAll();
}