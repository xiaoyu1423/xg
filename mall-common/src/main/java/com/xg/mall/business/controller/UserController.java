package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhUser;
import com.xg.mall.po.XgwhUserRole;
import com.xg.mall.business.service.IUserService;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private IUserService iUserService;

    //查询所有用户
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public ResponseBody select(){
        logger.info("管理员控制层查询");
        List<XgwhUser> list = iUserService.select();
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //单个查询
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ResponseBody selectByPrimaryKey(@PathVariable("id") Integer id){
        logger.info("管理员控制层单个查询");
        XgwhUser xgwhUser = iUserService.selectByPrimaryKey(id);
        return ResponseUtil.responseBody(xgwhUser,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //添加用户
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseBody add(XgwhUser xgwhUser){
        logger.info("管理员控制层添加");
        boolean res = iUserService.add(xgwhUser);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //删除用户
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable("id") Integer id){
        logger.info("管理员控制层删除");
        boolean res = iUserService.delete(id);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //更新用户
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ResponseBody update(XgwhUser xgwhUser){
        logger.info("管理员控制层更新");
        boolean res = iUserService.update(xgwhUser);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //编辑用户角色
    @RequestMapping(value = "/update-user-role",method = RequestMethod.PUT)
    public ResponseBody updateUserRole(@RequestBody List<XgwhUserRole> list){
        System.out.println(list);
        logger.info("管理员和角色控制层编辑");
        boolean res = iUserService.updateUserRole(list);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
