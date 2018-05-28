package com.xg.mall.business.service;

import com.xg.mall.po.XgwhAccess;

import java.util.List;

public interface IAccessService {
       boolean add(XgwhAccess xgwhAccess);
       List<XgwhAccess> select();
       XgwhAccess selectByPrimaryKey(Integer id);
       boolean update(XgwhAccess xgwhAccess);
       boolean delete(Integer id);
}
