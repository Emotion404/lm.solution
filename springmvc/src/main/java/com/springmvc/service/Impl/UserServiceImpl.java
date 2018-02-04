package com.springmvc.service.Impl;

import com.springmvc.dao.UserMapper;
import com.springmvc.entity.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
        //return null;
    }

    @Override
    public User findById(long id) {
        //return null;

        return userMapper.findById(id);
    }

    @Override
    public boolean isUserExist(User user) {

        User userDB=userMapper.findByName(user.getName());
        if(userDB==null){
            return  false;
        }else {
            return true;
        }
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }


}
