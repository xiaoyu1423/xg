package com.xg.mall.dao;

import com.xg.mall.po.XgwhMemberAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XgwhMemberAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XgwhMemberAddress record);

    int insertSelective(XgwhMemberAddress record);

    XgwhMemberAddress selectByPrimaryKey(Integer id);

    List<XgwhMemberAddress> select(XgwhMemberAddress xgwhMemberAddress);

    List<XgwhMemberAddress> selectAll();

    int updateByPrimaryKeySelective(XgwhMemberAddress record);

    int updateByPrimaryKey(@Param("id") Integer id ,@Param("type") Byte type);


}