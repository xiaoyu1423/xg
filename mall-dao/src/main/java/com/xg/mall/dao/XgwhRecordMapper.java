package com.xg.mall.dao;

import com.xg.mall.po.XgwhRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XgwhRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(XgwhRecord record);

    int insertSelective(XgwhRecord record);

    XgwhRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(XgwhRecord record);

    int updateByPrimaryKey(XgwhRecord record);

    List<XgwhRecord> selectByMemberId(@Param("memberId") Integer memberId);

    List<XgwhRecord> selectByMemberIdWalletId(@Param("memberId") Integer memberId, @Param("recordType") Integer recordType);

}