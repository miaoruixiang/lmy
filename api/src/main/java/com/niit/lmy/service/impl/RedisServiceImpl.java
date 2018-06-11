package com.niit.lmy.service.impl;


import com.niit.lmy.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(String key, String value, long liveTime) {
        // redisTemplate.opsForValue();//操作字符串
        //  redisTemplate.opsForHash();//操作hash
        //  redisTemplate.opsForList();//操作list
        //  redisTemplate.opsForSet();//操作set
        //  redisTemplate.opsForZSet();//操作有序set

        redisTemplate.opsForValue().set(key, value, liveTime, TimeUnit.SECONDS);
    }

    /**
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key).toString();
    }

    /**
     * @param key
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }
}
