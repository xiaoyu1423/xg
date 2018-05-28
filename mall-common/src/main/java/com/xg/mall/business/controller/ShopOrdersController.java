package com.xg.mall.business.controller;

import com.xg.mall.business.service.IShopOrdersService;
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

import java.util.List;

@RestController
@RequestMapping("/")
public class ShopOrdersController {
    Logger logger = Logger.getLogger(ShopOrdersController.class);
    @Autowired
    private IShopOrdersService iShopOrdersService;
    //查询订单
    @RequestMapping(value = "/shop-orders/{memberId}", method = RequestMethod.GET)
    public ResponseBody selectOrdersByMemberId(@PathVariable("memberId") Integer memberId) {
        logger.info("查询订单列表日志");
        List<XgwhShopOrder> list = iShopOrdersService.selectOrdersByMemberId(memberId);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
