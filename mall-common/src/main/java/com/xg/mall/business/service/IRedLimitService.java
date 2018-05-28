package com.xg.mall.business.service;

import com.xg.mall.po.XgwhRedDayConfig;
import com.xg.mall.po.XgwhRedLimit;

import java.util.List;

public interface IRedLimitService {
    //业绩补助设置查询
    List<XgwhRedLimit> selectAll();
    //根据ID查询业绩补助设置
    XgwhRedLimit selectById(Integer id);
    //业绩补助设置增加
    boolean add(XgwhRedLimit xgwhRedLimit);
    //业绩补助设置删除
    boolean delete(Integer id);
    //业绩补助设置修改
    boolean update(XgwhRedLimit xgwhRedLimit);
}
