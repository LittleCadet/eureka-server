package com.myproj.app.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LittleCadet
 * @Date 2020/2/2
 */
@Slf4j
@Configuration
//用@RiibonClient ：根据指定的eureka的虚拟主机名来实现单个ribbon的客户端的配置
//@RibbonClient(name = "service-provider" , configuration = SingleRibbonConfiguration.class)
public class SingleRibbonConfiguration
{

    /**
     * 变更负载均衡为随机
      * @return
     */
    /*@Bean*/
    public IRule ribbonRule(){
        RandomRule randomRule = new RandomRule();
        log.info("初始化randomRule成功");
        return randomRule;
    }
}
