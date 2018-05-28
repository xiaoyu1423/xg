package com.xg.mall.business.service.impl;

import com.xg.mall.business.service.IMemberService;
import com.xg.mall.dao.*;
import com.xg.mall.po.*;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import com.xg.utils.Time;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {
    private Logger logger = Logger.getLogger(MemberSecrecyServiceImpl.class);
    @Autowired
    //注入会员Mapper
    private XgwhMemberMapper xgwhMemberMapper;
    @Autowired
    private XgwhMemberClosureMapper xgwhMemberClosureMapper;
    @Autowired
    private XgwhMemberSecrecyMapper xgwhMemberSecrecyMapper;
    @Autowired
    private XgwhMemberWalletMapper xgwhMemberWalletMapper;
    @Autowired
    private XgwhWalletMapper xgwhWalletMapper;


    @Override
    public boolean add(XgwhMember xgwhMember) {
        if(xgwhMember == null || xgwhMember.getMemberUsername().isEmpty()){
            return false;
        }
        //入会员表
        xgwhMember.setAddTime(Time.UnixTime());
        int res = xgwhMemberMapper.insertSelective(xgwhMember);
        if(res > 0){
           //入保密资料表
            XgwhMemberSecrecy xgwhMemberSecrecy = new XgwhMemberSecrecy();
            xgwhMemberSecrecy.setMemberId(xgwhMember.getMemberId());
            xgwhMemberSecrecy.setMemberTrueName(xgwhMember.getMemberTrueName());
            xgwhMemberSecrecy.setMemberMobile(xgwhMember.getMemberMobile());
            xgwhMemberSecrecy.setMemberIdcard(xgwhMember.getMemberIdcard());
            xgwhMemberSecrecy.setMemberBankName(xgwhMember.getMemberBankName());
            xgwhMemberSecrecy.setMemberBankNo(xgwhMember.getMemberBankNo());
            xgwhMemberSecrecy.setMemberAliypay(xgwhMember.getMemberAliypay());
            xgwhMemberSecrecy.setAddTime(Time.UnixTime());
            int secrecy = xgwhMemberSecrecyMapper.insertSelective(xgwhMemberSecrecy);
            //入会员钱包表
            List<XgwhWallet> re = xgwhWalletMapper.select();
            //然后循环取出来钱包wallet_id
            int sums = 0;
            for (XgwhWallet ress : re){
                XgwhMemberWallet xgwhMemberWallet = new XgwhMemberWallet();
                xgwhMemberWallet.setMemberWalletName(xgwhMember.getMemberWalletName());
                xgwhMemberWallet.setMemberWalletMoney(xgwhMember.getMemberWalletMoney());
                xgwhMemberWallet.setMemberId(xgwhMember.getMemberId());
                xgwhMemberWallet.setWalletId(ress.getWalletId());
                xgwhMemberWallet.setAddTime(Time.UnixTime());
                int wallet = xgwhMemberWalletMapper.insertSelective(xgwhMemberWallet);
                sums = sums + wallet;
            }
            logger.debug("会员实现层添加会员");
            return secrecy > 0 && sums == re.size();
        }
        return false;
    }

    @Override
    public ResponseBody update(XgwhMember xgwhMember) {
        if (xgwhMember.getMemberId().equals("")) {
            return ResponseUtil.responseBody(false, ExceptionCode.EDIT_MEMBER_SECRECY_ERROR.getMsg(), ExceptionCode.EDIT_MEMBER_SECRECY_ERROR.getCode());
        }
        //修改会员表中会员信息
        xgwhMember.setUpdateTime(Time.UnixTime());
        int res = xgwhMemberMapper.updateByPrimaryKeySelective(xgwhMember);

        //修改保密资料
        XgwhMemberSecrecy xgwhMemberSecrecy = new XgwhMemberSecrecy();
        xgwhMemberSecrecy.setMemberId(xgwhMember.getMemberId());
        xgwhMemberSecrecy.setMemberTrueName(xgwhMember.getMemberTrueName());
        xgwhMemberSecrecy.setMemberMobile(xgwhMember.getMemberMobile());
        xgwhMemberSecrecy.setMemberIdcard(xgwhMember.getMemberIdcard());
        xgwhMemberSecrecy.setMemberBankName(xgwhMember.getMemberBankName());
        xgwhMemberSecrecy.setMemberBankNo(xgwhMember.getMemberBankNo());
        xgwhMemberSecrecy.setMemberAliypay(xgwhMember.getMemberAliypay());
        xgwhMemberSecrecy.setUpdateTime(Time.UnixTime());
        int secrecy = xgwhMemberSecrecyMapper.updateBymemberIdSelective(xgwhMemberSecrecy);
        //修改会员钱包
        XgwhMemberWallet aa = new XgwhMemberWallet();
//        aa.setMemberId(xgwhMember.getMemberId());
        aa.setMemberWalletMoney(xgwhMember.getShopIncome());
        Integer pk = xgwhMemberWalletMapper.selectPrimaryKEY(xgwhMember.getMemberId(), 1).getMemberWalletId();
        aa.setMemberWalletId(pk);
        int shop_income = xgwhMemberWalletMapper.updateByPrimaryKeySelective(aa);

        XgwhMemberWallet bb = new XgwhMemberWallet();
//        bb.setMemberId(xgwhMember.getMemberId());
        bb.setMemberWalletMoney(xgwhMember.getFyq());
        Integer pks = xgwhMemberWalletMapper.selectPrimaryKEY(xgwhMember.getMemberId(), 2).getMemberWalletId();
        bb.setMemberWalletId(pks);
        int fyq = xgwhMemberWalletMapper.updateByPrimaryKeySelective(bb);

        logger.debug("会员实现层添加会员");
        if (res > 0 && secrecy > 0 && shop_income > 0 && fyq > 0) {
            return ResponseUtil.responseBody(true, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
        }
        return ResponseUtil.responseBody(false, ExceptionCode.EDIT_MEMBER_ERROR.getMsg(), ExceptionCode.EDIT_MEMBER_ERROR.getCode());
    }

    @Override
    public boolean delete(Integer memberId) {
        List<XgwhMemberClosure> list = xgwhMemberClosureMapper.selectByAncestor(memberId);
        if(list.isEmpty()){
            int res = xgwhMemberMapper.deleteByPrimaryKey(memberId);
            logger.debug("会员实现层删除");
            return res > 0;
        }
        return  false;
    }

    @Override
    public LinkedList select(XgwhMember xgwhMember) {

        String StrAddTime = xgwhMember.getStrAddTime();
        String StrEndTime = xgwhMember.getStrEndTime();
        if (StrAddTime != "" && StrAddTime != null && StrEndTime != "" && StrEndTime != null) {
            Integer time1 = Time.UnixTime(StrAddTime + " " + "0:0:0");
            Integer time2 = Time.UnixTime(StrEndTime + " " + "23:59:59");
            xgwhMember.setAddTime(time1);
            xgwhMember.setIntTime(time2);
        }

        LinkedList arr = new LinkedList<>();
        Integer page = xgwhMember.getPage();
        Integer pageNum = 20;
        Integer count = xgwhMemberMapper.count(xgwhMember);
        if (count == null) {
            count = 0;
        }
        double p = Math.ceil(count / (double) pageNum);
        if (p < page) {
            page = 1;
        }
        if (page == null) {
            page = 1;
        }
        if (page < 1) {
            page = 1;
        }
        xgwhMember.setPageNum(pageNum);
        page = page - 1;
        page = page * 20;
        xgwhMember.setPage(page);



        List<XgwhMember> list = xgwhMemberMapper.select(xgwhMember);
        for (XgwhMember time : list) {
            Integer add_time = time.getAddTime();
            String sd = Time.StrTime(add_time);
            time.setStrTime(sd);
        }
        if (list.isEmpty()) {
            list = Collections.emptyList();
        }
        arr.add(p);
        arr.add(list);
        logger.debug("会员实现层查询");
        return arr;
    }

    @Override
    public XgwhMember selectById(Integer id) {
         XgwhMember xgwhMember = xgwhMemberMapper.selectByPrimaryKey(id);
        //查询会员保密资料
        XgwhMemberSecrecy aa = xgwhMemberSecrecyMapper.selectByMemberId(id);
        xgwhMember.setMemberTrueName(aa.getMemberTrueName());
        xgwhMember.setMemberMobile(aa.getMemberMobile());
        xgwhMember.setMemberIdcard(aa.getMemberIdcard());
        xgwhMember.setMemberBankName(aa.getMemberBankName());
        xgwhMember.setMemberBankNo(aa.getMemberBankNo());
        xgwhMember.setMemberAliypay(aa.getMemberAliypay());
        //查询余额
        Integer memberId = id;
        XgwhMemberWallet bb = xgwhMemberWalletMapper.selectShopincome(memberId, 1);
        xgwhMember.setShopIncome(bb.getMemberWalletMoney());

        // 查询非遗券
        XgwhMemberWallet cc = xgwhMemberWalletMapper.selectFyq(memberId, 2);
        xgwhMember.setFyq(cc.getMemberWalletMoney());

        logger.debug("会员实现层单个查询");
         return xgwhMember;
    }
}
