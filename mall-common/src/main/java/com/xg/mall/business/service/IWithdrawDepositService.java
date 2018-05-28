package com.xg.mall.business.service;

import com.xg.mall.po.XgwhWithdrawDeposit;

import java.util.LinkedList;

public interface IWithdrawDepositService {
    LinkedList select(XgwhWithdrawDeposit xgwhWithdrawDeposit);
boolean pass(XgwhWithdrawDeposit xgwhWithdrawDeposit);
}
