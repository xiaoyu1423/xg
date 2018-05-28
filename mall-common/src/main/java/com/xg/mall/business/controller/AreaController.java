package com.xg.mall.business.controller;

import com.xg.mall.business.service.IAreaService;
import com.xg.mall.po.XgwhArea;
import com.xg.mall.vo.ResponseBody;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AreaController {
    @Autowired
    private IAreaService iAreaService;

    @RequestMapping(value = "/area/{areaParentId}", method = RequestMethod.GET)
    public ResponseBody selectArea(@PathVariable("areaParentId") Integer areaParentId) {
        List<XgwhArea> re = iAreaService.selectAreas(areaParentId);
        return ResponseUtil.responseBody(re, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
