package com.xg.mall.business.controller;

import com.xg.mall.po.XgwhShopGoods;
import com.xg.mall.business.service.IShopGoodsListService;
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
public class ShopGoodsListController {
    @Autowired
    private IShopGoodsListService iShopGoodsListService;
    //查询商品
    @RequestMapping(value = "/shop-goods-list",method = RequestMethod.GET)
    public ResponseBody select(){
        List<XgwhShopGoods> list = iShopGoodsListService.select();
        return ResponseUtil.responseBody(list,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

    @RequestMapping(value = "shop-goods-list/{goodsId}",method = RequestMethod.GET)
    public ResponseBody selectById(@PathVariable("goodsId") Integer goodsId){
          XgwhShopGoods res = iShopGoodsListService.selectById(goodsId);
          return ResponseUtil.responseBody(res,ExceptionCode.REQUEST_SUCCESS.getMsg(),ExceptionCode.REQUEST_SUCCESS.getCode());
    }

}
