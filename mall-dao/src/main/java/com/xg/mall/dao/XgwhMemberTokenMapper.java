package com.xg.mall.dao;

import com.xg.mall.po.XgwhMemberToken;

public interface XgwhMemberTokenMapper {
    int deleteByPrimaryKey(Integer tokenId);

    int insert(XgwhMemberToken record);

    int insertSelective(XgwhMemberToken record);

    XgwhMemberToken selectByPrimaryKey(Integer tokenId);

    int updateByPrimaryKeySelective(XgwhMemberToken record);

    int updateByPrimaryKey(XgwhMemberToken record);
}