package com.xg.mall.dao;

import com.xg.mall.po.XgwhAccess;

import java.util.List;

public interface XgwhAccessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhAccess record);

    int insertSelective(XgwhAccess record);

    XgwhAccess selectByPrimaryKey(Integer id);
    List<XgwhAccess> select();
    int updateByPrimaryKeySelective(XgwhAccess record);

    int updateByPrimaryKey(XgwhAccess record);
}