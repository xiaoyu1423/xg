package com.xg.mall.business.service.impl;

import com.xg.logic.WalletToBalance;
import com.xg.mall.business.service.IWithdrawToShopincomeService;
import com.xg.mall.dao.XgwhMemberMapper;
import com.xg.mall.dao.XgwhMemberWalletMapper;
import com.xg.mall.po.XgwhMember;
import com.xg.mall.po.XgwhMemberWallet;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.xg.mall.dao.XgwhMemberWalletMapper;
//import com.xg.mall.dao.XgwhRecordMapper;
//import com.xg.mall.dao.XgwhWalletMapper;
//import com.xg.mall.po.XgwhRecord;
//import com.xg.utils.Time;

//import java.math.BigDecimal;
//import java.util.List;

@Service
public class WithdrawToShopincomeServiceImpl implements IWithdrawToShopincomeService {

    @Autowired
    private XgwhMemberMapper xgwhMemberMapper;
    @Autowired
    private XgwhMemberWalletMapper xgwhMemberWalletMapper;
    //@Autowired
    //private XgwhWalletMapper xgwhWalletMapper;
    //@Autowired
    //private XgwhRecordMapper xgwhRecordMapper;

    @Override
    public ResponseBody withdraw(XgwhMemberWallet xgwhMemberWallet) {

        int memberId = xgwhMemberWallet.getMemberId();

        XgwhMemberWallet xgwhMemberWallet1 = xgwhMemberWalletMapper.selectFyq(memberId, 1);

        XgwhMember xgwhMember = xgwhMemberMapper.selectMember(memberId);

        double money = xgwhMemberWallet.getWithdrawMoney().doubleValue();
        xgwhMemberWallet.setFYQ(xgwhMemberWallet1.getMemberWalletMoney());

        ExceptionCode res = WalletToBalance.FxToBalance(xgwhMember, xgwhMemberWallet, money);

        if (!res.getCode().equals("A-00000")) {
            return ResponseUtil.responseBody(false, res.getMsg(), res.getMsg());
        }

        return ResponseUtil.responseBody(true, res.getMsg(), res.getCode());

        /**
         * 1. 加日志
         * 1）钱包减少
         * 2）手继续
         * 3）谷粒
         * 4）余额增加
         * 2。扣钱包
         * 3。扣非遗券
         * 4。余额加
         */


//        Integer memberId = xgwhMemberWallet.getMemberId();
//        Integer walletId = xgwhMemberWallet.getWalletId();
//        Integer memberWalletId = xgwhMemberWalletMapper.selectMoneyByMemberId(memberId,walletId).getMemberWalletId();
//        xgwhMemberWallet.setMemberWalletId(memberWalletId);
//        //查询非遗券
//        XgwhMemberWallet rs = xgwhMemberWalletMapper.selectFyq(memberId,walletId);
//        if(rs.getMemberWalletMoney().toString().equals("0.000")){
//            return ResponseUtil.responseBody(false,ExceptionCode.FYQ_NOT_ENOUGH.getMsg(),ExceptionCode.FYQ_NOT_ENOUGH.getCode());
//        }
//        //根据会员ID查询会员钱包
//        List<XgwhMemberWallet> memberWallets = xgwhMemberWalletMapper.selectByMemberId(memberId);
//        //循环会员钱包
//        for(XgwhMemberWallet res : memberWallets){
//              if(res.getWalletId() != 1){
//
//                   //查询余额
//                   XgwhMemberWallet shop_income = xgwhMemberWalletMapper.selectMoneyByWalletId(memberId,1);
//                   String shop_incomes = shop_income.getMemberWalletMoney().toString();
//                   BigDecimal incomes = new BigDecimal(shop_incomes);
//                   //是否非遗分红
//                   if(walletId == 4){
//                       //如果有输入就阻止提现
//                       String withdrawsss  = xgwhMemberWallet.getWithdrawMoney().toString();
//                       if(!withdrawsss.equals("")){
//                           return ResponseUtil.responseBody(false,ExceptionCode.PARAAMATER_ERROR.getMsg(),ExceptionCode.PARAAMATER_ERROR.getCode());
//                       }
//
//                       //查询要转到余额的钱数
//                       XgwhMemberWallet withdraws = xgwhMemberWalletMapper.selectMoneyByWalletId(memberId,walletId);
//                       String withdrawss = withdraws.getMemberWalletMoney().toString();
//
//                       Double intMoney = Double.parseDouble(withdrawss);
//                       double mm = Math.ceil(intMoney/100);
//                       int i = (new Double(mm)).intValue();
//                       if(i == 0){
//                           return ResponseUtil.responseBody(false,ExceptionCode.MONEY_NOT_ENOUGH.getMsg(),ExceptionCode.MONEY_NOT_ENOUGH.getCode());
//                       }
//                       //拿到非遗券钱数
//                       XgwhMemberWallet fyq = xgwhMemberWalletMapper.selectFyq(memberId,walletId);
//                       String fyqs = fyq.getMemberWalletMoney().toString();
//                       Double intMoneys = Double.parseDouble(fyqs);
//                       int fyqss = (new Double(intMoneys)).intValue();
//                       //根据提到余额金额减非遗券金额
//                       int FYQ =fyqss - i;
//                       if(FYQ < 0){
//                           FYQ = 0;
//                       }
//                       BigDecimal bigDecimals = new BigDecimal(FYQ);
//                       xgwhMemberWallet.setFYQ(bigDecimals);
//                       int fyqsss = xgwhMemberWalletMapper.reduceFyq(xgwhMemberWallet);
//
//                       BigDecimal money =new BigDecimal(withdrawss);
//                       //转钱到余额
//                       BigDecimal shop_incomess = null;
//                       BigDecimal  rate = BigDecimal.valueOf(0.8);
//                       BigDecimal moneys = money.multiply(rate);
//                       shop_incomess = incomes.add(moneys);
//                       xgwhMemberWallet.setShopincome(shop_incomess);
//                       int bb = xgwhMemberWalletMapper.addShopincome(xgwhMemberWallet);
//                       //查询谷粒
//                       XgwhMemberWallet guli = xgwhMemberWalletMapper.selectGrain(memberId,walletId);
//                       String gulis = guli.getMemberWalletMoney().toString();
//                       BigDecimal guliss = new BigDecimal(gulis);
//
//                       //提现时赚钱到谷粒
//                       BigDecimal Grains = null;
//                       BigDecimal  rates = BigDecimal.valueOf(0.1);
//                       BigDecimal grains = money.multiply(rates);
//                       Grains = guliss.add(grains);
//                       xgwhMemberWallet.setGrain(Grains);
//                       int dd = xgwhMemberWalletMapper.addGrain(xgwhMemberWallet);
//                       //减该钱包中的钱
//                       int aa = xgwhMemberWalletMapper.withdraw(xgwhMemberWallet);
//                       if(aa > 0 && bb > 0 && fyqsss > 0 && dd > 0){
//                           //明细表记录一条数据   非遗分红提现到余额
//                           XgwhRecord xgwhRecord = new XgwhRecord();
//                           xgwhRecord.setMemberId(memberId);
//                           xgwhRecord.setRecordMoney(moneys);
//                           xgwhRecord.setRecordDirect((byte)0);
//                           xgwhRecord.setRecordDesc("非遗分红转钱到余额");
//                           xgwhRecord.setRecordType((byte)4);
//                           xgwhRecord.setRecordTime(Time.UnixTime());
//                           int isAdd = xgwhRecordMapper.insertSelective(xgwhRecord);
//                           if(isAdd > 0){
//                               return ResponseUtil.responseBody(true,ExceptionCode.WITHDRAW_SUCCESS.getMsg(),ExceptionCode.WITHDRAW_SUCCESS.getCode());
//                           }
//                           return  ResponseUtil.responseBody(false,ExceptionCode.WITHDRAW_FALSE.getMsg(),ExceptionCode.WITHDRAW_FALSE.getCode());
//                       }
//                   }else{
//                       String withdrawss  = xgwhMemberWallet.getWithdrawMoney().toString();
//                       Double intMoney = Double.parseDouble(withdrawss);
//                       double mm = Math.ceil(intMoney/100);
//                       int i = (new Double(mm)).intValue();
//
//                       //减该钱包中的钱
//                       int ee = Integer.parseInt(withdrawss); //该钱包中的钱
//                       int cc = Integer.parseInt(xgwhMemberWallet.getWithdrawMoney().toString());  //提现金额
//                       int surplus = ee - cc; //该钱包中剩余的钱数
//                       if(surplus < 0){
//                           return  ResponseUtil.responseBody(false,ExceptionCode.INPUT_TOO_LARGE.getMsg(),ExceptionCode.INPUT_TOO_LARGE.getCode());
//                       }
//                       BigDecimal surplu = new BigDecimal(surplus);
//                       xgwhMemberWallet.setSurplus(surplu);
//                       int aa = xgwhMemberWalletMapper.withdrawss(xgwhMemberWallet);
//
//                       //拿到非遗券钱数
//                       XgwhMemberWallet fyq = xgwhMemberWalletMapper.selectFyq(memberId,walletId);
//                       String fyqs = fyq.getMemberWalletMoney().toString();
//                       Double intMoneys = Double.parseDouble(fyqs);
//                       int fyqss = (new Double(intMoneys)).intValue();
//                       //根据提到余额金额减非遗券金额
//                       int FYQ =fyqss - i;
//                       if(FYQ < 0){
//                           FYQ = 0;
//                       }
//                       BigDecimal bigDecimals = new BigDecimal(FYQ);
//                       xgwhMemberWallet.setFYQ(bigDecimals);
//                       int fyqsss = xgwhMemberWalletMapper.reduceFyq(xgwhMemberWallet);
//                       BigDecimal money =new BigDecimal(withdrawss);
//                       //转钱到余额
//                       BigDecimal shop_incomess = null;
//                       BigDecimal  rate = BigDecimal.valueOf(0.8);
//                       BigDecimal moneys = money.multiply(rate);
//                       shop_incomess = incomes.add(moneys);
//                       xgwhMemberWallet.setShopincome(shop_incomess);
//                       int bb = xgwhMemberWalletMapper.addShopincome(xgwhMemberWallet);
//                       //查询谷粒
//                       XgwhMemberWallet guli = xgwhMemberWalletMapper.selectGrain(memberId,walletId);
//                       String gulis = guli.getMemberWalletMoney().toString();
//                       BigDecimal guliss = new BigDecimal(gulis);
//
//                       //提现时赚钱到谷粒
//                       BigDecimal Grains = null;
//                       BigDecimal  rates = BigDecimal.valueOf(0.1);
//                       BigDecimal grains = money.multiply(rates);
//                       Grains = guliss.add(grains);
//                       xgwhMemberWallet.setGrain(Grains);
//                       int dd = xgwhMemberWalletMapper.addGrain(xgwhMemberWallet);
//
//                       if(aa > 0 && bb > 0 && fyqsss > 0 && dd > 0){
//                           //明细表记录一条数据   非遗分红提现到余额
//                           XgwhRecord xgwhRecord = new XgwhRecord();
//                           xgwhRecord.setMemberId(memberId);
//                           xgwhRecord.setRecordMoney(moneys);
//                           xgwhRecord.setRecordDirect((byte)0);
//                           xgwhRecord.setRecordDesc("其他转钱到余额");
//                           xgwhRecord.setRecordType((byte)3.5);
//                           xgwhRecord.setRecordTime(Time.UnixTime());
//                           int isAdd = xgwhRecordMapper.insertSelective(xgwhRecord);
//                           if(isAdd > 0){
//                               return ResponseUtil.responseBody(true,ExceptionCode.WITHDRAW_SUCCESS.getMsg(),ExceptionCode.WITHDRAW_SUCCESS.getCode());
//                           }
//                           return  ResponseUtil.responseBody(false,ExceptionCode.WITHDRAW_FALSE.getMsg(),ExceptionCode.WITHDRAW_FALSE.getCode());
//                       }
//                   }
//              }
//        }
//        return  ResponseUtil.responseBody(false,ExceptionCode.WITHDRAW_FALSE.getMsg(),ExceptionCode.WITHDRAW_FALSE.getCode());

    }

}
