package lm.solution.web.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component(value = "dbConfig")
@PropertySource("classpath:dbconfig.properties")
public class DbConfig {

    @Value("${jdbc.url}")
    private String url;
    public String getUrl(){
        return this.url;
    }

    @Value("${jdbc.username}")
    private String username;
    public String getUsername(){
        return this.username;
    }

    @Value("${jdbc.password}")
    private String password;
    public String getPassword(){
        return this.password;
    }

    @Value("${jdbc.initialSize}")
    private Integer initialSize;
    public Integer getInitialSize(){
        return this.initialSize;
    }

    @Value("${jdbc.minIdle}")
    private Integer minIdle;
    public Integer getMinIdle(){
        return this.minIdle;
    }

    @Value("${jdbc.maxActive}")
    private Integer maxActive;
    public Integer getMaxActive(){
        return this.maxActive;
    }

    @Value("${jdbc.maxWait}")
    private Long maxWait;
    public Long getMaxWait() {
        return this.maxWait;
    }

    @Value("${jdbc.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;
    public Long getTimeBetweenEvictionRunsMillis(){
        return this.timeBetweenEvictionRunsMillis;
    }

    @Value("${jdbc.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;
    public Long getMinEvictableIdleTimeMillis(){
        return this.minEvictableIdleTimeMillis;
    }

    @Value("${jdbc.validationQuery}")
    private String validationQuery;
    public String getValidationQuery(){
        return this.validationQuery;
    }

    @Value("${jdbc.testWhileIdle}")
    private Boolean testWhileIdle;
    public Boolean getTestWhileIdle(){
        return this.testWhileIdle;
    }

    @Value("${jdbc.testOnBorrow}")
    private Boolean testOnBorrow;
    public Boolean getTestOnBorrow(){
        return this.testOnBorrow;
    }

    @Value("${jdbc.testOnReturn}")
    private Boolean testOnReturn;
    public Boolean getTestOnReturn(){
        return this.testOnReturn;
    }

    @Value("${jdbc.poolPreparedStatements}")
    private Boolean poolPreparedStatements;
    public Boolean getPoolPreparedStatements(){
        return this.poolPreparedStatements;
    }

    @Value("${jdbc.maxPoolPreparedStatementPerConnectionSize}")
    private Integer maxPoolPreparedStatementPerConnectionSize;
    public Integer getMaxPoolPreparedStatementPerConnectionSize(){
        return this.maxPoolPreparedStatementPerConnectionSize;
    }

    @Value("${jdbc.filters}")
    private String filters;
    public String getFilters(){
        return this.filters;
    }

    private final static Object object=new Object();
    private static DbConfig config;
    public static DbConfig getConfig(){
        return config;
    }

    static {
        synchronized(object) {
            AnnotationConfigApplicationContext configContext = new AnnotationConfigApplicationContext(DbConfig.class);
            config = (DbConfig) configContext.getBean("dbConfig");
        }
    }


}
