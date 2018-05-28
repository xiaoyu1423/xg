package com.xg.mall.dao;

import com.xg.mall.po.XgwhRole;

import java.util.List;

public interface XgwhRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhRole record);

    int insertSelective(XgwhRole record);

    XgwhRole selectByPrimaryKey(Integer id);
    List<XgwhRole> select();

    int updateByPrimaryKeySelective(XgwhRole record);

    int updateByPrimaryKey(XgwhRole record);
}