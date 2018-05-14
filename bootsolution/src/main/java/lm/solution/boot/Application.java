package lm.solution.boot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.UnknownHostException;

// 开启缓存支持
@EnableCaching
@EnableTransactionManagement
@ServletComponentScan
@EnableScheduling
/**
 * spring boot 入口类
 *
 * @SpringBootApplication 是 Spring Boot 项目的核心注解，
 * 主要目的是开启自动配置
 *
 * @SpringBootApplication 组合以下注解：
 * @Configuration
 * @EnableAutoConfiguration
 * @ComponentScan
 *
 * @EnableAutoConfiguration 让 spring boot 根据类路径中的 jar 包为当前项目进行自动配置
 *
 * Spring Boot 会自动扫描 @SpringBootApplication 所在类的同级包以及下级包中的 bean
 * */
@SpringBootApplication
public class Application {

	/**
	 * 这是一个标准的 java main 方法，
	 * 主要作用是作为项目启动的入口
	 */
	public static void main(String[] args) {

		// 启动 spring boot 应用项目
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);

	}

	/**
	 * Spring Boot 自动配置的 RedisTemplate 使用的是 JdkSerializationRedisSerializer,
	 * 这个序列化器 使用 二进制 形式存储数据，
	 * 因此我们自己配置一个 RedisTemplate 并使用 Jackson2JsonRedisSerializer 以便存储 json 数据
	 * */
	@Bean
	@SuppressWarnings({"rawtypes","unchecked"})
	public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
		throws UnknownHostException{

		RedisTemplate<Object,Object> template=new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om=new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		// 设置 value 的序列化器 采用 Jackson2JsonRedisSerializer
		template.setValueSerializer(jackson2JsonRedisSerializer);
		// 设置 key 的序列化器 采用 StringRedisSerializer
		template.setKeySerializer(new StringRedisSerializer());

		template.afterPropertiesSet();
		return template;

	}

}
