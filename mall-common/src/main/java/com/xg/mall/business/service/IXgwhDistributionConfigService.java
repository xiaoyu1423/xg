package com.xg.mall.business.service;

import com.xg.mall.po.XgwhDistributionConfig;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-14
 */
public interface IXgwhDistributionConfigService {
       XgwhDistributionConfig select(Integer type);
       boolean update(XgwhDistributionConfig xgwhDistributionConfig);
       boolean add(XgwhDistributionConfig xgwhDistributionConfig);
}
