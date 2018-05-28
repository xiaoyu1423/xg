package com.xg.mall.business.service;

import com.xg.mall.po.XgwhRole;
import com.xg.mall.po.XgwhRoleAccess;

import java.util.List;


public interface IRoleService {
    boolean add(XgwhRole xgwhRole);
    List<XgwhRole> select();
    XgwhRole selectByPrimaryKey(Integer id);
    boolean update(XgwhRole xgwhRole);
    boolean updateRoleAccess(List<XgwhRoleAccess> list);

    boolean delete(Integer id);
}
