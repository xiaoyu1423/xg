package com.xg.mall.business.service;

import com.xg.mall.po.XgwhWallet;

import java.util.List;

public interface IWalletService {
    List<XgwhWallet> select();

    boolean add(XgwhWallet xgwhWallet);

    boolean delete(Integer walletId);

    boolean update(XgwhWallet xgwhWallet);

    XgwhWallet selectByPrimaryKey(Integer walletId);
}
