package online.northal.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCache {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;


    public <T> void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间 (单位：毫秒)
     */
    public <T> void set(String key, T value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MILLISECONDS);
    }

    public <T> T get(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        if (o == null) {
            return null;
        }

        return (T) o;
    }
}
