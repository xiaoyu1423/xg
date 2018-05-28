package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhShopCategrey;
import com.xg.mall.business.service.IShopCateService;
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
public class ShopCategreyController {
    private Logger logger = Logger.getLogger(ShopCategreyController.class);
    @Autowired
    private IShopCateService iShopCateService;

    //所有分类
    @RequestMapping(value ="/shop-categrey", method = RequestMethod.GET)
    public ResponseBody select(XgwhShopCategrey xgwhShopCategrey){
        logger.info("查询商品所有分类");
        List<XgwhShopCategrey> list = iShopCateService.select(xgwhShopCategrey);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //根据ID查分类
    @RequestMapping(value ="/shop-categrey/{cateId}", method = RequestMethod.GET)
    public ResponseBody selectById(@PathVariable("cateId") Integer cateId){
        logger.info("根据ID查商品分类");
        XgwhShopCategrey list = iShopCateService.selectById(cateId);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }


    //添加分类
    @RequestMapping(value="/shop-categrey", method =RequestMethod.POST)
    public ResponseBody insertSelective(XgwhShopCategrey xgwhShopCategrey){
        logger.info("添加商品分类");
        boolean isCreat = iShopCateService.insertSelective(xgwhShopCategrey);
        return ResponseUtil.responseBody(isCreat,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //删除分类
    @RequestMapping(value="/shop-categrey/{id}", method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable(value="id") Integer id){
        logger.info("删除商品分类");
        boolean isDel = iShopCateService.delete(id);
        return ResponseUtil.responseBody(isDel,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //修改分类
    @RequestMapping(value="/shop-categrey",method = RequestMethod.PUT)
    public ResponseBody update(XgwhShopCategrey xgwhShopCategrey){
        logger.info("修改商品分类");
        boolean isUpdate = iShopCateService.update(xgwhShopCategrey);
        return ResponseUtil.responseBody(isUpdate,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
}
