package com.xg.mall.order.jms;

import com.alibaba.fastjson.JSONObject;
import com.xg.mall.po.XgwhShopOrder;
import com.xg.mall.po.XgwhShopOrderDetail;
import com.xg.rabbitmq.Producer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeoutException;

public class SendTask {

    private static String exchangeName = "";

    private static String routingKey = "";

    public static void main(String[] args) throws IOException, TimeoutException {
        SendTask sendTask = new SendTask();
        sendTask.sendTask(getMessage());
    }

    private static String getMessage() {

        XgwhShopOrder xgwhShopOrder = new XgwhShopOrder();
        Byte aByte = 1;
        // xgwhShopOrder.setOrderId(7);
        xgwhShopOrder.setOrderSn("9999");
        xgwhShopOrder.setTotalPrice(new BigDecimal(9999));
        xgwhShopOrder.setMemberId(68);
        xgwhShopOrder.setPayType(aByte);
        xgwhShopOrder.setAddressId(9999);
        xgwhShopOrder.setContactName("9999");
        xgwhShopOrder.setMobile("9999");
        xgwhShopOrder.setAddress("9999");
        xgwhShopOrder.setOrderStatus(aByte);
        xgwhShopOrder.setAddTime(9999);
        xgwhShopOrder.setStrTime("9999");
        xgwhShopOrder.setEndTime(9999);
        xgwhShopOrder.setTotalMoney("9999");
        xgwhShopOrder.setCountMembers("9999");
        xgwhShopOrder.setCountOrders("9999");
        xgwhShopOrder.setTodayMoney("9999");
        xgwhShopOrder.setYesterdayMoney("9999");
        xgwhShopOrder.setTodayWithdraw("9999");
        xgwhShopOrder.setTodayAlipayBuy("9999");
        xgwhShopOrder.setGoodsName("9999");
        xgwhShopOrder.setGoodsId(4);
        xgwhShopOrder.setGoodsCover("9999");


        XgwhShopOrderDetail xgwhShopOrderDetail = new XgwhShopOrderDetail();
        xgwhShopOrderDetail.setAddTime(9999);
        xgwhShopOrderDetail.setGoodsId(4);
        xgwhShopOrderDetail.setGoodsName("9999");
        xgwhShopOrderDetail.setGoodsPrice(new BigDecimal(9999));
        xgwhShopOrderDetail.setMemberId(9999);
        xgwhShopOrderDetail.setOrderDetailId(9999);
        xgwhShopOrderDetail.setOrderId(9999);
        xgwhShopOrderDetail.setOrderSn("9999");
        xgwhShopOrderDetail.setUpdateTime(9999);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("XgwhShopOrderDetail", xgwhShopOrderDetail);
        jsonObject.put("XgwhShopOrder", xgwhShopOrder);
        return jsonObject.toJSONString();
    }

    public void sendTask(String message) throws IOException, TimeoutException {
        Producer.directMode("create_order", message, true);
    }
}