package com.xg.mall.business.service.impl;

import com.xg.mall.dao.XgwhDistributionConfigMapper;
import com.xg.mall.po.XgwhDistributionConfig;
import com.xg.mall.business.service.IXgwhDistributionConfigService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-14
 */
@Service
public class XgwhDistributionConfigServiceImpl implements IXgwhDistributionConfigService {

    private Logger logger = Logger.getLogger(XgwhDistributionConfigServiceImpl.class);
    @Autowired
    private XgwhDistributionConfigMapper xgwhDistributionConfigMapper;
    @Override
    public XgwhDistributionConfig select(Integer type) {
        XgwhDistributionConfig xgwhDistributionConfig= xgwhDistributionConfigMapper.selectByType(type);
        logger.debug("业绩补助和分销查询实现层");
        return xgwhDistributionConfig;
    }

    @Override
    public boolean update(XgwhDistributionConfig xgwhDistributionConfig) {
        int res  = xgwhDistributionConfigMapper.updateByPrimaryKeySelective(xgwhDistributionConfig);
        logger.debug("业绩补助和分销编辑实现层");
        return res > 0;
    }

    @Override
    public  boolean add(XgwhDistributionConfig xgwhDistributionConfig){
        int res = xgwhDistributionConfigMapper.insertSelective(xgwhDistributionConfig);
        logger.debug("业绩补助和分销添加实现层");
        return  res > 0;
    }
}
