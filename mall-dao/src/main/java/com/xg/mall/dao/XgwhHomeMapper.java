package com.xg.mall.dao;

import com.xg.mall.po.XgwhHome;

import java.util.List;

public interface XgwhHomeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhHome record);

    int insertSelective(XgwhHome record);

    XgwhHome selectByPrimaryKey(Integer id);

    List<XgwhHome> select();

    XgwhHome selectMemberAgreement();

    int updateByPrimaryKeySelective(XgwhHome record);

    int updateByPrimaryKey(XgwhHome record);
}