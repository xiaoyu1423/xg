package com.xg.mall.dao;

import com.xg.mall.po.XgwhMemberSecrecy;

import java.util.List;

public interface XgwhMemberSecrecyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhMemberSecrecy record);

    int insertSelective(XgwhMemberSecrecy record);

    XgwhMemberSecrecy selectByPrimaryKey(Integer id);
    XgwhMemberSecrecy selectByMemberId(Integer memberId);
    List<XgwhMemberSecrecy> selectSecrecy(XgwhMemberSecrecy xgwhMemberSecrecy);

    int updateByPrimaryKeySelective(XgwhMemberSecrecy record);

    int updateBymemberIdSelective(XgwhMemberSecrecy record);

    int updateByPrimaryKey(XgwhMemberSecrecy record);
}