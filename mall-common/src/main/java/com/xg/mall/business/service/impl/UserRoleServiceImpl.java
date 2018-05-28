package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IUserRoleService;
import com.xg.mall.dao.XgwhRoleMapper;
import com.xg.mall.dao.XgwhUserRoleMapper;
import com.xg.mall.po.XgwhRole;
import com.xg.mall.po.XgwhUserRole;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    private Logger logger = Logger.getLogger(UserRoleServiceImpl.class);
    @Autowired
    private XgwhUserRoleMapper xgwhUserRoleMapper;
    @Autowired
    private XgwhRoleMapper xgwhRoleMapper;

    @Override
    public boolean add(XgwhUserRole xgwhUserRole) {

        int res = xgwhUserRoleMapper.insertSelective(xgwhUserRole);
        logger.debug("实现层添加管理员角色日志");
        return res > 0;

    }

    @Override
    public boolean update(XgwhUserRole xgwhUserRole) {

        int res = xgwhUserRoleMapper.updateByPrimaryKeySelective(xgwhUserRole);
        logger.debug("实现层更新管理员角色日志");
        return res > 0;
    }

    @Override
    public boolean delete(Integer userId) {

        int res = xgwhUserRoleMapper.deleteUserRole(userId);
        logger.debug("实现层删除管理员角色日志");
        return res > 0;
    }

    @Override
    public List<XgwhRole> select(Integer userId) {

        List<XgwhUserRole> list = xgwhUserRoleMapper.selectUserId(userId);
        List<XgwhRole> arr = xgwhRoleMapper.select();
        LinkedList<Integer> roles = new LinkedList<>();
        for (XgwhUserRole roleId : list) {
            roles.add(roleId.getRoleId());
        }
        for (XgwhRole role : arr) {
            if (roles.contains(role.getId())) {
                role.setStatus(1);
            } else {
                role.setStatus(0);
            }

        }
        logger.debug("实现层查询管理员角色日志");
        if (arr.isEmpty()) {
            return Collections.emptyList();
        }
        return arr;
    }
}
