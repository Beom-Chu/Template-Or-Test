package com.kbs.templateortest.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Test
    public void addRedisKeyTest(){

        ValueOperations<String, String> vop = redisTemplate.opsForValue();

        vop.set("key001", "first");
        vop.set("key002", "second");
        vop.set("key003", "third");

    }

    @Test
    public void getRedisKeyTest() {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();

        String key001 = vop.get("key001");
        System.out.println("[[[key001 = " + key001);

        String key002 = vop.get("key002");
        System.out.println("[[[key002 = " + key002);

        String key003 = vop.get("key003");
        System.out.println("[[[key003 = " + key003);
    }
}