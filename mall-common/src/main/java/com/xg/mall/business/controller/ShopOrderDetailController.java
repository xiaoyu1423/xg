package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhShopOrderDetail;
import com.xg.mall.business.service.IShopOrderDetailService;
import com.xg.utils.ExceptionCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xg.utils.ResponseUtil;
import com.xg.mall.vo.ResponseBody;

@RestController
@RequestMapping("/")
public class ShopOrderDetailController {
    private Logger logger = Logger.getLogger(ShopOrderDetailController.class);
    @Autowired
    private IShopOrderDetailService iShopOrderDetailService;

    @RequestMapping(value = "shop-order-detail/{orderDetailId}",method = RequestMethod.GET)
    public ResponseBody selectById(@PathVariable("orderDetailId") Integer orderDetailId){
        logger.info("查询订单详情");
        XgwhShopOrderDetail detail = iShopOrderDetailService.selectById(orderDetailId);
        return ResponseUtil.responseBody(detail,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
