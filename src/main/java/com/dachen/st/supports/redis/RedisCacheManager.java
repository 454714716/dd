package com.dachen.st.supports.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * redis 操作
 * 
 * @author dell
 *
 */
@Component
public class RedisCacheManager {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	public String requireLock(String lockKey, long lockTimeout) {
		String identifier = UUID.randomUUID().toString();
		
		boolean getLock = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, identifier);
		if (getLock) {
			stringRedisTemplate.expire(lockKey, lockTimeout, TimeUnit.SECONDS);
			return identifier;
		}
		if (-1 == stringRedisTemplate.getExpire(lockKey)) {
			stringRedisTemplate.expire(lockKey, lockTimeout, TimeUnit.SECONDS);
		}
		return null;
	}
	
	public void realseLock(String lockKey, String identifier) {
		if (identifier.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
			stringRedisTemplate.delete(lockKey);
		}
	}
	
	public String buildKey(String... keys) {
		StringBuffer buffer = new StringBuffer();
		for (String keyPart : keys) {
			buffer.append(keyPart).append(":");
		}
		return buffer.toString();
	}
}
