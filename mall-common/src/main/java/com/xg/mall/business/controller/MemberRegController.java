package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhMember;
import com.xg.mall.business.service.IMemberRegService;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MemberRegController {
    @Autowired
    private IMemberRegService iMemberRegService;

    //会员注册
    @RequestMapping(value = "/member-reg",method = RequestMethod.POST)
    public ResponseBody memberReg(XgwhMember xgwhMember){
        boolean isReg = iMemberRegService.memberReg(xgwhMember);
        return ResponseUtil.responseBody(isReg,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
