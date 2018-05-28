package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IMemberSecrecyService;
import com.xg.mall.dao.XgwhMemberMapper;
import com.xg.mall.dao.XgwhMemberSecrecyMapper;
import com.xg.mall.po.XgwhMember;
import com.xg.mall.po.XgwhMemberSecrecy;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
@Service
public class MemberSecrecyServiceImpl implements IMemberSecrecyService {

    private Logger logger = Logger.getLogger(MemberSecrecyServiceImpl.class);

    @Autowired
    private XgwhMemberSecrecyMapper xgwhMemberSecrecyMapper;
    @Autowired
    private XgwhMemberMapper xgwhMemberMapper;

    @Override
    public boolean add(XgwhMemberSecrecy xgwhMemberSecrecy) {
        int res = xgwhMemberSecrecyMapper.insertSelective(xgwhMemberSecrecy);
        logger.debug("实现层添加资料");
        return res > 0;
    }

    @Override
    public ResponseBody update(XgwhMember xgwhMember) {
        XgwhMember member = xgwhMemberMapper.selectByPrimaryKey(xgwhMember.getMemberId());
        if (xgwhMember.getMemberId().toString().equals("") || member == null) {
            return ResponseUtil.responseBody(false, ExceptionCode.PARAAMATER_ERROR.getMsg(), ExceptionCode.PARAAMATER_ERROR.getCode());
        }
        int rs = xgwhMemberMapper.updateByPrimaryKeySelective(xgwhMember);
        //修改保密资料
        XgwhMemberSecrecy xgwhMemberSecrecy = xgwhMemberSecrecyMapper.selectByMemberId(xgwhMember.getMemberId());
        XgwhMemberSecrecy secrecy = new XgwhMemberSecrecy();
        secrecy.setId(xgwhMemberSecrecy.getId());
        secrecy.setMemberTrueName(xgwhMember.getMemberTrueName());
        secrecy.setMemberMobile(xgwhMember.getMemberMobile());
        secrecy.setMemberAliypay(xgwhMember.getMemberAliypay());
        int res = xgwhMemberSecrecyMapper.updateByPrimaryKeySelective(secrecy);
        logger.debug("实现层编辑资料");
        if (rs > 0 && res > 0) {
            return ResponseUtil.responseBody(true, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
        }
        return ResponseUtil.responseBody(false, ExceptionCode.EDIT_MEMBER_ERROR.getMsg(), ExceptionCode.EDIT_MEMBER_ERROR.getCode());
    }

    @Override
    public XgwhMemberSecrecy select(Integer memberId) {
        XgwhMemberSecrecy xgwhMemberSecrecy = xgwhMemberSecrecyMapper.selectByMemberId(memberId);
        logger.debug("实现层获取资料");
        return xgwhMemberSecrecy;
    }
}
