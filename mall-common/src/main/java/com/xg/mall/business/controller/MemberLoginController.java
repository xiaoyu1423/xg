package com.xg.mall.business.controller;

import com.xg.mall.business.service.IMemberLoginService;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xg.mall.vo.ResponseBody;

@RestController
@RequestMapping("/")
public class MemberLoginController {
    @Autowired
    private IMemberLoginService iMemberLoginService;

    //会员登录
    @RequestMapping(value = "member-login",method = RequestMethod.POST)
    public ResponseBody selectByMemberUsername(String memberUsername,String memberPassword){
        String res = iMemberLoginService.selectByMemberName(memberUsername,memberPassword);
        return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
