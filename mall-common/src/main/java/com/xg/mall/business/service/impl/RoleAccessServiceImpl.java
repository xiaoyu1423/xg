package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IRoleAccessService;
import com.xg.mall.dao.XgwhAccessMapper;
import com.xg.mall.dao.XgwhRoleAccessMapper;
import com.xg.mall.po.XgwhAccess;
import com.xg.mall.po.XgwhRoleAccess;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class RoleAccessServiceImpl implements IRoleAccessService {
    private Logger logger = Logger.getLogger(RoleAccessServiceImpl.class);
    @Autowired
    private XgwhRoleAccessMapper xgwhRoleAccessMapper;
    @Autowired
    private XgwhAccessMapper xgwhAccessMapper;
    @Override
    public boolean add(XgwhRoleAccess xgwhRoleAccess) {
        int res = xgwhRoleAccessMapper.insertSelective(xgwhRoleAccess);
        logger.debug("实现层添加角色权限日志");
        return res > 0  ;
    }

    @Override
    public boolean update(XgwhRoleAccess xgwhRoleAccess) {
        int res = xgwhRoleAccessMapper.updateByPrimaryKeySelective(xgwhRoleAccess);
        logger.debug("实现层编辑角色权限日志");
        return  res > 0 ;
    }

    @Override
    public boolean delete(Integer roleId) {
        int res = xgwhRoleAccessMapper.deleteRoleId(roleId);
        logger.debug("实现层删除角色权限日志");
        return res > 0 ;
    }

    @Override
    public List<XgwhAccess> select(Integer roleId) {
        List<XgwhRoleAccess> list = xgwhRoleAccessMapper.select(roleId);
        List<XgwhAccess> arr      = xgwhAccessMapper.select();
        LinkedList<Integer>access_ids  = new LinkedList<>();
        for (XgwhRoleAccess access : list){
             access_ids.add(access.getAccessId());
        }
        for (XgwhAccess access1 : arr){
            if(access_ids.contains(access1.getId())){
                    access1.setResult(1);
            }else{
                   access1.setResult(0);
            }
        }
        logger.debug("实现层查询角色权限日志");
        if(arr.isEmpty()){
            return Collections.emptyList();
        }
        return arr;
    }
}
