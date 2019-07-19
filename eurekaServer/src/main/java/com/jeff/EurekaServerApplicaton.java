package com.jeff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: tangfan
 * @Description: 注册中心
 * */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplicaton {

    public static void main(String[] args){
        SpringApplication.run(EurekaServerApplicaton.class, args);
    }
}
