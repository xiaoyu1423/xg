package com.xg.mall.business.controller;

import com.xg.mall.business.service.IMemberSecrecyService;
import com.xg.mall.po.XgwhMember;
import com.xg.mall.po.XgwhMemberSecrecy;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
@RestController
@RequestMapping("/")
public class MemberSecrecyController {

    private Logger logger = Logger.getLogger(MemberSecrecyController.class);
    @Autowired
    private IMemberSecrecyService iMemberSecrecyService;

    //查询用户资料
    @RequestMapping(value = "/secrecy/{memberId}",method = RequestMethod.GET)
    public ResponseBody select(@PathVariable("memberId") Integer memberId){
        logger.info("前端控制器层资料查询");
        XgwhMemberSecrecy xgwhMemberSecrecy = iMemberSecrecyService.select(memberId);
        return ResponseUtil.responseBody(xgwhMemberSecrecy,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //添加用户资料
    @RequestMapping(value = "/secrecy",method = RequestMethod.POST)
    public ResponseBody add(XgwhMemberSecrecy xgwhMemberSecrecy){
        logger.info("前端控制器层添加资料");
        boolean res = iMemberSecrecyService.add(xgwhMemberSecrecy);
        return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //用户资料编辑
    @RequestMapping(value = "/secrecy",method = RequestMethod.PUT)
    public ResponseBody update(XgwhMember xgwhMember) {
        logger.info("前端控制器层编辑资料");
        ResponseBody res = iMemberSecrecyService.update(xgwhMember);
        return res;
    }
}
