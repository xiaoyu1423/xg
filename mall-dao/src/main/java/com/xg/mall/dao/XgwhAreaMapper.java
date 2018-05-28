package com.xg.mall.dao;

import com.xg.mall.po.XgwhArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XgwhAreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(XgwhArea record);

    int insertSelective(XgwhArea record);

    XgwhArea selectByPrimaryKey(@Param("areaId") Integer areaId);

    XgwhArea selectNameByPrimaryKey(@Param("areaId") Integer areaId);

    List<XgwhArea> selectAreas(@Param("areaParentId") Integer areaParentId);

    int updateByPrimaryKeySelective(XgwhArea record);

    int updateByPrimaryKey(XgwhArea record);


}