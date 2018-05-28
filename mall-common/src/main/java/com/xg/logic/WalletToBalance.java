/**
 * project: com.xg.mall
 * autho : fred
 * time: 2018-05-05
 */
package com.xg.logic;

import com.xg.mall.po.XgwhMember;
import com.xg.mall.po.XgwhMemberWallet;
import com.xg.utils.ExceptionCode;

/**
 * 钱包提现到余额
 */
public class WalletToBalance {

    //最小非遗券数量
    private static final int min_gp_wallet = 415;
    //非遗券扣除比例%
    private static final int rate_gp_wallet = 2;


    /**
     * 检测用户状体
     *
     * @param xgwhMember
     * @return
     */
    private static ExceptionCode checkMemberStatus(XgwhMember xgwhMember) {
        if (!xgwhMember.getMemberStatus().toString().equals("1")) {
            return ExceptionCode.MEMBER_STATUS_DANGER;
        }
        return ExceptionCode.REQUEST_SUCCESS;
    }

    /**
     * 检测用户非遗券数量
     *
     * @param xgwhMemberWallet
     * @param money
     * @return
     */
    private static ExceptionCode checkMemberFyq(XgwhMemberWallet xgwhMemberWallet, double money) {

        double fyq = xgwhMemberWallet.getFYQ().doubleValue();

        double min = (double) min_gp_wallet;
        if (fyq <= min) {
            return ExceptionCode.FYQ_NOT_ENOUGH;
        }

        double sub_fyq = money * rate_gp_wallet / 100;

        if (fyq - sub_fyq - min < 1) {
            return ExceptionCode.FYQ_NOT_ENOUGH;
        }
        return ExceptionCode.REQUEST_SUCCESS;
    }

    /**
     * 检测提现金额和条件
     *
     * @param xgwhMember
     * @param xgwhMemberWallet
     * @param money
     * @return
     */
    private static ExceptionCode checkTo(XgwhMember xgwhMember, XgwhMemberWallet xgwhMemberWallet, double money) {

        ExceptionCode res = checkMemberStatus(xgwhMember);

        if (!res.getCode().equals("A-00000")) {
            return res;
        }

        res = checkMemberFyq(xgwhMemberWallet, money);

        if (!res.getCode().equals("A-00000")) {
            return res;
        }

        if (xgwhMemberWallet.getMemberWalletMoney().doubleValue() < money) {
            return ExceptionCode.MONEY_NOT_ENOUGH;
        }
        return res;
    }

    /**
     * 分销提现
     *
     * @param xgwhMember
     * @param xgwhMemberWallet
     * @param money
     * @return
     */
    public static ExceptionCode FxToBalance(XgwhMember xgwhMember, XgwhMemberWallet xgwhMemberWallet, double money) {
        return checkTo(xgwhMember, xgwhMemberWallet, money);
    }

    /**
     * 分红提现
     *
     * @param xgwhMember
     * @param xgwhMemberWallet
     * @param money
     * @return
     */
    public static ExceptionCode FhToBalance(XgwhMember xgwhMember, XgwhMemberWallet xgwhMemberWallet, double money) {
        return checkTo(xgwhMember, xgwhMemberWallet, money);
    }

    /**
     * 业绩补助提现
     *
     * @param xgwhMember
     * @param xgwhMemberWallet
     * @param money
     * @return
     */
    public static ExceptionCode YjToBalance(XgwhMember xgwhMember, XgwhMemberWallet xgwhMemberWallet, double money) {
        return checkTo(xgwhMember, xgwhMemberWallet, money);
    }
}
