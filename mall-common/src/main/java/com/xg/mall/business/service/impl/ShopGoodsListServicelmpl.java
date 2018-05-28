package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IShopGoodsListService;
import com.xg.mall.dao.XgwhShopGoodsMapper;
import com.xg.mall.po.XgwhShopGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShopGoodsListServicelmpl implements IShopGoodsListService {

    //注入商品mapper
    @Autowired
    private XgwhShopGoodsMapper xgwhShopGoodsMapper;

    @Override
    public List<XgwhShopGoods> select(){
        List<XgwhShopGoods> list =xgwhShopGoodsMapper.select();
        if (list.isEmpty()){
            return Collections.emptyList();
        }
        return list;
    }

    @Override
    public  XgwhShopGoods selectById(Integer goodsId){
        XgwhShopGoods res = xgwhShopGoodsMapper.selectByPrimaryKey(goodsId);
        return res;
    }
}


