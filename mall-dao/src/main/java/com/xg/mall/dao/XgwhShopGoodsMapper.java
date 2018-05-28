package com.xg.mall.dao;

import com.xg.mall.po.XgwhShopGoods;

import java.util.List;

public interface XgwhShopGoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insertSelective(XgwhShopGoods record);

    XgwhShopGoods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(XgwhShopGoods record);

    List<XgwhShopGoods> select();

    List<XgwhShopGoods> selects(XgwhShopGoods record);



}