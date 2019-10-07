package me.perol.blog.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Cacheable(value = "token", condition = "#age!=1")
    public String getit(int age) {
        return String.valueOf(System.currentTimeMillis());
    }
}
