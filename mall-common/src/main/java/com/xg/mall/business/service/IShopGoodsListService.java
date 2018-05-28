package com.xg.mall.business.service;

import com.xg.mall.po.XgwhShopGoods;

import java.util.List;

public interface IShopGoodsListService {
    List<XgwhShopGoods> select ();

    XgwhShopGoods selectById(Integer goodsId);
}
