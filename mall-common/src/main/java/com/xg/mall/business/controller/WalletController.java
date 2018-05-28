package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhWallet;
import com.xg.mall.business.service.IWalletService;
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
@RequestMapping("/manage")
public class WalletController {
    private Logger logger = Logger.getLogger(WalletController.class);
    @Autowired
    private IWalletService iWalletService;

    @RequestMapping(value = "/wallet",method = RequestMethod.GET)
    public ResponseBody select(){
        logger.info("钱包控制层查询");
        List<XgwhWallet> list = iWalletService.select();
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/wallet/{walletId}",method = RequestMethod.GET )
    public ResponseBody selectByPrimaryKey(@PathVariable("walletId") Integer walletId){
        logger.info("钱包控制层查询单个");
        XgwhWallet xgwhWallet = iWalletService.selectByPrimaryKey(walletId);
        System.out.println(xgwhWallet);
        return ResponseUtil.responseBody(xgwhWallet,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    @RequestMapping(value = "/wallet",method = RequestMethod.POST)
    public ResponseBody add(XgwhWallet xgwhWallet){
        logger.info("钱包控制层添加");
        boolean isAdd = iWalletService.add(xgwhWallet);
        return ResponseUtil.responseBody(isAdd,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/wallet/{walletId}",method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable("walletId") Integer walletId){
        logger.info("钱包控制层删除");
        boolean isDel = iWalletService.delete(walletId);
        return ResponseUtil.responseBody(isDel,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/wallet",method = RequestMethod.PUT)
    public ResponseBody update(XgwhWallet xgwhWallet){
        logger.info("钱包控制层更新");
        boolean isUpdate = iWalletService.update(xgwhWallet);
        return ResponseUtil.responseBody(isUpdate,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }


}
