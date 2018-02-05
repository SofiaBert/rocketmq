package com.console.support;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    @Bean
    public JsonBodyExceptionResolver jsonBodyExceptionResolver() {
        return new JsonBodyExceptionResolver();
    }
}
