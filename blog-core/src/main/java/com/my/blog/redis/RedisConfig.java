package com.my.blog.redis;

import com.my.blog.redis.bean.RedisProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Configuration
public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisPoolConfig jedisPoolConfig(@Value("${spring.redis.jedis.pool.max-active}") int maxActive,
                                              @Value("${spring.redis.jedis.pool.max-idle}") int maxIdle,
                                              @Value("${spring.redis.jedis.pool.max-wait}") Duration maxWait,
                                              @Value("${spring.redis.jedis.pool.min-idle}") int minIdle) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWait.toMillis());
        jedisPoolConfig.setMinIdle(minIdle);
        return jedisPoolConfig;
    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig){
        return new JedisPool(jedisPoolConfig, redisProperties.getHost(), redisProperties.getPort(), (int) redisProperties.getTimeout().toMillis(), (String) null, redisProperties.getDatabase());
    }
}
