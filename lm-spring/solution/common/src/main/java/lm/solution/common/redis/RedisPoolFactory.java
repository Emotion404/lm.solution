package lm.solution.common.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class RedisPoolFactory {

    private static JedisPool jedisPool;
    static {
        ResourceBundle bundle=ResourceBundle.getBundle("redis");
        String host=bundle.getString("redis.host");
        Integer port=Integer.parseInt(bundle.getString("redis.port"));
        Integer timeout=Integer.parseInt(bundle.getString("redis.timeout"));
        String password=bundle.getString("redis.password");
        Integer db=Integer.parseInt(bundle.getString("redis.database"));
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(bundle.getString("redis.pool.maxActive")));
        config.setMaxIdle(Integer.parseInt(bundle.getString("redis.pool.maxIdle")));
        config.setMinIdle(Integer.parseInt(bundle.getString("redis.pool.minIdle")));
        config.setMaxWaitMillis(Long.parseLong(bundle.getString("redis.pool.maxWait")));
        config.setTestOnBorrow(Boolean.parseBoolean(bundle.getString("redis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.parseBoolean(bundle.getString("redis.pool.testOnReturn")));
        jedisPool=new JedisPool(config,host,port,timeout,password,db);
    }

    public Jedis getDB(){
        return jedisPool.getResource();
    }

    public void freeDB(Jedis db){
        //jedisPool.
    }

}
