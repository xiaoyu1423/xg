package com.xg.mall.business.service;

import com.xg.mall.po.XgwhRedDayConfig;

import java.util.List;

public interface IRedDayConfigService {
    //日分红设置查询
    List<XgwhRedDayConfig> selectAll();
    //日分红设置查询
    XgwhRedDayConfig selectByPrimaryKey(Integer id);
    //日分红设置添加
    boolean add(XgwhRedDayConfig xgwhRedDayConfig);
    //日分红设置修改
    boolean update(XgwhRedDayConfig xgwhRedDayConfig);
}
