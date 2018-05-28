package com.xg.mall.dao;

import com.xg.mall.po.XgwhShopCategrey;

import java.util.List;

public interface XgwhShopCategreyMapper {
    int deleteByPrimaryKey(Integer cateId);

    int insertSelective(XgwhShopCategrey record);

    List<XgwhShopCategrey> select(XgwhShopCategrey record);

    int updateByPrimaryKeySelective(XgwhShopCategrey record);

    XgwhShopCategrey selectById(Integer cateId);
}