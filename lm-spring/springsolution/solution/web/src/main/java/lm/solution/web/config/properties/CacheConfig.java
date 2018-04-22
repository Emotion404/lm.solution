package lm.solution.web.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component(value = "cacheConfig")
@PropertySource("classpath:redis.properties")
public class CacheConfig {

    @Value("${redis.pool.maxActive}")
    private Integer maxTotal;
    public Integer getMaxTotal(){
        return this.maxTotal;
    }

    @Value("${redis.pool.maxIdle}")
    private Integer maxIdle;
    public Integer getMaxIdle(){
        return this.maxIdle;
    }

    @Value("${redis.pool.testOnBorrow}")
    private Boolean testOnBorrow;
    public Boolean getTestOnBorrow(){
        return this.testOnBorrow;
    }

    @Value("${redis.pool.testOnReturn}")
    private Boolean testOnReturn;
    public Boolean getTestOnReturn(){
        return this.testOnReturn;
    }

    @Value("${redis.host}")
    private String host;
    public String getHost(){
        return this.host;
    }

    @Value("${redis.port}")
    private Integer port;
    public Integer getPort(){
        return this.port;
    }

    @Value("${redis.timeout}")
    private Integer timeout;
    public Integer getTimeout(){
        return this.timeout;
    }

    @Value("${redis.password}")
    private String password;
    public String getPassword(){
        return this.password;
    }

    @Value("${redis.database}")
    private Integer database;
    public Integer getDatabase(){
        return this.database;
    }

    private final static Object object=new Object();
    private static CacheConfig config;
    public static CacheConfig getConfig(){
        return config;
    }

    static {
        synchronized(object) {
            AnnotationConfigApplicationContext configContext = new AnnotationConfigApplicationContext(CacheConfig.class);
            config = (CacheConfig) configContext.getBean("cacheConfig");
        }
    }

}
