package com.xg.mall.dao;

import com.xg.mall.po.XgwhRoleAccess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XgwhRoleAccessMapper {
    //id删除
    int deleteByPrimaryKey(Integer id);
    //roleid删除
    int deleteRoleId(Integer roleId);
    //accessid删除
    int deleteAccessId(Integer accessId);
    int deleteByRoleIdAccessId(@Param("roleId") Integer roleId,@Param("accessId") Integer accessId);

    int insert(XgwhRoleAccess record);

    int insertSelective(XgwhRoleAccess record);

    XgwhRoleAccess selectByPrimaryKey(Integer id);
    List<XgwhRoleAccess>select(Integer roleId);
    List<XgwhRoleAccess>selectByAccessId(Integer accessId);
    int updateByPrimaryKeySelective(XgwhRoleAccess record);

    int updateByPrimaryKey(XgwhRoleAccess record);
}