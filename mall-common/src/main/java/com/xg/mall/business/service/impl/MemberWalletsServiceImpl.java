package com.xg.mall.service.impl;

import com.xg.mall.dao.XgwhMemberWalletMapper;
import com.xg.mall.po.XgwhMemberWallet;
import com.xg.mall.service.IMemberWalletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MemberWalletsServiceImpl implements IMemberWalletsService {
    @Autowired
    private XgwhMemberWalletMapper xgwhMemberWalletMapper;

    @Override
    public List<XgwhMemberWallet> selectWalletsByMemberId(Integer memberId){
        List<XgwhMemberWallet>  res = xgwhMemberWalletMapper.selectByMemberId(memberId);

        if(res.isEmpty()){
            return Collections.emptyList();
        }
        return res;
    }

}
