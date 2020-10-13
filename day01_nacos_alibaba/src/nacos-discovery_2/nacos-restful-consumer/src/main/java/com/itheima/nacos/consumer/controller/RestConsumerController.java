package com.itheima.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class RestConsumerController {

    //要进行远程，需要知识提供方的ip和端口
    @Value("${provider.address}")
    private String provider;

    @GetMapping(value = "/service")
    public String service(){
        //远程调用
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://" + provider + "/service", String.class);
        return "consumer invode|"+result;
    }
}
