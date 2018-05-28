package com.xg.mall.business.service;

import com.xg.mall.po.XgwhShopGoods;

import java.util.List;

public interface IShopGoodsService {

    List<XgwhShopGoods> select();

    List<XgwhShopGoods> selects(XgwhShopGoods xgwhShopGoods);

    XgwhShopGoods selectById(Integer id);

    boolean insert(XgwhShopGoods xgwhShopGoods);

    boolean update(XgwhShopGoods xgwhShopGoods);

    boolean delete(Integer goodsId);
}
