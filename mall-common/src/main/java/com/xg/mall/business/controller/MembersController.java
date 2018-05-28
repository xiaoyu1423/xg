package com.xg.mall.business.controller;

import com.xg.mall.business.service.IMembersService;
import com.xg.mall.po.XgwhMember;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MembersController {
    Logger logger = Logger.getLogger(MembersController.class);
    @Autowired
    private IMembersService iMembersService;

    //前端展示会员基础资料
    @RequestMapping(value = "/member/{memberId}", method = RequestMethod.GET)
    public ResponseBody selectByMemberId(@PathVariable("memberId") Integer memberId) {
        logger.info("前端展示会员基础资料");
        XgwhMember res = iMembersService.selectByMemberId(memberId);
        return ResponseUtil.responseBody(res, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }

}
