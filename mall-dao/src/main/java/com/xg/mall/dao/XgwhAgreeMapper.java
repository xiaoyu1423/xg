package com.xg.mall.dao;

import com.xg.mall.po.XgwhAgree;

public interface XgwhAgreeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhAgree record);

    int insertSelective(XgwhAgree record);

    XgwhAgree selectByPrimaryKey(Integer id);

    XgwhAgree selectMemberAgreement();

    int updateByPrimaryKeySelective(XgwhAgree record);

    int updateByPrimaryKeyWithBLOBs(XgwhAgree record);

    int updateByPrimaryKey(XgwhAgree record);
}