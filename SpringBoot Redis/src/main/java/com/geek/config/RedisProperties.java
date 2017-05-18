package com.geek.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Liuqi
 * Date: 2017/5/18.
 */
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private String host = "127.0.0.1";
    private int port = 6379;
    private String password;
    private int timeout = 1000;
    private int database = 0;
    private boolean useConnectionPool = true;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getDatabase() {
        return database;
    }

    public boolean isUseConnectionPool() {
        return useConnectionPool;
    }
}
