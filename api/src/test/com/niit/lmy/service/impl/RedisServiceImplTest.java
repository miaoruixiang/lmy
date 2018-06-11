package com.niit.lmy.service.impl;

import com.niit.lmy.service.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class RedisServiceImplTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void get() {
        String code = redisService.get("code15155757885");
        System.out.println(code);
    }
}