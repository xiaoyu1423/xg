package com.xg.utils;

import java.util.LinkedList;

/**
 * 封装求数组差集
 */
public class Substract {
    //求两个数组的差集
    public static String[] substract(String[] arr1, String[] arr2) {

        //定义一个数组
        LinkedList<String> list = new LinkedList<>();

        //循环第一个数组拿出放新数组
        for (String str : arr1) {
            if(!list.contains(str)) {
                list.add(str);
            }
        }
        //循环第二个数组看新数组是不是包含循环出来的每个值如果有就是删除
        for (String str : arr2) {
            list.remove(str);
        }

        //定义一个String数组
        String[] result = {};

        //将数组转换然后返回
        return list.toArray(result);
    }
}
