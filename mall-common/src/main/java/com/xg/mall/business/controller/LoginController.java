package com.xg.mall.business.controller;

import com.xg.mall.business.service.ILoginService;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
@RestController
@RequestMapping("/manage")
public class LoginController {

     @Autowired
     private ILoginService iLoginService;

     @RequestMapping(value = "/login",method = RequestMethod.POST)
     public ResponseBody Login(String userName,String userPassword,String mobile){

         String res  =  iLoginService.select(userName,userPassword,mobile);
         return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
     }
}
