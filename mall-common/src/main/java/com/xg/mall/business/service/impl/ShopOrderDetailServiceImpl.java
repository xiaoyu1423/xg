package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IShopOrderDetailService;
import com.xg.mall.dao.XgwhShopOrderDetailMapper;
import com.xg.mall.po.XgwhShopOrderDetail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopOrderDetailServiceImpl implements IShopOrderDetailService {
    private Logger logger = Logger.getLogger(ShopOrderDetailServiceImpl.class);
    @Autowired
    private XgwhShopOrderDetailMapper xgwhShopOrderDetailMapper;

    //根据ID查询订单详情
    @Override
    public XgwhShopOrderDetail selectById(Integer orderDetailId){
        XgwhShopOrderDetail isSelect = xgwhShopOrderDetailMapper.selectByPrimaryKey(orderDetailId);
        logger.debug("根据ID查询订单详情");
        return isSelect;
    }
}
