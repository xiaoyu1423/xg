package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhRole;
import com.xg.mall.po.XgwhUserRole;
import com.xg.mall.business.service.IUserRoleService;
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
@RequestMapping(value = "/manage")
public class UserRoleController {
    private Logger logger = Logger.getLogger(UserRoleController.class);
    @Autowired
    private IUserRoleService iUserRoleService;

    //用用户id去查自己的角色
    @RequestMapping(value = "/user-role/{userId}",method = RequestMethod.GET)
    public ResponseBody select(@PathVariable("userId") Integer userId){
        logger.info("管理员控制层查询日志");
        List<XgwhRole> list =  iUserRoleService.select(userId);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //编辑用户和角色关系
    @RequestMapping(value = "user-role",method = RequestMethod.PUT)
    public ResponseBody update(XgwhUserRole xgwhUserRole){
        logger.info("管理员控制层编辑日志");
        boolean res = iUserRoleService.update(xgwhUserRole);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //角色删除
    @RequestMapping(value = "user-role/{userId}",method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable("userId") Integer userId){
        logger.info("管理员控制层删除日志");
        boolean res = iUserRoleService.delete(userId);
        return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //用户角色关系添加
    @RequestMapping(value = "user-role",method = RequestMethod.POST)
    public ResponseBody add(XgwhUserRole xgwhUserRole){
        logger.info("管理员控制层添加日志");
        boolean res = iUserRoleService.add(xgwhUserRole);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
