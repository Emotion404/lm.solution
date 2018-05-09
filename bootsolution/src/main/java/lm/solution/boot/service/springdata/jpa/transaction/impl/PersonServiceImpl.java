package lm.solution.boot.service.springdata.jpa.transaction.impl;

import lm.solution.boot.service.springdata.jpa.transaction.PersonService;
import lm.solution.boot.entity.springdatajpa.Person;
import lm.solution.boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    // 用 rollbackFor 指定 IllegalArgumentException 异常时，数据将回滚
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithRollback(Person person) {
        Person p = personRepository.save(person);

        if (person.getName().equals("回滚test")) {
            // 手动触发异常
            throw new IllegalArgumentException("测试 with rollback，数据将回滚！");
        }

        return p;
    }

    // 用 noRollbackFor 指定 IllegalArgumentException 异常时，数据不回滚
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithoutRollback(Person person) {
        Person p = personRepository.save(person);

        if (person.getName().equals("不回滚test")) {
            // 手动触发异常
            throw new IllegalArgumentException("测试 without rollback，数据已存在，但是不回滚！");
        }

        return p;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
