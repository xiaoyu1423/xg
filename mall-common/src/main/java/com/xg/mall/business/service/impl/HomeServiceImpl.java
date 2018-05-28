package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IHomeService;
import com.xg.mall.dao.XgwhHomeMapper;
import com.xg.mall.po.XgwhHome;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018/5/24
 * 前端首页内容
 */
@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    XgwhHomeMapper xgwhHomeMapper;
    private Logger logger = Logger.getLogger(HomeServiceImpl.class);

    @Override
    public List<XgwhHome> select() {
        List<XgwhHome> xgwhHome = xgwhHomeMapper.select();
        logger.debug("实现层前端首页内容");
        return xgwhHome;
    }
}
