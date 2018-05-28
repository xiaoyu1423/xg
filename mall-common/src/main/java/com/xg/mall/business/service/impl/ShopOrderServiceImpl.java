package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IShopOrderService;
import com.xg.mall.dao.XgwhShopOrderMapper;
import com.xg.mall.po.XgwhShopOrder;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 project: com.xg.mall
 auto : zhaorui
 time : 2018-5-5
 Service ShopOrder
 */
@Service
public class ShopOrderServiceImpl implements IShopOrderService {

    private Logger logger = Logger.getLogger(ShopOrderServiceImpl.class);

    //注入订单Mapper
    @Autowired
    private XgwhShopOrderMapper xgwhShopOrderMapper;

    @Override
    //查询所有订单
    public LinkedList select(XgwhShopOrder xgwhShopOrder) {

        String strOrderTime = xgwhShopOrder.getStrOrderTime();
        String strOrderEndTime = xgwhShopOrder.getStrOrderEndTime();
        if (strOrderTime != "" && strOrderTime != null && strOrderEndTime != "" && strOrderEndTime != null) {
            Integer time1 = Time.UnixTime(strOrderTime + " " + "0:0:0");
            Integer time2 = Time.UnixTime(strOrderEndTime + " " + "23:59:59");
            xgwhShopOrder.setAddTime(time1);
            xgwhShopOrder.setIntOrderEndTime(time2);
        }

        LinkedList arr = new LinkedList<>();

        Integer page = xgwhShopOrder.getPage();
        if (page == null) {
            page = 1;
        }
        if (page < 1) {
            page = 1;
        }
        Integer pageNum = 20;
        xgwhShopOrder.setPageNum(pageNum);
        Integer count = xgwhShopOrderMapper.count_order(xgwhShopOrder);
        if (count == null) {
            count = 0;
        }
        double p = Math.ceil(count / (double) pageNum);
        if (p < page) {
            page = 1;
        }
        page = page - 1;
        page = page * 20;
        xgwhShopOrder.setPageNum(pageNum);
        xgwhShopOrder.setPage(page);
        List<XgwhShopOrder> list = xgwhShopOrderMapper.select(xgwhShopOrder);

        for (XgwhShopOrder time : list) {
            Integer add_time = time.getAddTime();
            String sd = Time.StrTime(add_time);
            time.setStrTime(sd);
        }
        logger.debug("测试实现层查询订单日志");
        if(list.isEmpty()){
            list = Collections.emptyList();
        }
        arr.add(p);
        arr.add(list);
        return arr;

    }

    @Override
    //删除订单
    public boolean delete(Integer orderId) {

        int res = xgwhShopOrderMapper.deleteByPrimaryKey(orderId);
        logger.debug("测试实现层删除订单日志");
        return res > 0;

    }

    @Override
    //获取一条订单详情
    public XgwhShopOrder get(Integer orderId) {

        XgwhShopOrder xgwhShopOrder = xgwhShopOrderMapper.selectByPrimaryKey(orderId);
        logger.debug("测试实现层订单详情日志");
        return xgwhShopOrder;

    }

    @Override
    //手动支付
    public boolean update(XgwhShopOrder xgwhShopOrder) {
        xgwhShopOrder.setOrderStatus(new Byte((byte) 1));
        int  res = xgwhShopOrderMapper.updateByPrimaryKeySelective(xgwhShopOrder);
        logger.debug("测试实现层订单手动支付日志");
        return res > 0;

    }

    @Override
    //统计分析
    public List<XgwhShopOrder> select_statistics(){
        List<XgwhShopOrder> list = xgwhShopOrderMapper.select_statistics();
        if(list.isEmpty()){
            return Collections.emptyList();
        }
            return list;
    }
}
