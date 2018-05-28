package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhMemberSecrecy;
import com.xg.mall.business.service.IMemberSecrecyBackService;
import com.xg.utils.ExceptionCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ResponseUtil;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class MemberSecrecyBackController {
    private Logger logger = Logger.getLogger(MemberSecrecyBackController.class);
    @Autowired
    private IMemberSecrecyBackService iMemberSecrecyBackService;

    @RequestMapping(value = "/member-secrecy-back",method = RequestMethod.GET)
    public ResponseBody selectSecrecy(XgwhMemberSecrecy xgwhMemberSecrecy){
        logger.info("查询会员保密资料");
        List<XgwhMemberSecrecy> list = iMemberSecrecyBackService.selectSecrecy(xgwhMemberSecrecy);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/member-secrecy-back/{id}",method = RequestMethod.GET)
    public ResponseBody selectById(@PathVariable("id") Integer id){
        logger.info("根据ID查询会员保密资料");
        XgwhMemberSecrecy res = iMemberSecrecyBackService.selectById(id);
        return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());

    }

    @RequestMapping(value = "/member-secrecy-back",method = RequestMethod.PUT)
    public ResponseBody updateSecrecy(XgwhMemberSecrecy xgwhMemberSecrecy){
        logger.info("修改会员保密资料");
        boolean isUpdate = iMemberSecrecyBackService.udpateSecrecy(xgwhMemberSecrecy);
        return  ResponseUtil.responseBody(isUpdate,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/member-secrecy-back",method = RequestMethod.POST)
    public ResponseBody addSecrecy(XgwhMemberSecrecy xgwhMemberSecrecy){
        logger.info("添加会员保密资料");
        boolean isAdd = iMemberSecrecyBackService.addSecrecy(xgwhMemberSecrecy);
        return ResponseUtil.responseBody(isAdd,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
