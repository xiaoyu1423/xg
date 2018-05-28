package com.xg.mall.business.service;

import com.xg.mall.po.XgwhMember;
import com.xg.mall.vo.ResponseBody;

import java.util.LinkedList;

public interface IMemberService {
    boolean add(XgwhMember xgwhMember);

    ResponseBody update(XgwhMember xgwhMember);
    boolean delete(Integer memberId);

    LinkedList select(XgwhMember xgwhMember);
    XgwhMember selectById(Integer id);
}
