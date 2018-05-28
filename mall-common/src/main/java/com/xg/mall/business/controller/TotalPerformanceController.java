package com.xg.mall.business.controller;

import com.xg.mall.business.service.IMemberClosureService;
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

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-15
 * 团队总业绩
 */
@RestController
@RequestMapping("/")
public class TotalPerformanceController {

       private Logger logger = Logger.getLogger(TotalPerformanceController.class);
       @Autowired
       private IMemberClosureService iMemberClosureServicel;

       //查询我的总业绩
       @RequestMapping(value = "mine-total/{id}", method = RequestMethod.GET)
       public ResponseBody selectMyTotalPerformance(@PathVariable("id") Integer id){
           logger.info("控制器层我的总业绩");
           double total  = iMemberClosureServicel.selectTotal(id);
           return ResponseUtil.responseBody(total,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
       }

       //查询我的团队
       @RequestMapping(value = "mine-team/{id}/{distance}/{page}", method = RequestMethod.GET)
       public ResponseBody selectMyClosure(@PathVariable("id") Integer id, @PathVariable("distance") Integer distance, @PathVariable("page") Integer page) {
           logger.info("控制器层我的团队");
           LinkedList list = iMemberClosureServicel.selectDescendant(id, distance, page);
           return  ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
       }
}
