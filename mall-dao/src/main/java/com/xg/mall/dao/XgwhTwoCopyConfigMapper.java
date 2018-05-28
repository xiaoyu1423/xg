package com.xg.mall.dao;

import com.xg.mall.po.XgwhTwoCopyConfig;

import java.util.List;

public interface XgwhTwoCopyConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhTwoCopyConfig record);

    int insertSelective(XgwhTwoCopyConfig record);

    XgwhTwoCopyConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XgwhTwoCopyConfig record);

    int updateByPrimaryKey(XgwhTwoCopyConfig record);

    List<XgwhTwoCopyConfig> selectAll();
}