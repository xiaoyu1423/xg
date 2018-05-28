package com.xg.mall.dao;

import com.xg.mall.po.XgwhUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XgwhUserRoleMapper {
    //id删除
    int deleteByPrimaryKey(Integer id);
    //用户id删除
    int deleteUserRole(Integer userId);
    //角色删除
    int deleteRoleId(Integer roleId);
    //角色id和用户id
    int deleteByUserIdRoleId(@Param("userId") Integer userId,@Param("roleId") Integer roleId);

    int insert(XgwhUserRole record);

    int insertSelective(XgwhUserRole record);

    XgwhUserRole selectByPrimaryKey(Integer id);
    List<XgwhUserRole> selectUserId(Integer userId);
    List<XgwhUserRole> selectRoleId(Integer roleId);

    int updateByPrimaryKeySelective(XgwhUserRole record);

    int updateByPrimaryKey(XgwhUserRole record);
}