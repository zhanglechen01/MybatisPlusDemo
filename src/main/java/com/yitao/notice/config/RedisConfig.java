package com.yitao.notice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yitao.utils.cache.redis.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * redis 工具类
 */
@Configuration
public class RedisConfig {

    /**
     * redis 操作工具类
     *  操作对象时：例：user --> RedisUtils.template(User.class)
     * @param factory
     * @param objectMapper
     * @return
     */
    @Bean
    public RedisUtils redisUtils(RedisConnectionFactory factory, ObjectMapper objectMapper) {
        return new RedisUtils(factory, objectMapper);
    }

}
