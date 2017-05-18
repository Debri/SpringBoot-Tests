package com.geek.app;


import com.geek.config.RedisPoolProperties;
import com.geek.config.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Liuqi
 * Date: 2017/5/18.
 */
@Configuration
@EnableConfigurationProperties(value = {RedisProperties.class, RedisPoolProperties.class})
public class RedisConfiguration {
    @Bean
    public JedisConnectionFactory connectionFactory(RedisProperties redisProperties) {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(redisProperties.getHost());
        connectionFactory.setPort(redisProperties.getPort());
        connectionFactory.setPassword(redisProperties.getPassword());
        connectionFactory.setDatabase(redisProperties.getDatabase());
        connectionFactory.setTimeout(redisProperties.getTimeout());
        connectionFactory.setUsePool(redisProperties.isUseConnectionPool());
        return connectionFactory;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig(RedisPoolProperties redisPoolProperties) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisPoolProperties.getMaxTotal());
        jedisPoolConfig.setMaxIdle(redisPoolProperties.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisPoolProperties.getMaxWaitMills());
        return jedisPoolConfig;
    }

}
