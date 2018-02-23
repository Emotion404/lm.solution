package lm.solution.web.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lm.solution.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
public class JedisOpRedisController {

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping(
            value = "/redis/set",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String setUser(@RequestBody User user) {

        try {
            //获取Jedis对象
            Jedis jedis = jedisPool.getResource();
            String json = new ObjectMapper().writeValueAsString(user);
            //存入键值对
            jedis.set(user.getId().toString(),json);
            //回收Jedis实例
            jedis.close();

            return new ObjectMapper().writeValueAsString(user);
        }catch (JsonProcessingException jpe)
        {}

        return "{}";
    }

    @RequestMapping(
            value = "/redis/get",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String setUser(@RequestParam("id") Long id) {

            //获取Jedis对象
            Jedis jedis = jedisPool.getResource();
            //存入键值对
            String json = jedis.get(id.toString());
            //回收Jedis实例
            jedis.close();

            return json;

    }

}


