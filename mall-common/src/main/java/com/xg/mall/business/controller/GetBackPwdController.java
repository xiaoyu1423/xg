package com.xg.mall.business.controller;

import com.xg.mall.business.service.IGetBackPwdService;
import com.xg.mall.po.XgwhMember;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GetBackPwdController {

    @Autowired
    private IGetBackPwdService iGetBackPwdService;

    @RequestMapping(value = "/get-back-pwd", method = RequestMethod.PUT)
    public ResponseBody selectPwdByMemberId(XgwhMember xgwhMember) {
        String res = iGetBackPwdService.selectPwdByMemberId(xgwhMember);
        return ResponseUtil.responseBody(res, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
