package com.jeff;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: CommonServiceApplication
 * @Description:
 * @author: tangfan
 * @Date: 2019/7/11 0011 上午 11:39
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)
@EnableFeignClients
@EnableRabbit
@MapperScan("com.jeff.mapper")
@ComponentScan(basePackages = {"com.jeff.*"}, lazyInit = true)
public class BoxServerApplication {
    public static void main(String[] args){
        SpringApplication.run(BoxServerApplication.class,args);
    }
}
