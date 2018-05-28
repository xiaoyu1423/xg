package com.xg.mall.business.controller;

import com.xg.mall.business.service.IShopOrderService;
import com.xg.mall.po.XgwhShopOrder;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 project: com.xg.mall
 auto : zhaorui
 time : 2018-5-5
 Controller ShopOrder
 */
@RestController
@RequestMapping("/manage")
public class ShopOrderController {

    private Logger logger = Logger.getLogger(ShopOrderController.class);

    @Autowired
    private IShopOrderService iShopOrderService;

    //订单查询
    @RequestMapping(value = "/shop-orders",method = RequestMethod.GET)
    public ResponseBody select(XgwhShopOrder xgwhShopOrder){
        logger.info("测试控制层订单查询日志");
        LinkedList list = iShopOrderService.select(xgwhShopOrder);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());

    }

    //手动支付
    @RequestMapping(value = "/shop-order",method = RequestMethod.PUT)
    public ResponseBody update(XgwhShopOrder xgwhShopOrder){
         System.out.println(xgwhShopOrder);
         logger.info("测试控制层订单手动支付日志");
         boolean res = iShopOrderService.update(xgwhShopOrder);
         return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //订单删除
    @RequestMapping(value = "shop-order/{orderId}",method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable("orderId") Integer orderId){
        logger.info("测试控制层订单删除日志");
        boolean res = iShopOrderService.delete(orderId);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //订单详情
    @RequestMapping(value = "shop-order/{orderId}",method = RequestMethod.GET)
    public ResponseBody get(@PathVariable("orderId") Integer orderId){
        logger.info("测试控制层订单详情日志");
        XgwhShopOrder xgwhShopOrder = iShopOrderService.get(orderId);
        return  ResponseUtil.responseBody(xgwhShopOrder,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //统计分析
    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public ResponseBody select_statistics(){
        List<XgwhShopOrder> list = iShopOrderService.select_statistics();
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
