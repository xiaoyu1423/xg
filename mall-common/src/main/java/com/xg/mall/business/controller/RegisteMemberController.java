package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhMember;
import com.xg.mall.business.service.IMemberService;
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
 * time : 2018-5-15
 * 用户首次登陆注册
 */
@RestController
@RequestMapping("/")
public class RegisteMemberController {

          @Autowired
          private IMemberService iMemberService;

          @RequestMapping(value="/registe-add",method = RequestMethod.POST)
          public ResponseBody add(XgwhMember xgwhMember){
              boolean res = iMemberService.add(xgwhMember);
              return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
          }
}
