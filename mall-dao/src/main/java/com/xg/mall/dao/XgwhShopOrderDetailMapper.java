package com.xg.mall.dao;

import com.xg.mall.po.XgwhShopOrderDetail;

public interface XgwhShopOrderDetailMapper {
    int deleteByPrimaryKey(Integer orderDetailId);

    int insert(XgwhShopOrderDetail record);

    int insertSelective(XgwhShopOrderDetail record);

    XgwhShopOrderDetail selectByPrimaryKey(Integer orderDetailId);

    int updateByPrimaryKeySelective(XgwhShopOrderDetail record);

    int updateByPrimaryKey(XgwhShopOrderDetail record);
}