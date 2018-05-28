package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhAccess;
import com.xg.mall.po.XgwhRoleAccess;
import com.xg.mall.business.service.IRoleAccessService;
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
public class RoleAccessController {
    private Logger logger = Logger.getLogger(RoleAccessController.class);
    @Autowired
    private IRoleAccessService iRoleAccessService;
    //角色权限查询
    @RequestMapping(value = "role-access/{roleId}",method = RequestMethod.GET)
    public ResponseBody select(@PathVariable("roleId") Integer roleId){
        logger.info("角色权限控制层查询日志");
        List<XgwhAccess> list = iRoleAccessService.select(roleId);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //角色权限删除
    @RequestMapping(value = "role-access/{roleId}",method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable("roleId") Integer roleId){
        logger.info("角色权限控制层删除日志");
        boolean res = iRoleAccessService.delete(roleId);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());

    }
    //角色权限添加
    @RequestMapping(value = "role-access",method = RequestMethod.POST)
    public ResponseBody add(XgwhRoleAccess xgwhRoleAccess){
        logger.info("角色权限控制层添加日志");
        boolean res = iRoleAccessService.add(xgwhRoleAccess);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //角色权限编辑
    @RequestMapping(value = "role-access",method = RequestMethod.PUT)
    public ResponseBody update(XgwhRoleAccess xgwhRoleAccess){
        logger.info("角色权限控制层编辑日志");
        boolean res = iRoleAccessService.update(xgwhRoleAccess);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());


    }
}
