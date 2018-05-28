package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IMemberAgreementService;
import com.xg.mall.dao.XgwhAgreeMapper;
import com.xg.mall.po.XgwhAgree;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberAgreementServiceImpl implements IMemberAgreementService {
    Logger logger = Logger.getLogger(MemberAgreementServiceImpl.class);
    @Autowired
    private XgwhAgreeMapper xgwhAgreeMapper;

    //查询用户协议
    public XgwhAgree selectMemberAgreement() {
        XgwhAgree res = xgwhAgreeMapper.selectMemberAgreement();
        logger.debug("查看用户协议日志");
        return res;
    }

}
