package com.xg.mall.dao;

import com.xg.mall.po.XgwhWithdrawDeposit;

import java.util.List;

public interface XgwhWithdrawDepositMapper {
    int deleteByPrimaryKey(Integer withdrawId);

    int insert(XgwhWithdrawDeposit record);

    int insertSelective(XgwhWithdrawDeposit record);

    int dayWithdrawCounts(Integer memberId);

    XgwhWithdrawDeposit selectByPrimaryKey(Integer withdrawId);

    int updateByPrimaryKeySelective(XgwhWithdrawDeposit record);

    int updateByPrimaryKey(XgwhWithdrawDeposit record);

    List<XgwhWithdrawDeposit> select(XgwhWithdrawDeposit xgwhWithdrawDeposit);

    Integer count(XgwhWithdrawDeposit xgwhWithdrawDeposit);
}