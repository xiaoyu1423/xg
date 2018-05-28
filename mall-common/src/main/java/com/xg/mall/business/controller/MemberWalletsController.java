package com.xg.mall.business.controller;

import com.xg.mall.business.service.IFyqService;
import com.xg.mall.po.XgwhMemberWallet;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MemberWalletsController {
    Logger logger = Logger.getLogger(MemberWalletsController.class);
    @Autowired
    private com.xg.mall.service.IMemberWalletsService iMemberWalletsService;
    @Autowired
    private IFyqService iFyqService;

    //会员钱包列表
    @RequestMapping(value = "/member-wallets/{memberId}",method = RequestMethod.GET)
    public ResponseBody selectWalletsByMemberId(@PathVariable("memberId") Integer memberId){
        logger.info("会员钱包列表日志");
        List<XgwhMemberWallet> list = iMemberWalletsService.selectWalletsByMemberId(memberId);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }


    //会员钱包
    @RequestMapping(value = "/member-wallet/{memberId}/{walletId}", method = RequestMethod.GET)
    public ResponseBody Fyq(@PathVariable("memberId") Integer memberId, @PathVariable("walletId") Integer walletId) {
        logger.info("会员钱包");
        XgwhMemberWallet res = iFyqService.Fyq(memberId, walletId);
        return ResponseUtil.responseBody(res, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
