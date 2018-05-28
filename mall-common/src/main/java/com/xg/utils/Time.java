package com.xg.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化
 */
public class Time {

    /**
     * 获取当前unix时间
     * @return
     */
    public static int UnixTime() {
        String x=Long.toString(System.currentTimeMillis() / 1000);
        int s = Integer.parseInt(x);
        return s;
    }

    /**
     * 将字符串时间转整型时间戳
     *
     * @param str
     * @return
     * @throws ParseException
     */
    public static Integer UnixTime(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
            long ts = date.getTime();
            String res = String.valueOf(ts);
            String string = res.substring(0, 10);
            return Integer.parseInt(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 格式化时固定格式
     *
     * @param time
     * @return
     */
    public static String StrTime(Integer time) {
        if (time == null) {
            time = 0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str_time = time.toString() + "000";
        String sd = simpleDateFormat.format(new Date(Long.parseLong(str_time)));
        return sd;
    }

    /**
     * 格式化时间格式，用户指定
     *
     * @param time
     * @param format
     * @return
     */
    public static String StrTime(Integer time, String format) {
        if (time == null) {
            time = 0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String str_time = time.toString() + "000";
        String sd = simpleDateFormat.format(new Date(Long.parseLong(str_time)));
        return sd;
    }

}
