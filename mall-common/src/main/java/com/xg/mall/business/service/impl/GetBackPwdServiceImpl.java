package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IGetBackPwdService;
import com.xg.mall.dao.XgwhMemberMapper;
import com.xg.mall.po.XgwhMember;
import com.xg.utils.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetBackPwdServiceImpl implements IGetBackPwdService {
    @Autowired
    private XgwhMemberMapper xgwhMemberMapper;

    @Override
    public String selectPwdByMemberId(XgwhMember xgwhMember) {
        if (xgwhMember.getMemberUsername().equals("")) {
            return "手机号不能为空";
        }
        boolean isMember = Check.isPhone(xgwhMember.getMemberUsername());
        if (!isMember) {
            return "输入的手机号格式不正确";
        }
        XgwhMember rs = xgwhMemberMapper.selectByMemberName(xgwhMember.getMemberUsername());
        if (rs == null) {
            return "手机号输入错误";
        }
        if (!xgwhMember.getCheckCode().equals("123456")) {
            return  "验证码错误";
        }
        if (xgwhMember.getNewPassword().equals("")) {
            return "新密码不能为空";
        }
        boolean isNew = Check.isPassword(xgwhMember.getNewPassword());
        if (!isNew) {
            return "新密码必须由6-20位长度的数字和字母组成";
        }
        if (xgwhMember.getReNewPassword().equals("")) {
            return "确认密码不能为空";
        }
        if (!xgwhMember.getNewPassword().equals(xgwhMember.getReNewPassword())) {
            return "两次输入密码不一致";
        }
        XgwhMember xgwhMembers = new XgwhMember();
        xgwhMembers.setMemberId(rs.getMemberId());
        xgwhMembers.setMemberUsername(xgwhMember.getMemberUsername());
        xgwhMembers.setMemberPassword(xgwhMember.getNewPassword());
        int res = xgwhMemberMapper.updateByPrimaryKeySelective(xgwhMembers);
        if(res <= 0){
           return "找回密码失败";
        }
        return "找回密码成功";
    }
}
