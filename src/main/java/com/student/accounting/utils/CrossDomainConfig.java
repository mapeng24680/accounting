package com.student.logistics.utils;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 允许跨域请求配置 ,由于浏览器同源策略产生的跨域问题解决方法
 */
@Configuration
public class CrossDomainConfig {
    public CrossDomainConfig() {
        System.out.println("CrossDomainConfig....");
    }

    /*
     * 方式一：通过CorsConfiguration和CorsFilter配置
     */

    private CorsConfiguration corsConfiguration() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        return config;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", this.corsConfiguration());
        CorsFilter corsFilter = new CorsFilter(source);
        return corsFilter;
    }

    @Bean
    public FilterRegistrationBean crosFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(corsFilter());
        registrationBean.setOrder(0);
        return registrationBean;
    }

    /*
     * 方式二：通过WebMvcConfigurer和WebMvcConfigurerAdapter配置
     */
    /*@Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings (CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
                registry.addMapping("/**").allowedMethods("POST,GET,DELETE,PUT");
                registry.addMapping("/**").allowedHeaders("access_token");
            }
        };
        return configurer;
    }*/
}
