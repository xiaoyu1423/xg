package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IMemberRegService;
import com.xg.mall.dao.XgwhMemberMapper;
import com.xg.mall.po.XgwhMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRegServiceImpl implements IMemberRegService {
    @Autowired
    private XgwhMemberMapper xgwhMemberMapper;

    //会员注册
    @Override
    public boolean memberReg(XgwhMember xgwhMember){
        String userName = xgwhMember.getMemberUsername();
        String checkCode = xgwhMember.getCheckCode();
        XgwhMember res = xgwhMemberMapper.selectByMemberName(userName);
        if (res != null || checkCode == null) {
            return false;
        }
        int isReg = xgwhMemberMapper.insertSelective(xgwhMember);
        return  isReg > 0;
    }
}
