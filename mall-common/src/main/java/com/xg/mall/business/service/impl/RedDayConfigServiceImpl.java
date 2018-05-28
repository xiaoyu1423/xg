package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IRedDayConfigService;
import com.xg.mall.dao.XgwhRedDayConfigMapper;
import com.xg.mall.po.XgwhRedDayConfig;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RedDayConfigServiceImpl implements IRedDayConfigService {
    private Logger logger = Logger.getLogger(RedDayConfigServiceImpl.class);
    @Autowired
    private XgwhRedDayConfigMapper xgwhRedDayConfigMapper;

    //日分红设置查询
    @Override
    public List<XgwhRedDayConfig> selectAll(){
        List<XgwhRedDayConfig> list = xgwhRedDayConfigMapper.selectAll();
        for (XgwhRedDayConfig time : list) {
            Integer addTime = time.getAddTime();
            String strTime = Time.StrTime(addTime);
            time.setStrTime(strTime);
        }
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        logger.debug("日分红列表查询");
        return list;
    }

    //日分红设置查询
    @Override
    public XgwhRedDayConfig selectByPrimaryKey(Integer id){
        XgwhRedDayConfig xgwhRedDayConfig = xgwhRedDayConfigMapper.selectByPrimaryKey(id);
        logger.debug("根据ID查询日分红设置");
        return xgwhRedDayConfig;
    }

    //日分红设置添加
    @Override
    public boolean add(XgwhRedDayConfig xgwhRedDayConfig){
        xgwhRedDayConfig.setAddTime(Time.UnixTime());
        int isAdd = xgwhRedDayConfigMapper.insertSelective(xgwhRedDayConfig);
        logger.debug("日分红设置添加");
        return  isAdd > 0;
    }

    //日分红设置修改
    @Override
    public boolean update(XgwhRedDayConfig xgwhRedDayConfig){
        int isUpdate = xgwhRedDayConfigMapper.updateByPrimaryKeySelective(xgwhRedDayConfig);
        logger.debug("日分红设置修改");
        return  isUpdate > 0;
    }

}
