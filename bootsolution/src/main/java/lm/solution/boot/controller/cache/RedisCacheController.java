package lm.solution.boot.controller.cache;

import lm.solution.boot.entity.springdatajpa.Person;
import lm.solution.boot.repository.cache.SpringDataRedisCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springDataRedisCache")
public class RedisCacheController {

    @Autowired
    SpringDataRedisCacheRepository personDao;

    @RequestMapping("/setPerson")
    public void setPerson(){

        Person person = new Person(1L,"wyf",32);
        // 存储一个对象
        personDao.save(person);
        // 存储一个字符串
        personDao.stringRedisTemplateDemo();

    }

    @RequestMapping("/getStr")
    public String getStr(){

        // 读取一个字符串
        return personDao.getString();

    }

    @RequestMapping("/getPerson")
    public Person getPerson(){

        // 读取一个对象
        return  personDao.getPerson();

    }

}
