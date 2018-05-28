package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IWithdrawDepositService;
import com.xg.mall.dao.XgwhWithdrawDepositMapper;
import com.xg.mall.po.XgwhWithdrawDeposit;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
@Service
public class WithdrawDepositImpl implements IWithdrawDepositService {

    private Logger logger = Logger.getLogger(WithdrawDepositImpl.class);
    //注入提现mapper
    @Autowired
    private XgwhWithdrawDepositMapper xgwhWithdrawDepositMapper;
   //提现搜索
    @Override
    public LinkedList select(XgwhWithdrawDeposit xgwhWithdrawDeposit) {
        String str_add_Time = xgwhWithdrawDeposit.getStrAddTime();
        String strEndTime = xgwhWithdrawDeposit.getStrEndTime();
        if (str_add_Time != "" && str_add_Time != null && strEndTime != "" && strEndTime != null) {
            Integer time1 = Time.UnixTime(str_add_Time + " " + "0:0:0");
            Integer time2 = Time.UnixTime(strEndTime + " " + "23:59:59");
            xgwhWithdrawDeposit.setAddTime(time1);
            xgwhWithdrawDeposit.setIntEndTime(time2);
        }

        LinkedList arr = new LinkedList<>();

        Integer page = xgwhWithdrawDeposit.getPage();
        if (page == null) {
            page = 1;
        }
        if (page < 1) {
            page = 1;
        }
        Integer pageNum = 20;
        xgwhWithdrawDeposit.setPageNum(pageNum);
        Integer count = xgwhWithdrawDepositMapper.count(xgwhWithdrawDeposit);
        if (count == null) {
            count = 0;
        }
        double p = Math.ceil(count / (double) pageNum);
        if (p < page) {
            page = 1;
        }
        page = page - 1;
        page = page * 20;
        xgwhWithdrawDeposit.setPageNum(pageNum);
        xgwhWithdrawDeposit.setPage(page);
        List<XgwhWithdrawDeposit> list = xgwhWithdrawDepositMapper.select(xgwhWithdrawDeposit);
        for (XgwhWithdrawDeposit time : list) {
            Integer updateTime = time.getUpdateTime();
            Integer addTime = time.getAddTime();
            String strAddTime = Time.StrTime(addTime);
            String strUpdateTime = Time.StrTime(updateTime);
            time.setStrAddTime(strAddTime);
            time.setStrUpdateTime(strUpdateTime);
        }
        logger.debug("实现层提现记录查询");
        if (list.isEmpty()) {
            list = Collections.emptyList();
        }
        arr.add(p);
        arr.add(list);
        return arr;
    }
    //提现通过,不通过
    @Override
    public boolean pass(XgwhWithdrawDeposit xgwhWithdrawDeposit) {
        xgwhWithdrawDeposit.setUpdateTime(Time.UnixTime());
        int isPass = xgwhWithdrawDepositMapper.updateByPrimaryKeySelective(xgwhWithdrawDeposit);
        logger.debug("实现层提现记录通过");
        return isPass > 0;
    }

}
