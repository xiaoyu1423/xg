package com.xg.mall.business.controller;

import com.xg.mall.business.service.IBackstageService;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018/5/24
 * 后台首页数据
 */
@RestController
@RequestMapping("/manage")
public class BackstageController {

    private Logger logger = Logger.getLogger(BackstageController.class);

    @Autowired
    private IBackstageService iBackstageService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ResponseBody count() {
        logger.info("控制器层后台首页数据");
        LinkedList list = iBackstageService.count();
        return ResponseUtil.responseBody(list, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
