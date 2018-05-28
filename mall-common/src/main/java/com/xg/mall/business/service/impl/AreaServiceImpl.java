package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IAreaService;
import com.xg.mall.dao.XgwhAreaMapper;
import com.xg.mall.po.XgwhArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private XgwhAreaMapper xgwhAreaMapper;

    @Override
    public List<XgwhArea> selectAreas(Integer areaParentId) {
        if (areaParentId > 0) {
            List<XgwhArea> list = xgwhAreaMapper.selectAreas(areaParentId);
            if (list.isEmpty()) {
                return Collections.emptyList();
            }
            return list;
        } else {
            return Collections.emptyList();
        }
    }

}
