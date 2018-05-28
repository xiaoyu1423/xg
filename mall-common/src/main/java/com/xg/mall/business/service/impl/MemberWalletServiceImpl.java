package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IMemberWalletService;
import com.xg.mall.dao.XgwhMemberWalletMapper;
import com.xg.mall.po.XgwhMemberWallet;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MemberWalletServiceImpl implements IMemberWalletService {
    private Logger logger = Logger.getLogger(MemberWalletServiceImpl.class);
    @Autowired
    private XgwhMemberWalletMapper xgwhMemberWalletMapper;

    @Override
    public List<XgwhMemberWallet> select(){
        List<XgwhMemberWallet> list = xgwhMemberWalletMapper.select();
        if (list.isEmpty()){
            return Collections.emptyList();
        }
        logger.debug("查询会员钱包");
        return list;
    }

    @Override
    public boolean add(XgwhMemberWallet xgwhMemberWallet){
        xgwhMemberWallet.setAddTime(Time.UnixTime());
        int isAdd = xgwhMemberWalletMapper.insertSelective(xgwhMemberWallet);
        logger.debug("添加会员钱包");
        return isAdd > 0;
    }

    @Override
    public boolean delete(Integer memberWalletId){
        int isDel = xgwhMemberWalletMapper.deleteByPrimaryKey(memberWalletId);
        logger.debug("删除会员钱包");
        return  isDel > 0;
    }

    public boolean update(XgwhMemberWallet xgwhMemberWallet){
        xgwhMemberWallet.setUpdateTime(Time.UnixTime());
        int isUpdate = xgwhMemberWalletMapper.updateByPrimaryKeySelective(xgwhMemberWallet);
        logger.debug("修改会员钱包");
        return isUpdate > 0;
    }

}
