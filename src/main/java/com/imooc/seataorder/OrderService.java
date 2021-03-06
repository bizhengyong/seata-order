package com.imooc.seataorder;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: bizy
 * @date: 2021/02/28 16:44
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private ProductFeignClient productFeignClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @GlobalTransactional
    public Boolean create(Integer count){
        //调用product扣库存
//        String url = "http://localhost:8086/deduct?productId=5001&count="+count;
//        Boolean result = restTemplate.getForObject(url, Boolean.class);
        Boolean result = productFeignClient.deduct(5001L, count);
        if (result != null && result) {
            //可能抛出异常
            if (5 == count) {
                throw new RuntimeException("order发送异常了");
            }
            log.info("数据库开始创建订单");
            return true;
        }

        return false;
    }
}
