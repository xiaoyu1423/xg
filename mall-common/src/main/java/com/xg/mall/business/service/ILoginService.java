package com.xg.mall.business.service;

import com.xg.mall.po.XgwhUser;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
public interface ILoginService {
     String select(String userName,String userPassword,String mobile);
}
