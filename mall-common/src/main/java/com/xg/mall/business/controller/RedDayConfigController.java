package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhRedDayConfig;
import com.xg.mall.business.service.IRedDayConfigService;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xg.mall.vo.ResponseBody;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class RedDayConfigController {
    private Logger logger = Logger.getLogger(RedDayConfigController.class);
    @Autowired
    private IRedDayConfigService iRedDayConfigService;

    //日分红比例列表查询
    @RequestMapping(value = "/red-day-config",method = RequestMethod.GET)
    public ResponseBody selectAll(){
        logger.info("日分红比例查询列表");
        List<XgwhRedDayConfig> list = iRedDayConfigService.selectAll();
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //根据ID查询日分红比例
    @RequestMapping(value = "/red-day-config/{id}",method = RequestMethod.GET)
    public ResponseBody selectByPrimaryKey(@PathVariable("id") Integer id){
        logger.info("根据ID查询日分红比例");
        XgwhRedDayConfig xgwhRedDayConfig = iRedDayConfigService.selectByPrimaryKey(id);
        return ResponseUtil.responseBody(xgwhRedDayConfig,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //日分红比例设置添加
    @RequestMapping(value = "/red-day-config",method = RequestMethod.POST)
    public ResponseBody add(XgwhRedDayConfig xgwhRedDayConfig){
        logger.info("添加日分红比例");
        boolean isAdd = iRedDayConfigService.add(xgwhRedDayConfig);
        return ResponseUtil.responseBody(isAdd,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //日分红比例修改
    @RequestMapping(value = "red-day-config",method = RequestMethod.PUT)
    public ResponseBody update(XgwhRedDayConfig xgwhRedDayConfig){
        logger.info("日分红比例修改");
        boolean isUpdate = iRedDayConfigService.update(xgwhRedDayConfig);
        return ResponseUtil.responseBody(isUpdate,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
