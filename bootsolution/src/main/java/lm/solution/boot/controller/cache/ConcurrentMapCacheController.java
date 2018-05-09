package lm.solution.boot.controller.cache;

import javafx.scene.chart.ValueAxis;
import lm.solution.boot.entity.springdatajpa.Person;
import lm.solution.boot.service.springdata.cache.concurrentmap.CacheConcurrentMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cache/concurrentmap")
public class ConcurrentMapCacheController {

    @Autowired
    private CacheConcurrentMapService cacheService;

    // @CachePut
    @RequestMapping(value = "put")
    public Person put(Person person){

        return cacheService.save(person);

    }

    // @Cacheable
    @RequestMapping(value = "/able")
    public Person cacheable(Person person){

        return cacheService.findOne(person);

    }

    // @CacheEvict
    @RequestMapping(value = "/evict")
    public String evict(Long id){

        cacheService.remove(id);
        return "OK";

    }

}




