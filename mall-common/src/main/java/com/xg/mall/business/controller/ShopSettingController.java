package com.xg.mall.business.controller;

import com.xg.mall.vo.ResponseBody;
import com.xg.mall.po.XgwhShopSetting;
import com.xg.mall.business.service.IShopSettingService;
import com.xg.utils.ExceptionCode;
import com.xg.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage")
//列表
public class ShopSettingController {
    private Logger logger = Logger.getLogger(ShopSettingController.class);
    @Autowired
    private IShopSettingService iShopSettingService;
    @RequestMapping(value = "/shop-setting",method = RequestMethod.GET)
    public ResponseBody searchShopSetting(XgwhShopSetting xgwhShopSetting){
        logger.info("查询商城设置列表");
        List<XgwhShopSetting> list = iShopSettingService.searchXgwhShopSetting(xgwhShopSetting);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //查询商城设置
    @RequestMapping(value = "/shop-setting/{id}", method = RequestMethod.GET)
    public ResponseBody searchXgwhShopSettingById(@PathVariable(value = "id") Integer id) {
        logger.info("根据ID查询商城设置列表");
        XgwhShopSetting xgwhShopSetting = iShopSettingService.searchXgwhShopSettingById(id);
        return ResponseUtil.responseBody(xgwhShopSetting, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //添加商城设置
    @RequestMapping(value = "/shop-setting", method = RequestMethod.POST)
    public ResponseBody addXgwhShopSetting(XgwhShopSetting xgwhShopSetting) {
        logger.info("添加商城设置");
        boolean isCreat = iShopSettingService.addXgwhShopSetting(xgwhShopSetting);
        return ResponseUtil.responseBody(isCreat, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //修改商城设置
    @RequestMapping(value = "/shop-setting", method = RequestMethod.PUT)
    public ResponseBody updateXgwhShopSetting(XgwhShopSetting xgwhShopSetting) {
        logger.info("修改商场设置");
        boolean isUpdate = iShopSettingService.updateXgwhShopSetting(xgwhShopSetting);
        return ResponseUtil.responseBody(isUpdate, ExceptionCode.REQUEST_SUCCESS.getMsg(), ExceptionCode.REQUEST_SUCCESS.getCode());
    }




}
