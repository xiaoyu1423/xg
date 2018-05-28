package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IShopCateService;
import com.xg.mall.dao.XgwhShopCategreyMapper;
import com.xg.mall.po.XgwhShopCategrey;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCateServiceImpl  implements IShopCateService {
    private Logger logger = Logger.getLogger(ShopCateServiceImpl.class);
    @Autowired
    private XgwhShopCategreyMapper xgwhShopCategreyMapper;

    //查询商品分类列表
    public List<XgwhShopCategrey> select(XgwhShopCategrey xgwhShopCategrey) {
        List<XgwhShopCategrey> list = xgwhShopCategreyMapper.select(xgwhShopCategrey);
        logger.debug("查询商品分类列表");
        return list;
    }

    //添加商品分类
    @Override
    public boolean insertSelective(XgwhShopCategrey xgwhShopCategrey) {
        xgwhShopCategrey.setAddTime(Time.UnixTime());
        int isCreat = xgwhShopCategreyMapper.insertSelective(xgwhShopCategrey);
        logger.debug("添加商品分类");
        return isCreat > 0;
    }

    //删除商品分类
    @Override
    public boolean delete(Integer cateId) {
        int isDel = xgwhShopCategreyMapper.deleteByPrimaryKey(cateId);
        logger.debug("删除商品分类");
        return isDel > 0;
    }

    //修改商品分类
    @Override
    public boolean update(XgwhShopCategrey xgwhShopCategrey) {
        xgwhShopCategrey.setUpdateTime(Time.UnixTime());
        int isUpdate = xgwhShopCategreyMapper.updateByPrimaryKeySelective(xgwhShopCategrey);
        logger.debug("修改商品分类");
        return isUpdate > 0;
    }

    //根据ID查询商品分类
    @Override
    public XgwhShopCategrey selectById(Integer cateId){
        XgwhShopCategrey res = xgwhShopCategreyMapper.selectById(cateId);
        logger.debug("根据ID查询商品分类");
        return res;
    }
}
