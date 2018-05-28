package com.xg.mall.business.controller;

import com.xg.mall.business.service.IMemberAddressService;
import com.xg.mall.po.XgwhMemberAddress;
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

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
@RestController
@RequestMapping("/")
public class MemberAddressController {

    private Logger logger = Logger.getLogger(MemberAddressController.class);
    @Autowired
    private IMemberAddressService iMemberAddressService;

    //更新地址
    @RequestMapping(value = "/address-edit", method = RequestMethod.PUT)
    public ResponseBody update(XgwhMemberAddress xgwhMemberAddress){
        logger.info("前端控制器层编辑地址");
        boolean res = iMemberAddressService.update(xgwhMemberAddress);
        return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //添加地址
    @RequestMapping(value = "/address-add", method = RequestMethod.POST)
    public ResponseBody add(XgwhMemberAddress xgwhMemberAddress){
        logger.info("前端控制器层添加地址");
        boolean res = iMemberAddressService.add(xgwhMemberAddress);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());

    }

    //查询所有地址
    @RequestMapping(value = "/address-member", method = RequestMethod.GET)
    public ResponseBody select(XgwhMemberAddress xgwhMemberAddress) {
        logger.info("前端控制器层查询所有地址");
        List<XgwhMemberAddress> list = iMemberAddressService.select(xgwhMemberAddress);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

   //用户id查询地址
   @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public  ResponseBody selectById(@PathVariable("id") Integer Id){
        logger.info("前端控制器层查询单个地址");
        XgwhMemberAddress xgwhMemberAddress = iMemberAddressService.selectById(Id);
        return ResponseUtil.responseBody(xgwhMemberAddress,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //删除地址
    @RequestMapping(value = "/address-delete/{id}", method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable("id") Integer Id){
        logger.info("前端控制器层删除地址");
        boolean res = iMemberAddressService.delete(Id);
        return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //设置默认地址
    @RequestMapping(value = "/address-default", method = RequestMethod.PUT)
    public ResponseBody updateDefault(Integer id){
        logger.info("前端控制器层更新默认地址");
        boolean res = iMemberAddressService.updateDefault(id);
        return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
