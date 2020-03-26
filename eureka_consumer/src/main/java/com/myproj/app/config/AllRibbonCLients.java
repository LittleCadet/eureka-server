package com.myproj.app.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LittleCadet
 * @Date 2020/2/2
 */
/*@Configuration*/
@RibbonClients(defaultConfiguration = DefaultRibbonClients.class)
public class AllRibbonCLients
{
    public static class BazServiceList extends ConfigurationBasedServerList{
        public BazServiceList(IClientConfig config){
            super.initWithNiwsConfig(config);
        }
    }
}

/*@Configuration*/
class DefaultRibbonClients{

    /**
     * 设置负载均衡规则为选择一个最小的并发请求的server
     * @return
     */
    /*@Bean*/
    public IRule ribbonRule(){
        return new BestAvailableRule();
    }

    /*@Bean*/
    public IPing ribbonPing(){
        return new PingUrl();
    }

    /*@Bean*/
    public ServerList<Server> ribbonServerList(IClientConfig config){
        return new AllRibbonCLients.BazServiceList(config);
    }

    /*@Bean*/
    public ServerListSubsetFilter serverListSubsetFilter(){
        return new ServerListSubsetFilter();
    }
}
