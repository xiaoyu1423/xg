package com.xg.mall.business.service;

import com.xg.mall.po.XgwhMember;
import com.xg.mall.po.XgwhMemberSecrecy;
import com.xg.mall.vo.ResponseBody;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
public interface IMemberSecrecyService {
    boolean add(XgwhMemberSecrecy xgwhMemberSecrecy);

    ResponseBody update(XgwhMember xgwhMember);
    XgwhMemberSecrecy select(Integer memberId);
}
