package com.myproj.app.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author LittleCadet
 * @Date 2020/2/2
 */
@Slf4j
public class CustomRibbonRule implements IRule
{

    @Autowired
    private SpringClientFactory factory;

    private ILoadBalancer balancer = new BaseLoadBalancer();

    /**
     * 根据端口号，筛选server
     * @param port
     */
    public Server chooseServer(List<Server> servers ,Integer port){

        if( !CollectionUtils.isEmpty(servers)){
            for(Server server : servers){
                if(port.equals(server.getPort())){
                    return server;
                }
            }
        }
        return null;
    }

    @Override
    public Server choose(Object o)
    {
        //通过BaseLoadBalancer获取所有服务器列表
        List<Server> servers =   factory.getLoadBalancer("service-provider").getAllServers();

        //设置自定义的负载均衡规则
        int count = (int)(Math.random() *10);
        if(6 >= count){
            //查询对应端口的server
            log.info("port:8762");
            return chooseServer(servers,8762);
        }else{
            //查询对应端口的server
            log.info("port:8764");
            return chooseServer(servers,8764);
        }
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer)
    {
        this.balancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer()
    {
        return null;
    }
}
