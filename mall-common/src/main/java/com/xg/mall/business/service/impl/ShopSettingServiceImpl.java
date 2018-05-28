package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IShopSettingService;
import com.xg.mall.dao.XgwhShopSettingMapper;
import com.xg.mall.po.XgwhShopSetting;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShopSettingServiceImpl implements IShopSettingService {
    private Logger logger = Logger.getLogger(ShopSettingServiceImpl.class);
    @Autowired
    private XgwhShopSettingMapper xgwhShopSettingMapper;

    //查询商城设置列表
    public List<XgwhShopSetting> searchXgwhShopSetting(XgwhShopSetting xgwhShopSetting) {
        List<XgwhShopSetting> list = xgwhShopSettingMapper.selectAll();
        for (XgwhShopSetting time : list) {
            Integer updateTime = time.getUpdateTime();
            String strTime = Time.StrTime(updateTime);
            time.setStrTime(strTime);
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        logger.debug("查询商城设置列表");
        return list;
    }

    //根据ID查询商城设置
    @Override
    public XgwhShopSetting searchXgwhShopSettingById(Integer id) {
        XgwhShopSetting xgwhShopSetting = xgwhShopSettingMapper.selectByPrimaryKey(id);
        logger.debug("根据ID查询商城设置");
        return xgwhShopSetting;
    }

    //添加商城设置
    @Override
    public boolean addXgwhShopSetting(XgwhShopSetting xgwhShopSetting) {
        List<XgwhShopSetting> list = xgwhShopSettingMapper.selectAll();
        if (list.size() > 0) {
            return false;
        }
        xgwhShopSetting.setAddTime(Time.UnixTime());
        int count = xgwhShopSettingMapper.insertSelective(xgwhShopSetting);
        logger.debug("添加商城设置");
        return count > 0;
    }

    //修改商城设置
    @Override
    public boolean updateXgwhShopSetting(XgwhShopSetting xgwhShopSetting) {
        xgwhShopSetting.setUpdateTime(Time.UnixTime());
        int count = xgwhShopSettingMapper.updateByPrimaryKeySelective(xgwhShopSetting);
        logger.debug("修改商城设置");
        return count > 0;
    }
}
