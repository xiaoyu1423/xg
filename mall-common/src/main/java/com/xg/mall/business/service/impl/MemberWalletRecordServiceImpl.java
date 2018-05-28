package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IMemberWalletRecordService;
import com.xg.mall.dao.XgwhRecordMapper;
import com.xg.mall.po.XgwhRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MemberWalletRecordServiceImpl implements IMemberWalletRecordService {
    @Autowired
    private XgwhRecordMapper xgwhRecordMapper;

    @Override
    public List<XgwhRecord> selectByMemberId(Integer memberId) {
        List<XgwhRecord> res = xgwhRecordMapper.selectByMemberId(memberId);
        if (res.isEmpty()) {
            return Collections.emptyList();
        }
        return res;
    }

    @Override
    public List<XgwhRecord> selectByMemberIdWalletId(Integer memberId, Integer recordType) {
        List<XgwhRecord> res = xgwhRecordMapper.selectByMemberIdWalletId(memberId, recordType);
        if (res.isEmpty()) {
            return Collections.emptyList();
        }
        return res;
    }


}
