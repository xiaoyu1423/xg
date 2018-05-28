package com.xg.mall.dao;

import com.xg.mall.po.XgwhUser;

import java.util.List;

public interface XgwhUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhUser record);

    int insertSelective(XgwhUser record);

    XgwhUser selectByPrimaryKey(Integer id);
    List<XgwhUser> select();
    XgwhUser selectByUserName(String userName);
    int updateByPrimaryKeySelective(XgwhUser record);

    int updateByPrimaryKey(XgwhUser record);
}