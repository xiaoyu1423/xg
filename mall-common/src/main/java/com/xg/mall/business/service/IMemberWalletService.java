package com.xg.mall.business.service;

import com.xg.mall.po.XgwhMemberWallet;

import java.util.List;

public interface IMemberWalletService {
    List<XgwhMemberWallet> select();

    boolean add(XgwhMemberWallet xgwhMemberWallet);

    boolean delete(Integer memberWalletId);

    boolean update(XgwhMemberWallet xgwhMemberWallet);

}
