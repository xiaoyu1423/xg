package com.xg.mall.business.controller;

import com.xg.mall.business.service.IMemberWalletRecordService;
import com.xg.mall.po.XgwhRecord;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MemberWalletRecordController {
    Logger logger = Logger.getLogger(MemberWalletRecordController.class);
    @Autowired
    private IMemberWalletRecordService iMemberWalletRecordService;

    //查询钱包明细
    @RequestMapping(value = "/record/{memberId}/{recordType}", method = RequestMethod.GET)
    public ResponseBody selectByMemberIdWalletId(@PathVariable("memberId") Integer memberId, @PathVariable("recordType") Integer recordType) {
        logger.info("查询钱包明细日志");
        List<XgwhRecord> list = iMemberWalletRecordService.selectByMemberIdWalletId(memberId, recordType);
        return ResponseUtil.responseBody(list, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }


}
