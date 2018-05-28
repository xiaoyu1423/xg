package com.xg.mall.dao;

import com.xg.mall.po.XgwhRedDayConfig;

import java.util.List;

public interface XgwhRedDayConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhRedDayConfig record);

    int insertSelective(XgwhRedDayConfig record);

    XgwhRedDayConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XgwhRedDayConfig record);

    int updateByPrimaryKey(XgwhRedDayConfig record);

    List<XgwhRedDayConfig> selectAll();
}