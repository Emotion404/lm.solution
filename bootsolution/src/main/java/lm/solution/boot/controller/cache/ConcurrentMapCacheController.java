package lm.solution.boot.controller.cache;

import lm.solution.boot.entity.springdatajpa.Person;
import lm.solution.boot.service.springdata.cache.concurrentmap.CacheConcurrentMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cache/concurrentmap")
public class ConcurrentMapCacheController {

    @Autowired
    private CacheConcurrentMapService cacheService;

    // @CachePut
    @RequestMapping(value = "/put",method = RequestMethod.PUT)
    public Person put(@RequestBody Person person){

        return cacheService.save(person);

    }

    // @Cacheable
    @RequestMapping(value = "/able",method = RequestMethod.POST)
    public Person cacheable(@RequestBody Person person){

        return cacheService.findOne(person);

    }

    // @CacheEvict
    @RequestMapping(value = "/evict",method = RequestMethod.GET)
    public String evict(Long id){

        cacheService.remove(id);
        return "OK";

    }

    //
    @RequestMapping("/alldata")
    public List<Person> allData(){

        return cacheService.allData();

    }

}




