package com.xg.mall.business.service;


import com.xg.mall.po.XgwhMemberSecrecy;

import java.util.List;

public interface IMemberSecrecyBackService {
    //添加会员密保
    boolean addSecrecy(XgwhMemberSecrecy xgwhMemberSecrecy);
    //修改会员密保
    boolean udpateSecrecy(XgwhMemberSecrecy xgwhMemberSecrecy);
    //查询所有密保资料
    List<XgwhMemberSecrecy> selectSecrecy(XgwhMemberSecrecy xgwhMemberSecrecy);

    XgwhMemberSecrecy selectById(Integer id);
}
