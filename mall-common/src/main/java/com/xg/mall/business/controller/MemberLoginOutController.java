package com.xg.mall.business.controller;

import com.xg.mall.business.service.IMemberLogoutService;
import com.xg.utils.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ResponseUtil;

@RestController
@RequestMapping("/")
public class MemberLoginOutController {
    @Autowired
    private IMemberLogoutService iMemberLogoutService;

    @RequestMapping(value = "login-out",method = RequestMethod.POST)
    public ResponseBody logOut(Integer memberId){
        boolean isLogOut = iMemberLogoutService.logOut(memberId);
        return ResponseUtil.responseBody(isLogOut,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
