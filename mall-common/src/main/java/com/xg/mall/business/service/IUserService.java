package com.xg.mall.business.service;

import com.xg.mall.po.XgwhUser;
import com.xg.mall.po.XgwhUserRole;

import java.util.List;

public interface IUserService {
    boolean add(XgwhUser xgwhUser);
    boolean update(XgwhUser xgwhUser);
    boolean updateUserRole(List<XgwhUserRole> list);
    boolean delete(Integer id);
    List<XgwhUser> select();
    XgwhUser selectByPrimaryKey(Integer id);
}
