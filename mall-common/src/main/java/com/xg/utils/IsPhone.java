package com.xg.utils;

import java.util.regex.Pattern;

/**
 * 判断输入的是不是手机号
 *
 * @return
 */
public class IsPhone {

    //手机号正则
    public final static String PHONE_PATTERN = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17([0,1,6,7,]))|(18[0-2,5-9]))\\d{8}$";

    /**
     * 判断输入的是不是手机号
     *
     * @return
     */
    public static boolean isPhone(String phone) {
        boolean isPhone = Pattern.compile(PHONE_PATTERN).matcher(phone).matches();
        return isPhone;
    }

}
