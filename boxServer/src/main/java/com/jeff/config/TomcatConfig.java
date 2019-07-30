package com.jeff.config;

import org.apache.catalina.core.AprLifecycleListener;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Classname: TomcatConfig
 * @PackageName: com.jeff1992.wsserver.config
 * @Description:
 * @Date: 2019/7/30 14:24
 * @Created by: tangfan
 * @version: 1.0.0
 */
@Component
public class TomcatConfig {

    //配置tomcat启动apr模式
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setProtocol("org.apache.coyote.http11.Http11AprProtocol");
        tomcat.addContextLifecycleListeners(new AprLifecycleListener());
        return tomcat;
    }
}
