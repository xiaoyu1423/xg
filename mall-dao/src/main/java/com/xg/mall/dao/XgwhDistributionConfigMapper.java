package com.xg.mall.dao;

import com.xg.mall.po.XgwhDistributionConfig;

public interface XgwhDistributionConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhDistributionConfig record);

    int insertSelective(XgwhDistributionConfig record);

    XgwhDistributionConfig selectByPrimaryKey(Integer id);
    XgwhDistributionConfig selectByType(Integer type);

    int updateByPrimaryKeySelective(XgwhDistributionConfig record);

    int updateByPrimaryKey(XgwhDistributionConfig record);
}