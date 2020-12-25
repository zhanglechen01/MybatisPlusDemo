package com.yitao.notice.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;


import com.yitao.utils.component.LogInterceptor;
import com.yitao.utils.tools.LocalDateFormatter;
import com.yitao.utils.tools.LocalDatetimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * webMvc配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Bean
    LogInterceptor logInterceptor(){
        return new LogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/druid/**","/favicon.ico","/error","/actuator/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }


    /**
     * 允许跨域
     * Cors协议
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST","DELETE","PUT")
                .allowedHeaders("*")
                .allowCredentials(true).maxAge(3600);
    }

    @Bean
    public Module customModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDatetimeFormatter.LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDatetimeFormatter.LocalDateTimeDeserializer());
        module.addSerializer(LocalDate.class, new LocalDateFormatter.LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateFormatter.LocalDateDeserializer());
        return module;
    }

}
