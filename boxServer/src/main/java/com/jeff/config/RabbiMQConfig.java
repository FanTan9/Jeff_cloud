package com.jeff.config;

import com.jeff.service.rabbitService.RabbitReceiver;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RabbiMQConfig
 * @Description: RabbitMQ配置类
 * @author: tangfan
 * @Date: 2019/7/11 0011 下午 3:01
 * @version: 1.0
 */
@Configuration
public class RabbiMQConfig {

    @Bean

    public RabbitReceiver rabbitReceiver() {
        return new RabbitReceiver();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
