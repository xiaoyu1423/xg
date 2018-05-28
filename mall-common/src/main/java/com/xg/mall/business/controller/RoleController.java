package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhRole;
import com.xg.mall.po.XgwhRoleAccess;
import com.xg.mall.business.service.IRoleService;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/manage")
public class RoleController {
    private Logger logger = Logger.getLogger(RoleController.class);
    @Autowired
    private IRoleService iRoleService;

    //查询角色
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResponseBody select() {
        logger.info("角色控制层查询");
        List<XgwhRole> list = iRoleService.select();
        return ResponseUtil.responseBody(list, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //单个角色
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public ResponseBody selectByPrimaryKey(@PathVariable("id") Integer id) {
        logger.info("单个角色控制层查询");
        XgwhRole xgwhRole = iRoleService.selectByPrimaryKey(id);
        return ResponseUtil.responseBody(xgwhRole, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //添加角色
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public ResponseBody add(XgwhRole xgwhRole) {
        logger.info("单个角色控制层添加");
        boolean restult = iRoleService.add(xgwhRole);
        return ResponseUtil.responseBody(restult, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //修改角色
    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    public ResponseBody update(XgwhRole xgwhRole) {
        logger.info("单个角色控制层修改");
        boolean restult = iRoleService.update(xgwhRole);
        return ResponseUtil.responseBody(restult,ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //角色删除
    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable("id")Integer id) {
        logger.info("单个角色控制层删除");
        boolean res = iRoleService.delete(id);
        return ResponseUtil.responseBody(res, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //角色和权限编辑
    @RequestMapping(value = "/update-role-access",method = RequestMethod.PUT)
    public ResponseBody updateRoleAccess(@RequestBody List<XgwhRoleAccess> list) {
        logger.info("单个角色和权限控制层编辑");
        boolean res = iRoleService.updateRoleAccess(list);
        return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode()) ;

    }
}
