package com.xg.mall.business.service;

import com.xg.mall.po.XgwhShopSetting;

import java.util.List;

public interface IShopSettingService {
    List<XgwhShopSetting> searchXgwhShopSetting(XgwhShopSetting xgwhShopSetting);

    XgwhShopSetting searchXgwhShopSettingById(Integer id);

    boolean addXgwhShopSetting(XgwhShopSetting xgwhShopSetting);

    boolean updateXgwhShopSetting(XgwhShopSetting xgwhShopSetting);

}
