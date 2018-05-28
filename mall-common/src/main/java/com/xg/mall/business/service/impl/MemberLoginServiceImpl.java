package com.xg.mall.business.service.impl;

import com.xg.mall.dao.XgwhMemberMapper;
import com.xg.mall.po.XgwhMember;
import com.xg.mall.business.service.IMemberLoginService;
import com.xg.utils.Login;
import com.xg.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberLoginServiceImpl implements IMemberLoginService {
    @Autowired
    private XgwhMemberMapper xgwhMemberMapper;

    //会员登录
    public String selectByMemberName(String memberName,String memberPassword){
        XgwhMember xgwhMember = xgwhMemberMapper.selectByMemberName(memberName);
        if(xgwhMember == null){
            return "用户名不存在";
        }
        String passWord = xgwhMember.getMemberPassword();
        if(!memberPassword.equals(passWord)){
            return "密码不正确";
        }
        Login.member_username = xgwhMember.getMemberUsername();
        Login.member_id = xgwhMember.getMemberId();
        Login.token = "66666666";
        Login.login_ip = "127.0.0.1";
        Login.login_time = Time.UnixTime();
        return "登录成功";
    }

}
