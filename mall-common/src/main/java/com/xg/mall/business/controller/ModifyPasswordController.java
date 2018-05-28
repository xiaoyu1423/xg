package com.xg.mall.business.controller;

import com.xg.mall.business.service.IModifyPasswordService;
import com.xg.mall.po.XgwhMember;
import com.xg.mall.vo.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ModifyPasswordController {
    @Autowired
    private IModifyPasswordService iModifyPasswordService;
    //修改密码
    @RequestMapping(value = "/modify-password",method = RequestMethod.PUT)
    public ResponseBody update(XgwhMember xgwhMember) {
        ResponseBody res = iModifyPasswordService.update(xgwhMember);
        return res;
    }


}
