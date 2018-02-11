package lm.solution.service.impl;

import lm.solution.entity.User;
import lm.solution.mapper.UserMapper;
import lm.solution.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;
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

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }


}

