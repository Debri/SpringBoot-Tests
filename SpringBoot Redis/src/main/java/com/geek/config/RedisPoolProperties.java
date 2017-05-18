package com.geek.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Liuqi
 * Date: 2017/5/18.
 */
@ConfigurationProperties(prefix = "redis.pool")
public class RedisPoolProperties {
    private int maxTotal = 1 << 8;
    private int maxIdle = 1 << 5;
    private long maxWaitMills = 1000;
    private boolean testOnBorrow = true;

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public long getMaxWaitMills() {
        return maxWaitMills;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

}
