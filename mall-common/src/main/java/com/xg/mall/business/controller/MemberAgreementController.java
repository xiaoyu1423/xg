package com.xg.mall.business.controller;

import com.xg.mall.business.service.IMemberAgreementService;
import com.xg.mall.po.XgwhAgree;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MemberAgreementController {
    Logger logger = Logger.getLogger(MemberAgreementController.class);
    @Autowired
    private IMemberAgreementService iMemberAgreementService;

    //查询用户协议
    @RequestMapping(value = "/member-agreement", method = RequestMethod.GET)
    public ResponseBody selectMemberAgreement() {
        logger.info("查看用户协议日志");
        XgwhAgree res = iMemberAgreementService.selectMemberAgreement();
        return ResponseUtil.responseBody(res, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
