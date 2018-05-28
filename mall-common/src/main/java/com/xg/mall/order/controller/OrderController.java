/**
 * project: com.xg.mall
 * autho : fred
 * time: 2018-05-05
 */
package com.xg.mall.order.controller;

import com.xg.mall.po.XgwhShopOrder;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseBody createOrder(XgwhShopOrder xgwhShopOrder)
    {
        return ResponseUtil.responseBody(null,ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
