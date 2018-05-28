package com.xg.mall.business.service;

import com.xg.mall.po.XgwhRecord;

import java.util.List;

public interface IMemberWalletRecordService {

    List<XgwhRecord> selectByMemberId(Integer memberId);

    List<XgwhRecord> selectByMemberIdWalletId(Integer memberId, Integer walletId);
}
