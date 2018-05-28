package com.xg.utils;

import java.util.regex.Pattern;

public class Check {

    //手机号正则
    public final static String PHONE_PATTERN = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17([0,1,6,7,]))|(18[0-2,5-9]))\\d{8}$";
    //密码正则     6-20 位，字母、数字
    public final static String REG = "^[a-zA-Z0-9]{6,20}$";

    /**
     * 判断输入的是不是手机号
     *
     * @return
     */
    public static boolean isPhone(String phone) {
        boolean isPhone = Pattern.compile(PHONE_PATTERN).matcher(phone).matches();
        return isPhone;
    }

    /**
     * 判断输入的密码是不是正确
     *
     * @return
     */
    public static boolean isPassword(String passWord) {
        boolean isPassword = Pattern.compile(REG).matcher(passWord).matches();
        return isPassword;
    }
}
