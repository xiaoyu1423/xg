package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhMemberWallet;
import com.xg.mall.business.service.IMemberWalletService;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.xg.mall.vo.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class MemberWalletController {
    private Logger logger = Logger.getLogger(MemberWalletController.class);
    @Autowired
    private IMemberWalletService iMemberWalletService;

    @RequestMapping(value = "/member-wallet",method = RequestMethod.GET)
    public ResponseBody select(){
        logger.info("查询会员钱包列表");
        List<XgwhMemberWallet> list = iMemberWalletService.select();
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/member-wallet",method = RequestMethod.POST)
    public ResponseBody add(XgwhMemberWallet xgwhMemberWallet){
        logger.info("添加会员钱包");
        boolean isAdd = iMemberWalletService.add(xgwhMemberWallet);
        return ResponseUtil.responseBody(isAdd,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/member-wallet/{memberWalletId}",method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable("memberWalletId") Integer memberWalletId){
        logger.info("删除会员钱包");
        boolean isDel = iMemberWalletService.delete(memberWalletId);
        return  ResponseUtil.responseBody(isDel,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/member-wallet",method = RequestMethod.PUT)
    public ResponseBody update(XgwhMemberWallet xgwhMemberWallet){
        logger.info("修改会员钱包");
        boolean isUpdate = iMemberWalletService.update(xgwhMemberWallet);
        return  ResponseUtil.responseBody(isUpdate,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
