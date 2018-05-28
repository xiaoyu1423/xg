package com.xg.mall.business.controller;

import com.xg.mall.business.service.IMemberService;
import com.xg.mall.po.XgwhMember;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
@RequestMapping("/manage")
public class MemberController {

    private Logger logger = Logger.getLogger(MemberController.class);
    @Autowired
    private IMemberService iMemberService;

    //删除用户
    @RequestMapping(value = "/member/{memberId}",method = RequestMethod.DELETE)
    public  ResponseBody delete(@PathVariable("memberId") Integer memberId){
       logger.info("后台控制器删除用户");
       boolean res = iMemberService.delete(memberId);
       return  ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //添加用户
    @RequestMapping(value = "/member",method = RequestMethod.POST)
    public  ResponseBody add(XgwhMember xgwhMember){

       logger.info("后台控制器添加用户");
       boolean res = iMemberService.add(xgwhMember);
       return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //修改用户
    @RequestMapping(value = "/member",method = RequestMethod.PUT)
    public ResponseBody update(XgwhMember xgwhMember){
        logger.info("后台控制器更新用户");
        ResponseBody res = iMemberService.update(xgwhMember);
        return res;
    }

    //按条件搜索
    @RequestMapping(value = "/members",method = RequestMethod.GET)
    public ResponseBody selectWhere(XgwhMember xgwhMember){
        logger.info("后台控制器用户查询");
        LinkedList list = iMemberService.select(xgwhMember);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "/member/{id}",method = RequestMethod.GET)
    public ResponseBody selectById(@PathVariable("id") Integer id){
        logger.info("后台控制器用户查询单个");
        XgwhMember xgwhMember= iMemberService.selectById(id);
        return ResponseUtil.responseBody(xgwhMember,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
