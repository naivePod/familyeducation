package com.lgs.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Override
    @Bean
    public CacheManager cacheManager() {
        return super.cacheManager();
    }

    @Override
    public KeyGenerator keyGenerator() {
        return super.keyGenerator();
    }
}
