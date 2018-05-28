package com.xg.mall.service;

import com.xg.mall.po.XgwhMemberWallet;

import java.util.List;

public interface IMemberWalletsService {
    List<XgwhMemberWallet> selectWalletsByMemberId(Integer memberId);
}
