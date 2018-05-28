package com.xg.mall.business.controller;

import com.xg.mall.business.service.IWithdrawService;
import com.xg.mall.po.XgwhMemberWallet;
import com.xg.mall.vo.ResponseBody;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class WithdrawController {
    private Logger logger = Logger.getLogger(WithdrawController.class);
    @Autowired
    private IWithdrawService iWithdrawService;

    @RequestMapping(value = "/withdraw",method = RequestMethod.PUT)
    public ResponseBody withdraws(XgwhMemberWallet xgwhMemberWallet){
        logger.info("余额提现");
        ResponseBody isWithdraw = iWithdrawService.withdraws(xgwhMemberWallet);
        return isWithdraw;
    }
}
