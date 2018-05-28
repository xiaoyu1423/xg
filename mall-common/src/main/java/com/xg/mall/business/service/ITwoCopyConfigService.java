package com.xg.mall.business.service;

import com.xg.mall.po.XgwhTwoCopyConfig;

import java.util.List;

public interface ITwoCopyConfigService {
    List<XgwhTwoCopyConfig> selectAll();

    boolean add(XgwhTwoCopyConfig xgwhTwoCopyConfig);

    boolean update(XgwhTwoCopyConfig xgwhTwoCopyConfig);
}
