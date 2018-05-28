package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IAccessService;
import com.xg.mall.dao.XgwhAccessMapper;
import com.xg.mall.dao.XgwhRoleAccessMapper;
import com.xg.mall.po.XgwhAccess;
import com.xg.mall.po.XgwhRoleAccess;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AccessServiceImpl implements IAccessService {
    private Logger logger = Logger.getLogger(AccessServiceImpl.class);
    //注入权限mapper
    @Autowired
    private XgwhAccessMapper xgwhAccessMapper;

    //注入权限和角色mapper
    @Autowired
    private XgwhRoleAccessMapper xgwhRoleAccessMapper;

    @Override
    public boolean add(XgwhAccess xgwhAccess) {
        xgwhAccess.setAddTime(Time.UnixTime());
        int res = xgwhAccessMapper.insertSelective(xgwhAccess);
        logger.debug("实现层添加权限日志");
        return res > 0;
    }

    @Override
    public List<XgwhAccess> select() {
        List<XgwhAccess> list = xgwhAccessMapper.select();
        logger.debug("实现层查询权限日志");
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        return list;
    }

    @Override
    public XgwhAccess selectByPrimaryKey(Integer id) {
        XgwhAccess xgwhAccess = xgwhAccessMapper.selectByPrimaryKey(id);
        logger.debug("实现层查询单个权限日志");
        return xgwhAccess;
    }

    @Override
    public boolean update(XgwhAccess xgwhAccess) {
        int res = xgwhAccessMapper.updateByPrimaryKeySelective(xgwhAccess);
        logger.debug("实现层更新权限日志");
        return res > 0 ;
    }

    @Override
    public boolean delete(Integer id) {
        List<XgwhRoleAccess> list = xgwhRoleAccessMapper.selectByAccessId(id);
        if(!list.isEmpty()){
            int result = xgwhRoleAccessMapper.deleteAccessId(id);
            if(result < 1){
                return false;
            }
        }
        int res = xgwhAccessMapper.deleteByPrimaryKey(id);
        logger.debug("实现层删除权限日志");
        return res > 0;
    }
}
