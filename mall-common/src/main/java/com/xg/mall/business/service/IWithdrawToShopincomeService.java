package com.xg.mall.business.service;

import com.xg.mall.po.XgwhMemberWallet;
import com.xg.mall.vo.ResponseBody;

public interface IWithdrawToShopincomeService {
    //其他提现到余额
    ResponseBody withdraw(XgwhMemberWallet xgwhMemberWallet);
}
