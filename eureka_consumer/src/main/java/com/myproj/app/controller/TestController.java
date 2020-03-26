package com.myproj.app.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author LittleCadet
 * @Date 2019/8/17
 */
@Slf4j
@RestController("client-consumer")
@RequestMapping("/eureka")
public class TestController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private SpringClientFactory factory;

    /**
     * spring用来调用restful请求
     * @return
     */
    @GetMapping("/consumer")
    public String showInfo(){
        return restTemplate.getForObject("http://service-provider/eureka/client",String.class);
    }

    /**
     * 获取服务提供者的节点信息
     * @return
     */
    @GetMapping("/node")
    public String node(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");
        log.info("serviceInstance:{}",serviceInstance);
        return restTemplate.getForObject("http://service-provider/eureka/client",String.class);
    }


}
