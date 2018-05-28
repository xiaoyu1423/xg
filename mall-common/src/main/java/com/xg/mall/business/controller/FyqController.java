package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhMemberWallet;
import com.xg.mall.business.service.IFyqService;
import com.xg.utils.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xg.utils.ResponseUtil;
import com.xg.mall.vo.ResponseBody;

@RestController
@RequestMapping("/")
public class FyqController {
    @Autowired
    private IFyqService iFyqService;

    @RequestMapping(value = "/fyq/{memberId}/{walletId}",method = RequestMethod.GET)
    public ResponseBody Fyq(@PathVariable("memberId") Integer memberId, @PathVariable("walletId") Integer walletId){
        XgwhMemberWallet res = iFyqService.Fyq(memberId,walletId);
        return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
