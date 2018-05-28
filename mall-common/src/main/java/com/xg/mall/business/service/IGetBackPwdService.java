package com.xg.mall.business.service;

import com.xg.mall.po.XgwhMember;

public interface IGetBackPwdService {
    String selectPwdByMemberId(XgwhMember xgwhMember);
}
