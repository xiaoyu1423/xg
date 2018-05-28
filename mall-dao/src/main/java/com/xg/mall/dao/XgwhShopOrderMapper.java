package com.xg.mall.dao;

import com.xg.mall.po.XgwhShopOrder;

import java.util.List;

public interface XgwhShopOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(XgwhShopOrder record);

    int insertSelective(XgwhShopOrder record);

    XgwhShopOrder selectByPrimaryKey(Integer orderId);

    List<XgwhShopOrder> selectOrdersByMemberId(Integer memberId);

    List<XgwhShopOrder> select(XgwhShopOrder xgwhShopOrder);
    int updateByPrimaryKeySelective(XgwhShopOrder record);

    int updateByPrimaryKey(XgwhShopOrder record);
    double count(Integer id);
    List<XgwhShopOrder> select_statistics();
    List<XgwhShopOrder> selectALL();

    Integer count_order(XgwhShopOrder xgwhShopOrder);
}