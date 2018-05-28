package com.xg.mall.business.controller;

import com.xg.mall.business.service.IWithdrawToShopincomeService;
import com.xg.mall.po.XgwhMemberWallet;
import com.xg.mall.vo.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WithdrawToShopincomeController {
    @Autowired
    private IWithdrawToShopincomeService iWithdrawToShopincomeService;
    //其他提现到余额
    @RequestMapping(value = "/withdraw-to-shopincome",method = RequestMethod.PUT)
    public ResponseBody withdrawToShopincome(XgwhMemberWallet xgwhMemberWallet){
        ResponseBody isWithdraw = iWithdrawToShopincomeService.withdraw(xgwhMemberWallet);
        return isWithdraw;
    }
}
