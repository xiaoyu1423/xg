package com.xg.mall.business.controller;

import com.xg.mall.business.service.IHomeService;
import com.xg.mall.po.XgwhHome;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018/5/24
 * 前端首页内容
 */
@RestController
@RequestMapping("/")
public class HomeController {

    private Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private IHomeService iHomeService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ResponseBody select() {
        logger.info("控制层前台首页");
        List<XgwhHome> xgwhHome = iHomeService.select();
        return ResponseUtil.responseBody(xgwhHome, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }

}
