package com.xg.mall.business.service;

import com.xg.mall.po.XgwhMemberWallet;
import com.xg.mall.vo.ResponseBody;

public interface IWithdrawService {
    ResponseBody withdraws(XgwhMemberWallet xgwhMemberWallet);
}
