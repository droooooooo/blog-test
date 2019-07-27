package com.my.blog.util;


import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * redis缓存
 *
 * @author liuyali
 * @version [版本号, 2018年11月13日]
 */

public class RedisUtil {
    /**
     * jedis 链接池
     */
    @Autowired
    private JedisPool jedisPool;




    /**
     * 保存用户
     */
    public void set(String key, String value, int seconds) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.setex(key, seconds,value);
        }
    }


    public boolean update(String key, String value, int seconds) {
        if (exists(key)) {
            set(key, value, seconds);
            return true;
        }
        return false;
    }


    public boolean update(String key, int seconds) {
        Long result = expire(key, seconds);
        return result == 1;
    }


    public String get(String key) {
        String value = "";
        try (Jedis jedis = jedisPool.getResource();) {
            value = jedis.get(key);
        }

        return value;
    }


    public void remove(String key) {
        del(key);
    }

    public boolean exists(String key) {
        try (Jedis jedis = jedisPool.getResource();) {
            return jedis.exists(key);
        }
    }

    public Long expire(String key, int expire) {
        try (Jedis jedis = jedisPool.getResource();) {
            Long result = jedis.expire(key, expire);
            return result;
        }
    }

    public void del(String key) {
        try (Jedis jedis = jedisPool.getResource();) {
            jedis.del(key);
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

}
