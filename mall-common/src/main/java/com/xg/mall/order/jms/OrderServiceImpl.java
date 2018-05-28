package com.xg.mall.order.jms;

import com.alibaba.fastjson.JSONObject;
import com.xg.mall.dao.XgwhShopOrderDetailMapper;
import com.xg.mall.dao.XgwhShopOrderMapper;
import com.xg.mall.po.XgwhShopOrder;
import com.xg.mall.po.XgwhShopOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl {

    @Autowired
    private XgwhShopOrderMapper xgwhShopOrderMapper;

    @Autowired
    private XgwhShopOrderDetailMapper xgwhShopOrderDetailMapper;

    @Transactional(rollbackFor = Exception.class)
    public void createOrder(String message) throws Exception {
        // TODO 处理创建订单业务, XgwhShopOrderDetail(快照)和XgwhShopOrder(订单)
        JSONObject jsonObject = JSONObject.parseObject(message);
        XgwhShopOrderDetail xgwhShopOrderDetail = jsonObject.getObject("XgwhShopOrderDetail", XgwhShopOrderDetail.class);
        XgwhShopOrder xgwhShopOrder = jsonObject.getObject("XgwhShopOrder", XgwhShopOrder.class);
        // TODO 数据校验
        // TODO 保存订单，保存快照
        boolean ack = xgwhShopOrderMapper.insertSelective(xgwhShopOrder) > 0;
        if (!ack) {
            throw new Exception("订单创建执行失败.任务消息未应答.");
        }
        ack = xgwhShopOrderDetailMapper.insertSelective(xgwhShopOrderDetail) > 0;
        if (!ack) {
            throw new Exception("订单快照创建执行失败.任务消息未应答.");
        }
    }
}
