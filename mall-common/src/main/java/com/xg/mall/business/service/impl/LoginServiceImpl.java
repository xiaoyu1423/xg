package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.ILoginService;
import com.xg.mall.dao.XgwhUserMapper;
import com.xg.mall.po.XgwhUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    //注入用户mapper
    private XgwhUserMapper xgwhUserMapper;

    @Override
    public String select(String userName, String userPassword,String mobile) {
        XgwhUser xgwhUser =xgwhUserMapper.selectByUserName(userName);
        if(xgwhUser == null){
            return "账号不存在";
        }
        String Password = xgwhUser.getUserPassword();
        String mobile2   = xgwhUser.getMobile();
        if(Password.equals(userPassword)){
            if(mobile2.equals(mobile)){
                return "登陆成功";
            }else{
                return "手机号不对";
            }

        }else{
            return "密码不正确";
        }

    }
}
