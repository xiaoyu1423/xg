package com.xg.mall.business.service;

import com.xg.mall.po.XgwhMemberAddress;

import java.util.List;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
public interface IMemberAddressService {

    //查询所有地址
    List<XgwhMemberAddress> select(XgwhMemberAddress xgwhMemberAddress);
    //用id查询某个地址
    XgwhMemberAddress selectById(Integer Id);
    //更新地址
    boolean update(XgwhMemberAddress xgwhMemberAddress);
    //添加地址
    boolean add(XgwhMemberAddress xgwhMemberAddress);
    //删除地址
    boolean delete(Integer Id);
//    //更新默认地址
    boolean updateDefault(Integer Id);

}
