package lm.solution.boot.repository.cache;

import lm.solution.boot.entity.springdatajpa.Person;
import org.springframework.beans.factory.annotation.Autowired;
// 在 spring-boot-starter-redis 1.4.6.RELEASE 版本中才有 StringRedisTemplate 类
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class SpringDataRedisCacheRepository {

    // Spring Boot 已为我们配置 StringRedisTemplate，此处直接注入即可
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    // 使用 @Resource 注解 指定 stringRedisTemplate 可注入 redis 基于字符串的操作方法
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    // Spring Boot 已配置 RedisTemplate，此处可直接注入
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    // 使用 @Resource 注解 指定 redisTemplate 可注入 redis 基于对象的操作方法
    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps;

    public void stringRedisTemplateDemo(){

        // 存储字符串类型
        valOpsStr.set("xx","yy");

    }

    public void save(Person person){

        // 存储对象类型
        valOps.set(person.getId(),person);

    }

    public String getString(){

        // 获得字符串
        return valOpsStr.get("xx");

    }

    public Person getPerson(){

        // 获得对象
        return (Person)valOps.get("1");

    }

}
