package com.student.accounting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author ZhongLiang.Xian
 * @ description: 配置静态资源访问
 * @ date: 2019/2/25.
 */
@Configuration
public class WebRequestConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //首页访问
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }


}
