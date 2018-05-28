package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IMemberAddressService;
import com.xg.mall.dao.XgwhAreaMapper;
import com.xg.mall.dao.XgwhMemberAddressMapper;
import com.xg.mall.po.XgwhArea;
import com.xg.mall.po.XgwhMemberAddress;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
@Service
public class MemberAddressServiceImpl implements IMemberAddressService {

    private Logger logger = Logger.getLogger(MemberAddressServiceImpl.class);

    @Autowired
    private XgwhMemberAddressMapper xgwhMemberAddressMapper;
    @Autowired
    private XgwhAreaMapper xgwhAreaMapper;

    //查询所有地址
    @Override
    public List<XgwhMemberAddress> select(XgwhMemberAddress xgwhMemberAddress) {
        List<XgwhMemberAddress> list = xgwhMemberAddressMapper.select(xgwhMemberAddress);
        logger.debug("实现层查询所有地址");
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    //查询单个地址
    @Override
    public XgwhMemberAddress selectById(Integer Id) {
        XgwhMemberAddress xgwhMemberAddress = xgwhMemberAddressMapper.selectByPrimaryKey(Id);
        logger.debug("实现层查询单个地址");
        return xgwhMemberAddress;
    }

    //更新地址
    @Override
    public boolean update(XgwhMemberAddress xgwhMemberAddress) {
        //拿到省市区的名字
        XgwhArea provinces = xgwhAreaMapper.selectNameByPrimaryKey(xgwhMemberAddress.getProvinceVal());
        String province = provinces.getAreaName();
        XgwhArea citys = xgwhAreaMapper.selectByPrimaryKey(xgwhMemberAddress.getCityVal());
        String city = citys.getAreaName();
        XgwhArea countys = xgwhAreaMapper.selectByPrimaryKey(xgwhMemberAddress.getCountyVal());
        String county = countys.getAreaName();
        //设置省市区名字
        xgwhMemberAddress.setProvince(province);
        xgwhMemberAddress.setCity(city);
        xgwhMemberAddress.setCounty(county);
        xgwhMemberAddress.setType((byte) 1);
        xgwhMemberAddress.setUpdateTime(Time.UnixTime());

        //把地址表中其他数据type都改为一般
        List<XgwhMemberAddress> re = xgwhMemberAddressMapper.selectAll();
        int counts = 0;
        for (XgwhMemberAddress res : re) {
            XgwhMemberAddress address = new XgwhMemberAddress();
            address.setId(res.getId());
            address.setType((byte) 0);
            int isUpdate = xgwhMemberAddressMapper.updateByPrimaryKeySelective(address);
            counts = counts + isUpdate;
        }

        int res = xgwhMemberAddressMapper.updateByPrimaryKeySelective(xgwhMemberAddress);
        logger.debug("实现层更新地址");
        return res > 0 && counts == re.size();
    }

    //添加地址
    @Override
    public boolean add(XgwhMemberAddress xgwhMemberAddress) {

        //拿到省市区的名字
        XgwhArea provinces = xgwhAreaMapper.selectNameByPrimaryKey(xgwhMemberAddress.getProvinceVal());
        String province = provinces.getAreaName();
        XgwhArea citys = xgwhAreaMapper.selectByPrimaryKey(xgwhMemberAddress.getCityVal());
        String city = citys.getAreaName();
        XgwhArea countys = xgwhAreaMapper.selectByPrimaryKey(xgwhMemberAddress.getCountyVal());
        String county = countys.getAreaName();
        //设置省市区名字
        xgwhMemberAddress.setProvince(province);
        xgwhMemberAddress.setCity(city);
        xgwhMemberAddress.setCounty(county);
        xgwhMemberAddress.setType((byte) 1);
        xgwhMemberAddress.setAddTime(Time.UnixTime());
        //把地址表中其他数据type都改为一般
        List<XgwhMemberAddress> re = xgwhMemberAddressMapper.selectAll();
        int count = 0;
        for (XgwhMemberAddress res : re) {
            XgwhMemberAddress address = new XgwhMemberAddress();
            address.setId(res.getId());
            address.setType((byte) 0);
            int isUpdate = xgwhMemberAddressMapper.updateByPrimaryKeySelective(address);
            count = count + isUpdate;
        }
        //收货地址入一条数据
        int ress = xgwhMemberAddressMapper.insertSelective(xgwhMemberAddress);
        logger.debug("实现层添加地址");
        return ress > 0 && count == re.size();
    }

    //删除地址
    @Override
    public boolean delete(Integer Id) {
        int res = xgwhMemberAddressMapper.deleteByPrimaryKey(Id);
        logger.debug("实现层删除地址");
        return res > 0;
    }

    @Override
    public boolean updateDefault(Integer Id) {
        XgwhMemberAddress xgwhMemberAddress = xgwhMemberAddressMapper.selectByPrimaryKey(Id);
        //把地址表中其他数据type都改为一般
        List<XgwhMemberAddress> re = xgwhMemberAddressMapper.selectAll();
        int counts = 0;
        for (XgwhMemberAddress res : re) {
            XgwhMemberAddress address = new XgwhMemberAddress();
            address.setId(res.getId());
            address.setType((byte) 0);
            int isUpdate = xgwhMemberAddressMapper.updateByPrimaryKeySelective(address);
            counts = counts + isUpdate;
        }
        if (xgwhMemberAddress != null) {
            XgwhMemberAddress res = new XgwhMemberAddress();
            res.setType((byte) 1);
            res.setId(Id);
            int rs = xgwhMemberAddressMapper.updateByPrimaryKeySelective(res);
            if (rs > 0 && counts == re.size()) {
                logger.debug("实现层编辑默认地址");
                return true;
            }
        }
         return false;
    }
}
