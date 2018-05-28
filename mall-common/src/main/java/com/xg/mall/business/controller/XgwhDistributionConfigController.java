package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhDistributionConfig;
import com.xg.mall.business.service.IXgwhDistributionConfigService;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-14
 */
@RestController
@RequestMapping("/manage")
public class XgwhDistributionConfigController {

    private Logger logger = Logger.getLogger(XgwhDistributionConfigController.class);
    @Autowired
    private IXgwhDistributionConfigService iXgwhDistributionConfigService;

    @RequestMapping(value = "/distribution-config/{type}",method = RequestMethod.GET)
    public ResponseBody select(@PathVariable("type") Integer type){
        logger.info("后台业绩补助和分销查询控制器");
        XgwhDistributionConfig xgwhDistributionConfig = iXgwhDistributionConfigService.select(type);
        return ResponseUtil.responseBody(xgwhDistributionConfig,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());

    }

    @RequestMapping(value = "/distribution-config",method = RequestMethod.PUT)
    public ResponseBody update(XgwhDistributionConfig xgwhDistributionConfig){
        logger.info("后台业绩补助和分销编辑控制器");
       boolean res = iXgwhDistributionConfigService.update(xgwhDistributionConfig);
       return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/distribution-config",method = RequestMethod.POST)
    public  ResponseBody add(XgwhDistributionConfig xgwhDistributionConfig){
        logger.info("后台业绩补助和分销添加控制器");
      boolean res = iXgwhDistributionConfigService.add(xgwhDistributionConfig);
      return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
