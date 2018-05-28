package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IWithdrawService;
import com.xg.mall.dao.XgwhMemberSecrecyMapper;
import com.xg.mall.dao.XgwhMemberWalletMapper;
import com.xg.mall.dao.XgwhRecordMapper;
import com.xg.mall.dao.XgwhWithdrawDepositMapper;
import com.xg.mall.po.XgwhMemberSecrecy;
import com.xg.mall.po.XgwhMemberWallet;
import com.xg.mall.po.XgwhRecord;
import com.xg.mall.po.XgwhWithdrawDeposit;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WithdrawServiceImpl implements IWithdrawService {
    private Logger logger = Logger.getLogger(WithdrawServiceImpl.class);
    @Autowired
    private XgwhMemberWalletMapper xgwhMemberWalletMapper;
    @Autowired
    private XgwhMemberSecrecyMapper xgwhMemberSecrecyMapper;
    @Autowired
    private XgwhWithdrawDepositMapper xgwhWithdrawDepositMapper;
    @Autowired
    private XgwhRecordMapper xgwhRecordMapper;

    @Override
    public ResponseBody withdraws(XgwhMemberWallet xgwhMemberWallet) {
        Integer memberId = xgwhMemberWallet.getMemberId();
        //查询memberWalletId
        Integer memberWalletId = xgwhMemberWalletMapper.selectShopincomeByMemberId(memberId).getMemberWalletId();
        xgwhMemberWallet.setMemberWalletId(memberWalletId);
        xgwhMemberWallet.setWalletId(1);
        if (memberId < 1) {
            return ResponseUtil.responseBody(false, ExceptionCode.PARAAMATER_ERROR.getMsg(), ExceptionCode.PARAAMATER_ERROR.getCode());
        }
        //查询非遗券
        XgwhMemberWallet rs = xgwhMemberWalletMapper.selectFyq(memberId, 1);
        if (rs.getMemberWalletMoney().toString().equals("0.000")) {
            return ResponseUtil.responseBody(false, ExceptionCode.FYQ_NOT_ENOUGH.getMsg(), ExceptionCode.FYQ_NOT_ENOUGH.getCode());
        }

        if (xgwhMemberWallet.getWithdrawMoney() == null) {
            return ResponseUtil.responseBody(false, ExceptionCode.INPUT_MONEY.getMsg(), ExceptionCode.INPUT_MONEY.getCode());
        }

        //判断输入金额
        String withdraw = xgwhMemberWallet.getWithdrawMoney().toString();
        if(ExceptionCode.isNumeric(withdraw) == false){
            return ResponseUtil.responseBody(false, ExceptionCode.INPUT_NUM.getMsg(), ExceptionCode.INPUT_NUM.getCode());
        }
        Double withdraws = Double.parseDouble(withdraw);
        int withdrawss = (new Double(withdraws)).intValue();
        if(withdrawss%100 != 0){
            return ResponseUtil.responseBody(false, ExceptionCode.INPUT_HUNDRED.getMsg(), ExceptionCode.INPUT_HUNDRED.getCode());
        }

        if(withdrawss > 3000){
            return ResponseUtil.responseBody(false, ExceptionCode.MONEY_LIMIT.getMsg(), ExceptionCode.MONEY_LIMIT.getCode());
        }

        //查询用户余额有多少钱
        XgwhMemberWallet shopincome = xgwhMemberWalletMapper.selectShopincome(memberId, 1);
        if (shopincome.getMemberWalletMoney().toString().equals("0.000")) {
            return ResponseUtil.responseBody(false, ExceptionCode.MONEY_NOT_ENOUGH.getMsg(), ExceptionCode.MONEY_NOT_ENOUGH.getCode());
        }
        String income = shopincome.getMemberWalletMoney().toString();
        Double incomes = Double.parseDouble(income);
        int shop_income = (new Double(incomes)).intValue();
        int shop_incomes = shop_income - withdrawss;
        if(shop_incomes < 0){
            return ResponseUtil.responseBody(false, ExceptionCode.INPUT_TOO_LARGE.getMsg(), ExceptionCode.INPUT_TOO_LARGE.getCode());
        }

        //对一天内的提现次数做限制
        int counts = xgwhWithdrawDepositMapper.dayWithdrawCounts(memberId);
        if(counts > 2){
            return ResponseUtil.responseBody(false, ExceptionCode.DAY_COUNTS_TOO_LARGE.getMsg(), ExceptionCode.DAY_COUNTS_TOO_LARGE.getCode());
        }

        //用会员ID查真实姓名和支付宝账号
        XgwhMemberSecrecy xgwhMemberSecrecy = xgwhMemberSecrecyMapper.selectByMemberId(memberId);
        String trueName = xgwhMemberSecrecy.getMemberTrueName();
        String alipay   = xgwhMemberSecrecy.getMemberAliypay();
        if(trueName.equals( null) || alipay.equals(null)){
            return ResponseUtil.responseBody(false, ExceptionCode.INPUT_ALIYPAY.getMsg(), ExceptionCode.INPUT_ALIYPAY.getCode());
        }

        //修改用户余额
        BigDecimal a = new BigDecimal(shop_incomes);
        xgwhMemberWallet.setShopincome(a);
        int isWithdraws = xgwhMemberWalletMapper.withdraws(xgwhMemberWallet);
        logger.debug("余额提现");
        if(isWithdraws > 0){
            //提现表中入一条数据 余额提现
            XgwhWithdrawDeposit xgwhWithdrawDeposit = new XgwhWithdrawDeposit();
            xgwhWithdrawDeposit.setAddTime(Time.UnixTime());
            xgwhWithdrawDeposit.setMemberId(memberId);
            xgwhWithdrawDeposit.setOutTradeNo("2222222222");
            xgwhWithdrawDeposit.setWithdrawMoney(new BigDecimal(withdrawss));
            xgwhWithdrawDeposit.setWithdrawAlipay(xgwhMemberSecrecy.getMemberAliypay());
            int isInsert = xgwhWithdrawDepositMapper.insertSelective(xgwhWithdrawDeposit);

            if (isInsert > 0) {
                //明细表记录一条数据   余额提现
                XgwhRecord xgwhRecord = new XgwhRecord();
                xgwhRecord.setMemberId(memberId);
                xgwhRecord.setRecordMoney(new BigDecimal(withdrawss));
                xgwhRecord.setRecordDirect((byte) 0);
                xgwhRecord.setRecordDesc("余额提现");
                xgwhRecord.setRecordType((byte) 1);
                xgwhRecord.setRecordTime(Time.UnixTime());
                int isAdd = xgwhRecordMapper.insertSelective(xgwhRecord);
                if (isAdd > 0) {
                    return ResponseUtil.responseBody(true, ExceptionCode.WITHDRAW_SUCCESS.getMsg(), ExceptionCode.WITHDRAW_SUCCESS.getCode());
                }
            }

        }
        return ResponseUtil.responseBody(false, ExceptionCode.WITHDRAW_FALSE.getMsg(), ExceptionCode.WITHDRAW_FALSE.getCode());
    }
}
