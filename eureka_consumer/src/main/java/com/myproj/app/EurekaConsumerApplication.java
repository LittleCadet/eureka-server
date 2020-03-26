package com.myproj.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import static com.netflix.eureka.registry.PeerAwareInstanceRegistryImpl.Action.Register;

@EnableEurekaClient
//不进行自动注册
//@EnableDiscoveryClient(autoRegister=false)
@SpringBootApplication
public class EurekaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}

}
