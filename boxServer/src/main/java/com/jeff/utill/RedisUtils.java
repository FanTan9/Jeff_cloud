package com.jeff.utill;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Classname: RedisUtils
 * @PackageName: com.jeff.utill
 * @Description: TODO
 * @Date: 2019/7/19 11:17
 * @Created by: tangfan
 * @version: 1.0.0
 */
@Component
public class RedisUtils {

	@Resource
	private  RedisTemplate redisTemplate;

	/**
	 * @Desciption: 存入消息
	 *
	 */
	public void put(Object key,Object value){
		ValueOperations<Object, Object> ops = redisTemplate.opsForValue();
		ops.set(key,value);
	}

	/**
	 * @Desciption: 根据键获取数据
	 *
	 */
	public Object get(Object key){
		ValueOperations<Object, Object> ops = redisTemplate.opsForValue();
		return ops.get(key);
	}

	/**
	 * @Desciption: 存入redis 并设置过期时间
	 * @param key
	 * @param timeout
	 * @param unit
	 * @param value
	 */
	public void put(Object key, Object value, long timeout, TimeUnit unit){
		ValueOperations<Object, Object> ops = redisTemplate.opsForValue();
		ops.set(key,value,timeout,unit);
	}

	/**
	 * @Desciption: 存入redis设置多少秒过期
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public void put(Object key,Object value,long seconds){
		put(key, value, seconds, TimeUnit.SECONDS);
	}

	/**
	 * 删除对应的value
	 *
	 * @param key
	 */
	public void remove(final Object key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}


	/**
	 * 返回redis中key过期时间 key已过期返回-1
	 */
	public Long getExpire(Object key){
		return redisTemplate.getExpire(key);
	}

	/**
	 * 根据当前key和传入时间显示过期时间 key已过期返回-1
	 * @param key
	 * @param unit
	 * @return
	 */
	public long getExpire(Object key,TimeUnit unit){
		return redisTemplate.getExpire(key,unit);
	}

	/**
	 * 返回随机key
	 * @return
	 */
	public Object RANDOMKEY(){
		return redisTemplate.randomKey();
	}

	/**
	 * 判断缓存中是否有对应的key;value
	 *
	 * @param key
	 * @return
	 */
	public boolean exists(final Object key) {
		return redisTemplate.hasKey(key);
	}
}
