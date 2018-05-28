package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhShopGoods;
import com.xg.mall.business.service.IShopGoodsService;
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
public class ShopGoodsController {
    private Logger logger = Logger.getLogger(ShopGoodsController.class);
    @Autowired
    private IShopGoodsService iShopGoodsService;

    //按条件查询
    @RequestMapping(value = "/shop-goods", method = RequestMethod.GET)
    public ResponseBody selects(XgwhShopGoods xgwhShopGoods){
        logger.info("按条件查询商品");
        List<XgwhShopGoods> list =iShopGoodsService.selects(xgwhShopGoods);
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }
    //按条件查询
    @RequestMapping(value = "/shop-goods/{id}", method = RequestMethod.GET)
    public ResponseBody setectById(@PathVariable("id") Integer id){
        logger.info("按条件查询商品单个");
        XgwhShopGoods xgwhShopGoods =iShopGoodsService.selectById(id);
        return ResponseUtil.responseBody(xgwhShopGoods,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //添加产品
    @RequestMapping(value = "/shop-goods", method = RequestMethod.POST)
    public ResponseBody insert(XgwhShopGoods xgwhShopGoods){
        logger.info("添加商品信息");
        boolean isCreat = iShopGoodsService.insert(xgwhShopGoods);
        return ResponseUtil.responseBody(isCreat,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //修改产品
    @RequestMapping(value = "/shop-goods", method = RequestMethod.PUT)
    public ResponseBody update(XgwhShopGoods xgwhShopGoods){
        logger.info("修改商品信息");
        boolean isUpdate = iShopGoodsService.update(xgwhShopGoods);
        return ResponseUtil.responseBody(isUpdate,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    //删除产品
    @RequestMapping(value = "/shop-goods/{id}", method = RequestMethod.DELETE)
    public ResponseBody delete(@PathVariable(value = "id") Integer id){
        logger.info("删除商品");
        boolean isDel = iShopGoodsService.delete(id);
        return ResponseUtil.responseBody(isDel,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());

    }

}
