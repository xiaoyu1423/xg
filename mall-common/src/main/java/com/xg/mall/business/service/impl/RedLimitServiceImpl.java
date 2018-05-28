package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IRedLimitService;
import com.xg.mall.dao.XgwhRedLimitMapper;
import com.xg.mall.po.XgwhRedLimit;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RedLimitServiceImpl implements IRedLimitService {
    private Logger logger = Logger.getLogger(RedLimitServiceImpl.class);
    @Autowired
    private XgwhRedLimitMapper xgwhRedLimitMapper;

    //业绩补助设置列表
    @Override
    public List<XgwhRedLimit> selectAll(){
        List<XgwhRedLimit> list = xgwhRedLimitMapper.selectAll();
        for (XgwhRedLimit time : list) {
            Integer update_time = time.getUpdateTime();
            String strTime = Time.StrTime(update_time);
            time.setStrTime(strTime);
        }
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        logger.debug("查询业绩补助列表");
        return  list;
    }

    //根据ID查询业绩补助设置
    @Override
    public XgwhRedLimit selectById(Integer id){
        XgwhRedLimit res = xgwhRedLimitMapper.selectByPrimaryKey(id);
        logger.debug("根据ID查询业绩补助设置");
        return res;
    }

    //业绩补助设置添加
    @Override
    public boolean add(XgwhRedLimit xgwhRedLimit){
        xgwhRedLimit.setAddTime(Time.UnixTime());
        xgwhRedLimit.setUpdateTime(Time.UnixTime());
        int isAdd = xgwhRedLimitMapper.insertSelective(xgwhRedLimit);
        logger.debug("添加业绩补助设置");
        return isAdd > 0;
    }

    //业绩补助设置删除
    @Override
    public boolean delete(Integer id){
        int isDel = xgwhRedLimitMapper.deleteByPrimaryKey(id);
        logger.debug("删除业绩补助设置");
        return  isDel > 0;
    }

    //业绩补助设置修改
    @Override
    public boolean update(XgwhRedLimit xgwhRedLimit){
        xgwhRedLimit.setUpdateTime(Time.UnixTime());
        int isUpdate = xgwhRedLimitMapper.updateByPrimaryKeySelective(xgwhRedLimit);
        logger.debug("修改业绩补助设置");
        return isUpdate > 0;
    }

}
