package com.xg.mall.business.service;

import com.xg.mall.po.XgwhAccess;
import com.xg.mall.po.XgwhRoleAccess;

import java.util.List;

public interface IRoleAccessService {

    boolean add(XgwhRoleAccess xgwhRoleAccess);
    boolean update(XgwhRoleAccess xgwhRoleAccess);
    boolean delete(Integer roleId);
    List<XgwhAccess> select(Integer roleId);
}
