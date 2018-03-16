package com.lys.zhku.config;

import java.util.HashSet;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class CacheConfig {
	
/*	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}*/
	
	@SuppressWarnings("rawtypes")
	@Bean
	public CacheManager cacheManager(RedisOperations redisOperations) {
		RedisCacheManager manager = new RedisCacheManager(redisOperations);
		/*使用说明
		 * 
		 * 此配置是否生效取决于3,
		 * 当3为true时,redis数据库所存储的key为cacheName+前缀+key,并以前缀为缓存区标识
		 * 当3为false时,其key直接存储在redis数据库,其key会存放在'cacheName~keys'内
		 * ------错误-------但是在默认的查找缓存会遍历各个缓存区,尽管指定了cacheName,当找到了依然会
		 * ------错误-------使用所查找到的缓存值,
		 * =经验证,证实该说法=======也许是直接在redis查找,而没有通过先查找'cacheName~keys',再查找value
		 * 经过思考,两条相同key的记录插入redis,尽管'cacheName~keys'会存储各自的key(相同的值),
		 * 实际上在redis的记录只有一条,后面插入的记录覆盖了前面的,所以没有做到真正的分组
		 */ 
/*		
		//每条记录的前缀为'-',若不设置则为':'--默认分隔符
		RedisCachePrefix cachePrefix = new DefaultRedisCachePrefix("-");//1
		manager.setCachePrefix(cachePrefix);	//2
		manager.setUsePrefix(true);	//3
*/
		manager.setTransactionAware(true);//开启redis缓存事务管理
		//指定缓存区名字,会配置为静态缓存管理:操作非存在缓存区,操作无效
		//否则为动态缓存管理:操作非存在缓存区,会自动建立缓存区
		HashSet<String> cacheNames = new HashSet<String>();
		cacheNames.add("zhku");//本系统的主缓存区
		manager.setCacheNames(cacheNames);
		manager.afterPropertiesSet();//重新执行配置,使配置生效
		return manager;
	}
	
	/**
	 * 若加&ltObject,Object&gt泛型,那么匹配不了&ltString,String&gt的类型<br>
	 * 不加泛型有更好的匹配性,那么可以匹配&ltObject,Object&gt和&ltString,String&gt等<br>
	 * 
	 * @param connectionFactory
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public RedisOperations redisOperations(RedisConnectionFactory connectionFactory) {
		RedisTemplate redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}
	
	@Bean
	public RedisConnectionFactory connectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName("192.168.15.136");
		factory.afterPropertiesSet();//使配置生效
		return factory;
	}
}
