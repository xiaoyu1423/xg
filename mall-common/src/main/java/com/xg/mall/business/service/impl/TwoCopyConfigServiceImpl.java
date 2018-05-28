package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.ITwoCopyConfigService;
import com.xg.mall.dao.XgwhTwoCopyConfigMapper;
import com.xg.mall.po.XgwhTwoCopyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xg.utils.Time;
import java.util.Collections;
import java.util.List;

@Service
public class TwoCopyConfigServiceImpl implements ITwoCopyConfigService {
    @Autowired
    private XgwhTwoCopyConfigMapper xgwhTwoCopyConfigMapper;

    //添加设置
    @Override
    public boolean add(XgwhTwoCopyConfig xgwhTwoCopyConfig){
        List<XgwhTwoCopyConfig> list = xgwhTwoCopyConfigMapper.selectAll();
        if(list.size() > 0){
            return  false;
        }
        xgwhTwoCopyConfig.setAddTime(Time.UnixTime());
        int isAdd = xgwhTwoCopyConfigMapper.insertSelective(xgwhTwoCopyConfig);
        return isAdd > 0;
    }

    //修改设置
    @Override
    public boolean update(XgwhTwoCopyConfig xgwhTwoCopyConfig){
        xgwhTwoCopyConfig.setUpdateTime(Time.UnixTime());
        int isUpdate = xgwhTwoCopyConfigMapper.updateByPrimaryKeySelective(xgwhTwoCopyConfig);
        return  isUpdate > 0;
    }

    //列表
    @Override
    public List<XgwhTwoCopyConfig> selectAll(){
        List<XgwhTwoCopyConfig> list = xgwhTwoCopyConfigMapper.selectAll();
        if(list.isEmpty()){
            return Collections.emptyList();
        }
            return list;
    }

}
