package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IBackstageService;
import com.xg.mall.dao.XgwhMemberMapper;
import com.xg.mall.dao.XgwhShopGoodsMapper;
import com.xg.mall.dao.XgwhUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018/5/24
 * 后台首页数据 实现层
 */
@Service
public class BackstageServiceImpl implements IBackstageService {

    @Autowired
    XgwhShopGoodsMapper xgwhShopGoodsMapper;
    @Autowired
    XgwhMemberMapper xgwhMemberMapper;
    @Autowired
    XgwhUserMapper xgwhUserMapper;

    @Override
    public LinkedList count() {
        LinkedList list = new LinkedList<>();
        return list;
    }
}
