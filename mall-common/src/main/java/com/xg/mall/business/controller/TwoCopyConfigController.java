package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhTwoCopyConfig;
import com.xg.mall.business.service.ITwoCopyConfigService;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xg.mall.vo.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class TwoCopyConfigController {
    @Autowired
    private ITwoCopyConfigService iTwoCopyConfigService;

    @RequestMapping(value = "/two-copy-config",method = RequestMethod.GET)
    public ResponseBody select(){
        List<XgwhTwoCopyConfig> list = iTwoCopyConfigService.selectAll();
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/two-copy-config",method = RequestMethod.POST)
    public ResponseBody add(XgwhTwoCopyConfig xgwhTwoCopyConfig){
        boolean isAdd = iTwoCopyConfigService.add(xgwhTwoCopyConfig);
        return ResponseUtil.responseBody(isAdd,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/two-copy-config",method = RequestMethod.PUT)
    public ResponseBody update(XgwhTwoCopyConfig xgwhTwoCopyConfig){
        boolean isUpdate = iTwoCopyConfigService.update(xgwhTwoCopyConfig);
        return ResponseUtil.responseBody(isUpdate,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

}
