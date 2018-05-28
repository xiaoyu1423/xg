package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IMemberClosureService;
import com.xg.mall.dao.XgwhMemberClosureMapper;
import com.xg.mall.dao.XgwhShopOrderMapper;
import com.xg.mall.po.XgwhMemberClosure;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
@Service
public class MemberClosureServiceImpl implements IMemberClosureService {


    private Logger logger = Logger.getLogger(MemberClosureServiceImpl.class);
    @Autowired
    private XgwhMemberClosureMapper xgwhMemberClosureMapper;
    @Autowired
    private XgwhShopOrderMapper xgwhShopOrderMapper;

    @Override
    public LinkedList selectDescendant(Integer descendant, Integer distance, Integer page) {
        Integer number_page = 20;
        Integer page1 = page - 1;
        Integer page2 = page1 * number_page;
        List<XgwhMemberClosure> list;
        Integer count;
        double count1;
        LinkedList arr = new LinkedList<>();
        if (distance > 2) {
            count = xgwhMemberClosureMapper.b_count(descendant, distance);
            double number = (double) count / number_page;
            count1 = Math.ceil(number);
            if (count1 >= page) {
                list = xgwhMemberClosureMapper.selectDescendant(descendant, distance, page2, number_page);
            } else {
                return arr;
            }
        } else {
            count = xgwhMemberClosureMapper.s_count(descendant, distance);
            double number = (double) count / number_page;
            count1 = Math.ceil(number);
            if (count1 >= page) {
                list = xgwhMemberClosureMapper.selectItDescendant(descendant, distance, page2, number_page);
            } else {
                return arr;
            }
        }
        logger.debug("测试实现层会员团队日志");
        if (list.isEmpty()) {
            return arr;
        }
        arr.add(count1);
        arr.add(list);

        return arr;
    }

    @Override
    public double selectTotal(Integer descendant) {
        //用自己的id 去获取自己的下级
        List<XgwhMemberClosure> list = xgwhMemberClosureMapper.selectByAncestor(descendant);
        //定义一个变长数组
        LinkedList arr = new LinkedList<>();
        //拿出所有下级id
        //初始化钱
        double total = 0;
        //获取自己的所有订单
        double price = xgwhShopOrderMapper.count(descendant);
        //加钱
        total += price;
        //循环自己的下级
        for (XgwhMemberClosure id : list) {
            //获取下级id
            Integer xj_id = id.getDescendant();
            //加自己下级的钱
            double xj_price = xgwhShopOrderMapper.count(xj_id);
            total += xj_price;
        }
        logger.debug("测试实现层总业绩日志");
        return total;
    }
}
