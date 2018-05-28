package com.xg.mall.business.service;

import com.xg.mall.po.XgwhShopOrder;

import java.util.List;

public interface IShopOrdersService {
    List<XgwhShopOrder> selectOrdersByMemberId(Integer memberId);
}
