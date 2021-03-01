package com.imooc.seataorder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: bizy
 * @date: 2021/03/01 21:10
 */
@FeignClient(name = "seata-product", url = "http://localhost:8086")
public interface ProductFeignClient {

    @GetMapping("/deduct")
    Boolean deduct(@RequestParam Long productId,@RequestParam int count);
}
