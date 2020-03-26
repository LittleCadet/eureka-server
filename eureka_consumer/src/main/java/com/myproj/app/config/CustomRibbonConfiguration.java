package com.myproj.app.config;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 自定义ribbon的负载均衡的规则：60%几率选择8762的端口的server，40%几率选择8763的端口的server
 * @Author LittleCadet
 * @Date 2020/2/2
 */
@Slf4j
@Configuration
//为ribbon提供全局化配置（即为对所有的eureka的虚拟主机名生效）
@RibbonClients(defaultConfiguration = CustomRibbonConfiguration.class)
public class CustomRibbonConfiguration
{
    @Bean
    public IRule customRibbonRule(){
        CustomRibbonRule customRibbonRule = new CustomRibbonRule();
        log.info("初始化customRibbonRule 成功");
        return customRibbonRule;
    }

}
