package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IWalletService;
import com.xg.mall.dao.XgwhWalletMapper;
import com.xg.mall.po.XgwhWallet;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WalletServiceImpl implements IWalletService {
    private Logger logger = Logger.getLogger(WalletServiceImpl.class);
    @Autowired
    private XgwhWalletMapper xgwhWalletMapper;

    @Override
    public List<XgwhWallet>  select(){
        List<XgwhWallet> list = xgwhWalletMapper.select();
        logger.debug("实现层查询钱包");
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        return list;
    }

    @Override
    public XgwhWallet selectByPrimaryKey(Integer walletId){
        XgwhWallet xgwhWallet = xgwhWalletMapper.selectByPrimaryKey(walletId);
        logger.debug("实现层查询单个钱包");
        return xgwhWallet;
    }
    @Override
    public boolean add(XgwhWallet xgwhWallet){
        xgwhWallet.setAddTime(Time.UnixTime());
        int isAdd = xgwhWalletMapper.insertSelective(xgwhWallet);
        logger.debug("实现层添加钱包");
        return isAdd > 0;
    }

    @Override
    public boolean delete(Integer walletId){
        int isDel = xgwhWalletMapper.deleteByPrimaryKey(walletId);
        logger.debug("实现层删除钱包");
        return isDel > 0;
    }

    @Override
    public boolean update(XgwhWallet xgwhWallet){
        int isUpdate = xgwhWalletMapper.updateByPrimaryKeySelective(xgwhWallet);
        logger.debug("实现层更新钱包");
        return  isUpdate > 0;
    }
}
