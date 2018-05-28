package com.xg.mall.business.service.impl;

import com.xg.mall.dao.XgwhMemberSecrecyMapper;
import com.xg.mall.po.XgwhMemberSecrecy;
import com.xg.mall.business.service.IMemberSecrecyBackService;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MemberSecrecyBackServiceImpl implements IMemberSecrecyBackService {
    private Logger logger = Logger.getLogger(MemberSecrecyBackServiceImpl.class);
    @Autowired
    private XgwhMemberSecrecyMapper xgwhMemberSecrecyMapper;

    @Override
    public List<XgwhMemberSecrecy> selectSecrecy(XgwhMemberSecrecy xgwhMemberSecrecy){
        List<XgwhMemberSecrecy> list = xgwhMemberSecrecyMapper.selectSecrecy(xgwhMemberSecrecy);
        if(list.isEmpty()){
            return Collections.emptyList();
        }
        logger.debug("查询会员保密资料列表");
        return list;
    }

    @Override
    public XgwhMemberSecrecy selectById(Integer id){
        XgwhMemberSecrecy res = xgwhMemberSecrecyMapper.selectByPrimaryKey(id);
        logger.debug("根据ID查询会员保密资料");
        return res;
    }

    @Override
    public boolean udpateSecrecy(XgwhMemberSecrecy xgwhMemberSecrecy){
        xgwhMemberSecrecy.setUpdateTime(Time.UnixTime());
        int isUpdate = xgwhMemberSecrecyMapper.updateByPrimaryKeySelective(xgwhMemberSecrecy);
        logger.debug("修改会员保密资料");
        return isUpdate > 0;
    }

    @Override
    public boolean addSecrecy(XgwhMemberSecrecy xgwhMemberSecrecy){
        xgwhMemberSecrecy.setAddTime(Time.UnixTime());
        int isAdd = xgwhMemberSecrecyMapper.insertSelective(xgwhMemberSecrecy);
        logger.debug("添加会员保密资料");
        return isAdd > 0;
    }
}
