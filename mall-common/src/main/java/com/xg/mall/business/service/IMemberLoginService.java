package com.xg.mall.business.service;

//会员登录
public interface IMemberLoginService {
    String selectByMemberName(String memberUsername,String memberPassword);
}
