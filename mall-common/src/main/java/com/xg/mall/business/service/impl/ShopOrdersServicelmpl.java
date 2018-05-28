package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IShopOrdersService;
import com.xg.mall.dao.XgwhShopGoodsMapper;
import com.xg.mall.dao.XgwhShopOrderMapper;
import com.xg.mall.po.XgwhShopGoods;
import com.xg.mall.po.XgwhShopOrder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShopOrdersServicelmpl implements IShopOrdersService {
    Logger logger = Logger.getLogger(ShopOrdersServicelmpl.class);
    //注入订单mapper
    @Autowired
    private XgwhShopOrderMapper xgwhShopOrderMapper;
    @Autowired
    private XgwhShopGoodsMapper xgwhShopGoodsMapper;

    @Override
    public List<XgwhShopOrder> selectOrdersByMemberId(Integer memberId) {
        List<XgwhShopOrder> list = xgwhShopOrderMapper.selectOrdersByMemberId(memberId);
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        //拿到商品名称和商品图片
        for (XgwhShopOrder re : list) {
            XgwhShopGoods res = xgwhShopGoodsMapper.selectByPrimaryKey(re.getGoodsId());
            re.setGoodsName(res.getGoodsName());
            re.setGoodsCover(res.getGoodsCover());
        }
        logger.debug("查询订单列表日志");
        return list;
    }


}
