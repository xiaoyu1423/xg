package com.xg.mall.business.service;

import com.xg.mall.po.XgwhArea;

import java.util.List;

public interface IAreaService {
    List<XgwhArea> selectAreas(Integer areaParentId);
}
