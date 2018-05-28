/**
 * project: com.xg.mall
 * autho : fred
 * time: 2018-05-05
 */
package com.xg.mall.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class TestPayController {

    @RequestMapping("/")
    public String index() {
        return "Test pay";
    }
}
