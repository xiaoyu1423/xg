package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhAccess;
import com.xg.mall.business.service.IAccessService;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import  com.xg.mall.vo.ResponseBody;
import java.util.List;

@RestController
@RequestMapping("/manage")
public class AccessController {
    private Logger logger = Logger.getLogger(AccessController.class);
    @Autowired
   private  IAccessService iAccessService;

    //查询所有权限
    @RequestMapping(value = "/access",method = RequestMethod.GET)
    public ResponseBody select(){
        logger.info("权限控制层查询日志");
        List<XgwhAccess> list = iAccessService.select();
        return ResponseUtil.responseBody(list, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //查询单个权限
    @RequestMapping(value = "/access/{id}",method = RequestMethod.GET)
    public ResponseBody selectByPrimaryKey(@PathVariable("id") Integer id){
        logger.info("权限控制层查询单个日志");
        XgwhAccess xgwhAccess = iAccessService.selectByPrimaryKey(id);
        return ResponseUtil.responseBody(xgwhAccess, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //添加权限
    @RequestMapping(value = "/access",method = RequestMethod.POST)
    public ResponseBody add(XgwhAccess xgwhAccess){
        logger.info("权限控制层添加日志");
        boolean restult = iAccessService.add(xgwhAccess);
        return ResponseUtil.responseBody(restult,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //修改权限
    @RequestMapping(value = "/access",method = RequestMethod.PUT)
    public ResponseBody update(XgwhAccess xgwhAccess){
        logger.info("权限控制层修改日志");
        boolean restult = iAccessService.update(xgwhAccess);
        return ResponseUtil.responseBody(restult,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //权限删除
    @RequestMapping(value = "/access/{id}",method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable("id") Integer id){
        logger.info("权限控制层删除日志");
        boolean res = iAccessService.delete(id);
        return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
