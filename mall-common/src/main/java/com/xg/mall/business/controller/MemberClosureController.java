package com.xg.mall.business.controller;

import com.xg.mall.business.service.IMemberClosureService;
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

/**
 * project:com.xg.mall
 * auto : zhaorui
 * time : 2018-5-5
 */
@RestController
@RequestMapping("/manage")
public class MemberClosureController {

    //检测日志
    private Logger logger = Logger.getLogger(MemberClosureController.class);

    @Autowired
    private IMemberClosureService iMemberClosureService;

    //查询我的团队
    @RequestMapping(value = "/descendant/{descendant}/{distance}/{page}", method = RequestMethod.GET)
    public ResponseBody selectDescendant(@PathVariable("descendant") Integer descendant, @PathVariable("distance") Integer distance, @PathVariable("page") Integer page) {
        logger.info("测试控制层会员我的团队日志");
        LinkedList list = iMemberClosureService.selectDescendant(descendant, distance, page);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }


}
