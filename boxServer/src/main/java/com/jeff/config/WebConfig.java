package com.jeff.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname: WebConfig
 * @PackageName: com.jeff.config
 * @Description: TODO
 * @Date: 2019/7/18 11:36
 * @Created by: tangfan
 * @version: 1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


	/**
	 * @Desciption: 设置返回格式为application/json
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}
}
