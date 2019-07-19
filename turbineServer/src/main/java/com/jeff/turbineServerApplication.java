package com.jeff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Auther: tangfan
 * @Date:2019/7/14
 * @Description:com.jiefu
 * @version:1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class turbineServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(turbineServerApplication.class, args);
    }
}
