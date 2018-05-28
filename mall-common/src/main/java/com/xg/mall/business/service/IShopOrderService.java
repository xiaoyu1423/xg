package com.xg.mall.business.service;

import com.xg.mall.po.XgwhShopOrder;

import java.util.LinkedList;
import java.util.List;
/**
 project: com.xg.mall
 auto : zhaorui
 time : 2018-5-5
 interface: ShopOrder
 */
public interface IShopOrderService {

    //订单查询
    LinkedList select(XgwhShopOrder xgwhShopOrder);
    //订单删除
    boolean delete(Integer orderId);
    //订单详情
    XgwhShopOrder get(Integer orderId);
    //订单手动支付
    boolean update(XgwhShopOrder xgwhShopOrder);
    //统计分析
    List<XgwhShopOrder> select_statistics();
}
