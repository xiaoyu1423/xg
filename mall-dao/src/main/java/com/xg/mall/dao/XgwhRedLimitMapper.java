package com.xg.mall.dao;

import com.xg.mall.po.XgwhRedLimit;

import java.util.List;

public interface XgwhRedLimitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhRedLimit record);

    int insertSelective(XgwhRedLimit record);

    XgwhRedLimit selectByPrimaryKey(Integer id);

    List<XgwhRedLimit> selectAll();

    int updateByPrimaryKeySelective(XgwhRedLimit record);

    int updateByPrimaryKey(XgwhRedLimit record);
}