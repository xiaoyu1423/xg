package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IFyqService;
import com.xg.mall.dao.XgwhMemberWalletMapper;
import com.xg.mall.po.XgwhMemberWallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FyqServiceImpl implements IFyqService {
    @Autowired
    private XgwhMemberWalletMapper xgwhMemberWalletMapper;

    @Override
    public XgwhMemberWallet Fyq(Integer memberId,Integer walletId){
           XgwhMemberWallet res = xgwhMemberWalletMapper.selectQb(memberId,walletId);
           return res;
    }
}
