package com.xg.mall.dao;

import com.xg.mall.po.XgwhMemberWallet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XgwhMemberWalletMapper {
    List<XgwhMemberWallet> select();
    int deleteByPrimaryKey(Integer memberWalletId);

    int withdraw(XgwhMemberWallet record);  //提现到余额

    int withdraws(XgwhMemberWallet record); //余额转出

    int withdrawss(XgwhMemberWallet record); //分销或业绩补助提现到余额

    int addShopincome(XgwhMemberWallet record);

    int addGrain(XgwhMemberWallet record);

    int insert(XgwhMemberWallet record);

    int insertSelective(XgwhMemberWallet record);

    XgwhMemberWallet selectByPrimaryKey(Integer memberWalletId);

    List<XgwhMemberWallet> selectByMemberId(Integer memberId);

    XgwhMemberWallet selectMoneyByWalletId(@Param("memberId") Integer memberId, @Param("walletId") Integer walletId);

    XgwhMemberWallet selectShopincome(@Param("memberId") Integer memberId, @Param("walletId") Integer walletId);

    XgwhMemberWallet selectFyq(@Param("memberId") Integer memberId, @Param("walletId") Integer walletId);

    XgwhMemberWallet selectPrimaryKEY(@Param("memberId") Integer memberId, @Param("walletId") Integer walletId);

    XgwhMemberWallet selectQb(@Param("memberId") Integer memberId, @Param("walletId") Integer walletId);

    XgwhMemberWallet selectGrain(@Param("memberId") Integer memberId, @Param("walletId") Integer walletId);

    //根据memberId查询会员钱包中余额的memberWalletId
    XgwhMemberWallet selectShopincomeByMemberId(@Param("memberId") Integer memberId);

    //根据memberId和walletId查询memberWalletId
    XgwhMemberWallet selectMoneyByMemberId(@Param("memberId") Integer memberId, @Param("walletId") Integer walletId);

    int reduceFyq(XgwhMemberWallet record);

    int updateShopincome(XgwhMemberWallet record);

    int updateFyq(XgwhMemberWallet record);

    int updateByPrimaryKeySelective(XgwhMemberWallet record);

    int updateByPrimaryKey(XgwhMemberWallet record);
}