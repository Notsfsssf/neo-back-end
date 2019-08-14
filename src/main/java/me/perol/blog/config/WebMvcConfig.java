package me.perol.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Perol
 * @Description:
 * @Date: Create in 12:24 2019/8/14
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").exposedHeaders("Authorization")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}

