package lm.solution.web.config.beans;

import lm.solution.web.config.properties.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisBean {

    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig(){
        //
        CacheConfig cache =CacheConfig.getConfig();

        //
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(cache.getMaxTotal());
        config.setMaxIdle(cache.getMaxIdle());
        config.setTestOnBorrow(cache.getTestOnBorrow());
        config.setTestOnReturn(cache.getTestOnReturn());
        return config;
    }

    @Bean(name = "jedisPool")
    public JedisPool jedisPool(JedisPoolConfig config){
        //
        CacheConfig cache=CacheConfig.getConfig();

        //
        return new JedisPool(
                config,
                cache.getHost(),
                cache.getPort(),
                cache.getTimeout(),
                cache.getPassword(),
                cache.getDatabase()
        );
    }

}
