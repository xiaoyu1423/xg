package com.xg.mall.dao;

import com.xg.mall.po.XgwhWallet;

import java.util.List;

public interface XgwhWalletMapper {
    int deleteByPrimaryKey(Integer walletId);

    int insert(XgwhWallet record);

    int insertSelective(XgwhWallet record);

    XgwhWallet selectByPrimaryKey(Integer walletId);

    int updateByPrimaryKeySelective(XgwhWallet record);

    int updateByPrimaryKey(XgwhWallet record);

    List<XgwhWallet> select();
}