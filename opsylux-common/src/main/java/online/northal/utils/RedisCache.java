package online.northal.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

//@Component
public class RedisCache {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;


    public <T> void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public <T> void set(String key, T value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout);
    }

    public <T> T get(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        if (o == null) {
            return null;
        }

        return (T) o;
    }


}
