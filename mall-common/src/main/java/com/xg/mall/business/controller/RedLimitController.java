package com.xg.mall.business.controller;

import com.xg.mall.business.service.IRedLimitService;
import com.xg.mall.po.XgwhRedLimit;
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
@RequestMapping("/manage")
public class RedLimitController {
    private Logger logger = Logger.getLogger(RedLimitController.class);
    @Autowired
    private IRedLimitService iRedLimitService;

    //业绩补助设置列表
    @RequestMapping(value = "/red-limit", method = RequestMethod.GET)
    public ResponseBody selectAll(){
        logger.info("查询业绩补助设置列表");
        List<XgwhRedLimit> list = iRedLimitService.selectAll();
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //根据ID查询业绩补助设置
    @RequestMapping(value = "/red-limit/{id}", method = RequestMethod.GET)
    public ResponseBody selectById(@PathVariable("id") Integer id){
        logger.info("根据ID查询业绩补助设置");
        XgwhRedLimit res = iRedLimitService.selectById(id);
        return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //业绩补助设置删除
    @RequestMapping(value = "/red-limit/{id}", method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable("id") Integer id)
    {
        logger.info("根据ID删除业绩补助设置列表");
        boolean isUp = iRedLimitService.delete(id);
        return ResponseUtil.responseBody(isUp,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //业绩补助设置添加
    @RequestMapping(value = "/red-limit", method = RequestMethod.POST)
    public ResponseBody add(XgwhRedLimit xgwhRedLimit){
        logger.info("添加业绩补助设置");
        boolean isAdd = iRedLimitService.add(xgwhRedLimit);
        return ResponseUtil.responseBody(isAdd,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //业绩补助设置修改
    @RequestMapping(value = "/red-limit", method = RequestMethod.PUT)
    public ResponseBody update(XgwhRedLimit xgwhRedLimit){
        logger.info("修改业绩补助设置");
        boolean isUpdate = iRedLimitService.update(xgwhRedLimit);
        return  ResponseUtil.responseBody(isUpdate,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

}
