package com.niit.lmy.service;


public interface RedisService {
    void set(String key, String value, long liveTime);

    String get(String key);

    void del(String key);

}
