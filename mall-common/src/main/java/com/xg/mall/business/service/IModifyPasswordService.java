package com.xg.mall.business.service;

import com.xg.mall.po.XgwhMember;
import com.xg.mall.vo.ResponseBody;

public interface IModifyPasswordService {
    //修改密码
    ResponseBody update(XgwhMember xgwhMember);
}
