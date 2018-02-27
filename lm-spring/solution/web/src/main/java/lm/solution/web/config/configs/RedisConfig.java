package lm.solution.web.config.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {

    @Value("${redis.pool.maxActive}")
    private Integer maxTotal;

    @Value("${redis.pool.maxIdle}")
    private Integer maxIdle;

    @Value("${redis.pool.testOnBorrow}")
    private Boolean testOnBorrow;

    @Value("${redis.pool.testOnReturn}")
    private Boolean testOnReturn;

    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig(){

        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(this.maxTotal);
        config.setMaxIdle(maxIdle);
        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);
        return config;
    }

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private Integer port;

    @Value("${redis.timeout}")
    private Integer timeout;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.database}")
    private Integer database;

    @Bean(name = "jedisPool")
    public JedisPool jedisPool(JedisPoolConfig config){

        return new JedisPool(
                config,
                this.host,
                this.port,
                this.timeout,
                this.password,
                this.database
        );

    }

}
