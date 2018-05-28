package com.xg.mall.business.service;

import com.xg.mall.po.XgwhShopCategrey;

import java.util.List;

public interface IShopCateService {
    List<XgwhShopCategrey> select(XgwhShopCategrey xgwhShopCategrey);
    boolean insertSelective(XgwhShopCategrey xgwhShopCategrey);
    boolean delete(Integer cateId);
    boolean update(XgwhShopCategrey xgwhShopCategrey);
    XgwhShopCategrey selectById(Integer cateId);
}
