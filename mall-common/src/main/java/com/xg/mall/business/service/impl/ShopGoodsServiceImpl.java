package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IShopGoodsService;
import com.xg.mall.dao.XgwhShopGoodsMapper;
import com.xg.mall.po.XgwhShopGoods;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShopGoodsServiceImpl implements IShopGoodsService {
    private Logger logger = Logger.getLogger(ShopGoodsServiceImpl.class);
    @Autowired
    private XgwhShopGoodsMapper xgwhShopGoodsMapper;

    @Override
    public List<XgwhShopGoods> selects(XgwhShopGoods xgwhShopGoods){

        String startTime = xgwhShopGoods.getStartTime();
        String strTime = xgwhShopGoods.getStrTime();
        if (startTime != "") {
            if (strTime != "") {
                Integer add_time = Time.UnixTime(startTime + " " + "0:0:0");
                Integer end_time = Time.UnixTime(strTime + " " + "23:59:59");
                xgwhShopGoods.setAddTime(add_time);
                xgwhShopGoods.setEndTime(end_time);
            }
        }

        List<XgwhShopGoods> res = xgwhShopGoodsMapper.selects(xgwhShopGoods);
        if(res.isEmpty()){
            return Collections.emptyList();
        }
        logger.debug("查询商品列表");
        return res;
    }

    @Override
    public XgwhShopGoods selectById(Integer id) {
        XgwhShopGoods xgwhShopGoods = xgwhShopGoodsMapper.selectByPrimaryKey(id);
        logger.debug("查询商品单个");
        return  xgwhShopGoods;
    }

    @Override
    public List<XgwhShopGoods> select(){
        List<XgwhShopGoods> list = xgwhShopGoodsMapper.select();
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        logger.debug("查询商品列表");
        return list;
    }

    @Override

    public boolean insert(XgwhShopGoods xgwhShopGoods){
        xgwhShopGoods.setAddTime(Time.UnixTime());
        int isCreat = xgwhShopGoodsMapper.insertSelective(xgwhShopGoods);
        logger.debug("添加商品");
        return isCreat > 0;
    }

    @Override

    public boolean update(XgwhShopGoods xgwhShopGoods){
        xgwhShopGoods.setUpdateTime(Time.UnixTime());
        int isUpdate = xgwhShopGoodsMapper.updateByPrimaryKeySelective(xgwhShopGoods);
        logger.debug("修改商品");
        return isUpdate > 0;
    }

    @Override

    public boolean delete(Integer goodsId){
        int isDel = xgwhShopGoodsMapper.deleteByPrimaryKey(goodsId);
        logger.debug("删除商品");
        return isDel > 0;
    }
}
