package com.xg.utils;

/**
 * @Author: zhangchu@iyungu.com
 * @Description: 异常类
 * @Date: 16:23 2017/11/23
 * @Modified By:
 */
public enum ExceptionCode {

    REQUEST_SUCCESS("A-00000", "成功"),
    EDIT_MEMBER_ERROR("A-00001", "修改用户资料失败"),
    EDIT_MEMBER_SECRECY_ERROR("A-00002", "修改会员保密资料失败"),
    PARAAMATER_ERROR("A-00003", "参数错误"),
    OLD_PASSWORD_ERROR("A-00004", "旧密码错误"),
    EDIT_PASSWORD_ERROR("A-00005", "修改密码失败"),
    FYQ_NOT_ENOUGH("A-00006", "非遗券不足无法提现"),
    INPUT_MONEY("A-00007", "请输入提现金额"),
    INPUT_NUM("A-00008", "请输入数字"),
    INPUT_HUNDRED("A-00009", "请输入100的整数倍"),
    MONEY_LIMIT("A-00010", "超过每次提现金额限制"),
    MONEY_NOT_ENOUGH("A-00011", "余额不足无法提现"),
    INPUT_TOO_LARGE("A-00012", "输入的提现金额过大"),
    DAY_COUNTS_TOO_LARGE("A-00013", "单日提现次数不能超过两次"),
    INPUT_ALIYPAY("A-00014", "请完善用户真实姓名或支付宝账号"),
    WITHDRAW_SUCCESS("A-00015", "提现成功"),
    WITHDRAW_FALSE("A-00016", "提现失败"),
    MEMBER_STATUS_DANGER("A-00017", "会员状态异常");






    private final String code;
    private final String msg;

    ExceptionCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public static String getMsgByCode(String code) {
        for (ExceptionCode exceptionCode : ExceptionCode.values()) {
            if (!code.isEmpty() && code.equals(exceptionCode.getCode())) {
                return exceptionCode.getMsg();
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ExceptionCode{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    //Java中判断字符串是否为数字的方法
    public final static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim())){
            return s.matches("^[0-9]*$");
        }
        else
        {
            return false;
        }
    }
}