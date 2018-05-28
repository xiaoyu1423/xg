package com.xg.mall.business.service;

import com.xg.mall.po.XgwhRole;
import com.xg.mall.po.XgwhUserRole;

import java.util.List;

public interface IUserRoleService {
    boolean add(XgwhUserRole xgwhUserRole);
    boolean update(XgwhUserRole xgwhUserRole);
    boolean delete(Integer userId);
    List<XgwhRole> select(Integer userId);
}
