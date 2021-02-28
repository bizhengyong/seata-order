package com.imooc.seataorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: bizy
 * @date: 2021/02/28 16:47
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public Boolean create(@RequestParam Integer count){
        return orderService.create(count);
    }
}
