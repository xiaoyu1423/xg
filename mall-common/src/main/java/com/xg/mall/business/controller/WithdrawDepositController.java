package com.xg.mall.business.controller;

import com.xg.mall.business.service.IWithdrawDepositService;
import com.xg.mall.po.XgwhWithdrawDeposit;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
@RequestMapping("/manage")
public class WithdrawDepositController {

    private Logger logger = Logger.getLogger(WithdrawDepositController.class);
    @Autowired
    private IWithdrawDepositService iWithdrawDepositService;

//提现记录
    @RequestMapping(value = "/withdraw-deposit",method = RequestMethod.PUT)
    public ResponseBody pass(XgwhWithdrawDeposit xgwhWithdrawDeposit){
        logger.info("控制层提现记录通过");
       boolean res = iWithdrawDepositService.pass(xgwhWithdrawDeposit);
       return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
//按条件搜索
    @RequestMapping(value = "/withdraw-deposit-where",method = RequestMethod.GET)
    public ResponseBody selectWhere(XgwhWithdrawDeposit xgwhWithdrawDeposit) {
        logger.info("控制层提现记录查询");
        LinkedList list = iWithdrawDepositService.select(xgwhWithdrawDeposit);
        return ResponseUtil.responseBody(list, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
