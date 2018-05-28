package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IMemberLogoutService;
import com.xg.utils.Login;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginOutServiceImpl implements IMemberLogoutService {

    @Override
    public boolean logOut(Integer memberId){
        Login.token = "";
        Login.login_time = 0;
        Login.login_ip = "";
        Login.member_id = 0;
        Login.login_ip = "";
        return Login.token == "" && Login.login_time == 0 && Login.login_ip == "" && Login.member_id == 0 && Login.login_ip == "";
    }
}
