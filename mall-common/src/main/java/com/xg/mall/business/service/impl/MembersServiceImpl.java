package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IMembersService;
import com.xg.mall.dao.XgwhMemberMapper;
import com.xg.mall.po.XgwhMember;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersServiceImpl implements IMembersService {
    Logger logger = Logger.getLogger(MembersServiceImpl.class);
    @Autowired
    private XgwhMemberMapper xgwhMemberMapper;

    @Override
    //前端展示会员基础资料
    public XgwhMember selectByMemberId(Integer memberId) {
        XgwhMember res = xgwhMemberMapper.selectMember(memberId);
        logger.debug("前端展示会员基础资料");
        return res;
    }
}
