package lm.solution.boot.service.springdata.cache.concurrentmap.impl;

import lm.solution.boot.entity.springdatajpa.Person;
import lm.solution.boot.repository.PersonRepository;
import lm.solution.boot.service.springdata.cache.concurrentmap.CacheConcurrentMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Spring Boot 默认以 ConcurrentMapCacheManager 做为缓存技术
 * */
@Service
public class CacheConcurrentMapServiceImpl implements CacheConcurrentMapService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * @CachePut 缓存新增的或更新的数据到缓存，
     * value -- 名称，这里是 people
     * key -- 键值，这里是 person 的 id
     * */
    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person) {
        Person p=personRepository.save(person);
        System.out.println("为id、key为："+p.getId()+"数据做了缓存。");
        return p;
    }

    /**
     * @CacheEvict 从缓存 people 中 删除 key 为 id 的数据
     * */
    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        personRepository.delete(id);
        System.out.println("删除了id、key为："+id+"的数据缓存。");
    }

    /**
     * @Cacheable 缓存 key 为 person 的id 的数据 到缓存 people 中
     * */
    @Override
    @Cacheable(value = "people",key = "#person.id")
    public Person findOne(Person person) {
        Person p=personRepository.findOne(person.getId());
        System.out.println("为id、key为："+p.getId()+"数据做了缓存。");
        return p;
    }

    @Override
    public List<Person> allData() {

        return personRepository.findAll();

    }
}

