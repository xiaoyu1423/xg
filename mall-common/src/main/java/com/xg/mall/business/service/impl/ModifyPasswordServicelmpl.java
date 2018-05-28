package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IModifyPasswordService;
import com.xg.mall.dao.XgwhMemberMapper;
import com.xg.mall.po.XgwhMember;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyPasswordServicelmpl  implements IModifyPasswordService {
    //注入用户mapper
    @Autowired
    private XgwhMemberMapper xgwhMemberMapper;
    //修改用户密码
    @Override
    public ResponseBody update(XgwhMember xgwhMember) {
        XgwhMember res = xgwhMemberMapper.selectByPrimaryKey(xgwhMember.getMemberId());
        if (!xgwhMember.getMemberPassword().equals(res.getMemberPassword())) {
            return ResponseUtil.responseBody(false, ExceptionCode.OLD_PASSWORD_ERROR.getMsg(), ExceptionCode.OLD_PASSWORD_ERROR.getCode());
        }
        XgwhMember rs = new XgwhMember();
        rs.setMemberId(xgwhMember.getMemberId());
        rs.setMemberPassword(xgwhMember.getNewPassword());
        int pass = xgwhMemberMapper.updateByPrimaryKeySelective(rs);
        if (pass > 0) {
            return ResponseUtil.responseBody(true, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
        }
        return ResponseUtil.responseBody(false, ExceptionCode.EDIT_PASSWORD_ERROR.getMsg(), ExceptionCode.EDIT_PASSWORD_ERROR.getCode());
    }
}
