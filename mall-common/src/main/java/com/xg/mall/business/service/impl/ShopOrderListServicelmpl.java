package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IShopOrderListService;
import com.xg.mall.dao.XgwhShopOrderMapper;
import com.xg.mall.po.XgwhShopOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShopOrderListServicelmpl implements IShopOrderListService {
    //注入订单mapper
    @Autowired
    private XgwhShopOrderMapper xgwhShopOrderMapper;

    @Override
    public List<XgwhShopOrder> select(){
        List<XgwhShopOrder> list = xgwhShopOrderMapper.selectALL();
        if (list.isEmpty()){
            return Collections.emptyList();
        }
        return list;
    }


}
